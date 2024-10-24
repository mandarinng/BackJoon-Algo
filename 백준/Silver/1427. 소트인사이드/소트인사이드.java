//백준 1427 소트인사이드
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		int [] n = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			n[i] = s.charAt(i) - '0';
		}
		Arrays.sort(n);
		for (int i = n.length - 1; i>=0; i--) {
			sb.append(n[i]);
		}
		System.out.println(sb.toString());
	}
}