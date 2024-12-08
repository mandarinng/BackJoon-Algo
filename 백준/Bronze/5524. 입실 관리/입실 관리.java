//백준 5524 입실 관리
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			sb.append(word.toLowerCase()).append("\n");
		}
		System.out.println(sb.toString());
	}
}