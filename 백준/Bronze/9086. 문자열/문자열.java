//백준 9086 문자열
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			sb.append(word.charAt(0));
			sb.append(word.charAt(word.length()-1)).append("\n");
		}
		System.out.println(sb.toString());
	}
}