import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		long [] dp = new long[N+1];
		
		for(int i=0; i<=N; i++) {
			dp[i] = i;// 우선 1*1이 i번 더해지는게 최대니까 최대값으로 초기화
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=1; j*j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		
		System.out.println(dp[N]);
		
	}

}