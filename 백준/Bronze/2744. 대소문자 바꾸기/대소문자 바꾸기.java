//백준 2744 대소문자 바꾸기
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(Character.isUpperCase(c)) {
				sb.append(Character.toLowerCase(c));
			}else {
				sb.append(Character.toUpperCase(c));
			}
		}
		System.out.println(sb.toString());
	}
}