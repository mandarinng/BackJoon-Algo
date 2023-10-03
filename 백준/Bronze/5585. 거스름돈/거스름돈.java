import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] coins = {500,100,50,10,5,1};

		int change = 1000-Integer.parseInt(br.readLine());
		
		int [] dp = new int[change+1];// dp[i]는 i원을 거슬러 주는데 필요한 최소 동전 개수
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		for (int i = 0; i <coins.length; i++) {
			for (int j = coins[i]; j <=change; j++) {
				dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
			}
		}
		
		System.out.println(dp[change]);
		
	}

}