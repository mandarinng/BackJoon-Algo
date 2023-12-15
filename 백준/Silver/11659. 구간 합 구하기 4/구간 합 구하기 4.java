import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<sum.length; i++) {
			int a = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + a;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(sum[end] - sum[start-1]).append("\n");
			
		}
		
		System.out.println(sb);
	}

}