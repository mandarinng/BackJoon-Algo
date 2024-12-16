//백준 11727 2xn 타일링2
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long [] dp = new long[n+1];
		dp[0] = 0;
		if (n == 1) {
            System.out.println(1);
            return;
        }
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		System.out.println(dp[n]);
	}
}