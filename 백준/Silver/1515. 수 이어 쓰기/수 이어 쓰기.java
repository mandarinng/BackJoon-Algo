//백준 1515 수 이어 쓰기
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine(); // 일부가 지워진 수의 문자열
		int str_idx = 0;
		
		int c = 0;
		while(true) {
			c++;
			String strc = Integer.toString(c);
			int c_idx = 0;
			
			while(str_idx < str.length() && c_idx < strc.length()) {
				if(str.charAt(str_idx) == strc.charAt(c_idx)) {
					str_idx++;
				}
				c_idx++;
			}
			if(str_idx == str.length()) {
				System.out.println(c);
				return;
			}
		}
	}
}