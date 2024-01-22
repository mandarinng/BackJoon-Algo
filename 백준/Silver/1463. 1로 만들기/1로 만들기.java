import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		long [] dp = new long[N+1];
		Arrays.fill(dp, 987654321);
		
		dp[0] = 0;
		dp[1] = 0;
//		dp[2] = 1;
//		dp[3] = 1;
		
		for(int i=2; i<=N; i++) {
			
			dp[i] = dp[i-1]+1;
			
			if(i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			if(i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			
		}
		
		System.out.println(dp[N]);
		
	}

}