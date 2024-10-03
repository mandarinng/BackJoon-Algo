//백준 14425 문자열 집합
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<String> S = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			S.add(br.readLine());
		}
		int cnt=0;
		for (int i = 0; i < m; i++) {
			String word = br.readLine();
			if(S.contains(word)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}