import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();	 
		String a = br.readLine();	
		StringTokenizer st = new StringTokenizer(s);
		StringTokenizer sk = new StringTokenizer(a);
		int l = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int realpeople = l * p;			
		ArrayList<Integer> newspeople = new ArrayList<Integer>();		
		for (int i = 0; i < 5; i++) {
			newspeople.add(Integer.parseInt(sk.nextToken()));
		}	
		for (int i : newspeople) {	
			System.out.print(i - realpeople + " ");
		}
	}
}