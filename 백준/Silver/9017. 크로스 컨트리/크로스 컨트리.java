//백준 9017번 크로스 컨트리
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {

			int N = Integer.parseInt(br.readLine());
			int[] input = new int[N];
			int[] result = new int[N];
			int max = -1;

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(st.nextToken());
				max = Math.max(input[j], max);
			}

			for (int j = 1; j <= max; j++) {
				int cnt = 0;
				for (int k = 0; k < N; k++) {
					if (j == input[k]) {
						cnt++;
					}
				}
				if (cnt < 6) {
					for (int k = 0; k < N; k++) {
						if (j == input[k]) {
							result[k] = -1;
						}
					}
				}
			}

			int number = 1;
			for (int j = 0; j < N; j++) {
				if (result[j] != -1) {
					result[j] = number++;
				}
			}

			int min = 987654321;
			int team = 0;
			int[] fifth = new int[max + 1];
			Arrays.fill(fifth, 987654321);
			for (int j = 1; j <= max; j++) {
				int cnt = 0;
				int sum = 0;
				for (int k = 0; k < N; k++) {
					if (j == input[k]) {
						cnt++;
						if (cnt <= 4) {
							sum += result[k];
						} else if (cnt == 5) {
							fifth[j] = result[k];
						} else {
							break;
						}
					}
				}
				if (cnt >= 6) {
					if (min > sum) {
						min = sum;
						team = j;
					} else if (min == sum) {
						if (fifth[team] > fifth[j]) {
							team = j;
						}
					}
				}
			}
			sb.append(team).append("\n");
		}
		System.out.println(sb.toString());
	}

}