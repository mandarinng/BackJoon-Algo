//백준 1205 등수 구하기
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] score = new int[N];

		int ts = Integer.parseInt(st.nextToken());// 태수 점수
		int cnt = Integer.parseInt(st.nextToken());// 랭킹 리스트에 올라 갈 수 있는 점수의 개수

		if (N == 0) {
			System.out.println(1);
			return;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}

		if(score.length == cnt && ts <= score[N-1]) {
			System.out.println(-1);
			return;
		}
		int rank = 1;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < score.length; i++) {

			if (score[i] > ts) {
				rank++;
			} else if (score[i] == ts) {
				if (i + 1 >= cnt) {
					sb.append(-1);
					break;
				} else {
					sb.append(rank);
					break;
				}
			} else {
				sb.append(rank);
				break;
			}
		}
		if(sb.length() == 0) {
			sb.append(rank);
		}
		System.out.println(sb.toString());
	}
}