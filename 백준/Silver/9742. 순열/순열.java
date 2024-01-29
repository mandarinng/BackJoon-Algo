import java.util.*;
import java.io.*;

public class Main {

	static List<Character> list;
	static String str;
	static int N, count;
	static boolean[] visited;
	static char [] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = br.readLine() )!= null) {
			StringTokenizer st = new StringTokenizer(line);

			str = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			visited = new boolean[str.length()];
			// 문자열은 정렬 어떻게 하더라(어차피 사전순이니까..)
			count = 0;
			arr = new char[str.length()];
			combination(0);
			if (count < N)
				System.out.println(str+" "+N+" = No permutation");
		}

	}

	public static void combination(int cnt) {

		if (cnt == str.length()) {
			count++;
			if (count == N) {
				System.out.print(str+" "+N+" = ");
				for (char c : arr) {
					System.out.print(c);
				}
				System.out.println();
			}
			return;

		}

		for (int i = 0; i < str.length(); i++) {
			if (!visited[i]) {
				visited[i] =true;
				arr[cnt] = str.charAt(i);
				combination(cnt + 1);
				visited[i] = false;

			}
		}
	}

}