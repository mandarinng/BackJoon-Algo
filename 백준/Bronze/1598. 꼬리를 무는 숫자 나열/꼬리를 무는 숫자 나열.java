//백준 1598
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;

		int r1 = a/4;
		int c1 = a%4 - 1;
		int r2 = b/4;
		int c2 = b%4 - 1;
		
		System.out.println((Math.abs(r2-r1)+Math.abs(c2-c1)));
	}

}