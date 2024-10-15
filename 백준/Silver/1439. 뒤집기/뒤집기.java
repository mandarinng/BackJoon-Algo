//백준 1439 뒤집기
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int one = 0;
		int zero = 0;
		
		int flag = s.charAt(0)-'0';
		if(flag == 0) zero++;
		else if(flag==1)one++;
		
		for(int i=1; i<s.length(); i++) {
			int c = s.charAt(i)-'0';
			if(c != flag) {
				flag = c;
				if(c == 0) zero++;
				else one++;
			}
		}
		System.out.println(Math.min(zero, one));
	}
}