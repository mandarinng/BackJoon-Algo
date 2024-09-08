//백준 12919 A와B2
import java.util.*;
import java.io.*;

public class Main {

	static String s, t;
	static boolean isPossible;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		s = br.readLine();
		t = br.readLine();

		makingS(t);
		System.out.println(isPossible ? 1 : 0);
	}

	public static void makingS(String current) {
		if (s.length() == current.length()) {
			if (s.equals(current)) {
				isPossible = true;
			}
			return;
		}
		
		if(current.charAt(current.length()-1) == 'A') {
			makingS(current.substring(0, current.length()-1));
		}
		if(current.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder(current.substring(1, current.length()));
            makingS(sb.reverse().toString());
		}
	}
}