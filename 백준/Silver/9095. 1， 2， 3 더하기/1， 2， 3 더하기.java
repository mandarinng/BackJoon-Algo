//백준 9095 1,2,3 더하기
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		int n = 0;
		int [] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb.toString());
	}
}