//백준 12904 A와B
import java.io.*;
import java.util.*;

public class Main {
	static String s;
	static boolean isPossible;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		String t = br.readLine();
		isPossible = false;
		makingS(t);
		System.out.println(isPossible? 1 : 0);
	}
	public static void makingS(String current) {
		if(current.length() <= s.length()) {
			if(current.equals(s)) {
				isPossible = true;
			}
			return;
		}
		
		if(current.charAt(current.length()-1) == 'A') {
			makingS(current.substring(0, current.length()-1));
		}else {
			StringBuilder sb = new StringBuilder(current.substring(0, current.length()-1));
			makingS(sb.reverse().toString());
		}
	}
}