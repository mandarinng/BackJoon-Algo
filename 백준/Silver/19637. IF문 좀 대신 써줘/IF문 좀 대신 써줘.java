//백준 19637번 if문좀 대신 써줘
import java.io.*;
import java.util.*;

public class Main {

	static class Pair {
		String title;
		int value;

		Pair(String title, int value) {
			this.title = title;
			this.value = value;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Pair> list = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			list.add(new Pair(s, a));
		}

		
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(br.readLine());
			int low = 0;
			int high = N - 1;

			while (low < high) {
				int mid = (low + high) / 2;

				if (list.get(mid).value >= x)
					high = mid;
				else {
					low = mid + 1;
				}
			}

			sb.append(list.get(low).title).append("\n");
		}
		System.out.println(sb.toString());

	}

}