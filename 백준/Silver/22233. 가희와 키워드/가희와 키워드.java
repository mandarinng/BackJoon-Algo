//백준 22233
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken()); // 메모장 단어 수
		int m = Integer.parseInt(st.nextToken()); // 블로그 글 수

		Set<String> note = new HashSet<>();
		List<String> trash = new ArrayList<>();
		int cnt = 0; // 글의 수

		for (int i = 0; i < n; i++) {
			note.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			String[] words = br.readLine().split(","); // ',' 기준으로 단어 분리

			for (String word : words) {
				note.remove(word); // 사용된 단어는 note에서 제거
			}
			sb.append(note.size()).append("\n");
		}
		System.out.println(sb.toString());
	}
}