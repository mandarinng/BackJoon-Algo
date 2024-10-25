//백준 1120 문자열
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		int answer = a.length(); //최악으로 초기값 설정
		
		for(int i=0; i<b.length() - a.length() + 1; i++) {
			int change = 0;
			for(int j=0; j<a.length(); j++) {
				if(a.charAt(j) != b.charAt(i+j)) {
					change++;
				}
			}
			answer = Math.min(change, answer);
		}
		System.out.println(answer);
	}
}