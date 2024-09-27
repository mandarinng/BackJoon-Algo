//백준 11047 동전 0
import java.io.*;
import java.util.*;
//그리디 알고리즘
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] coins = new int[n];
		for (int i = n-1; i >= 0; i--) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int minCoinCnt = 0;
		for(int coin : coins) {
			minCoinCnt += (k/coin);
			k %= coin;
			if(k == 0) break;
		}
		System.out.println(minCoinCnt);
	}
}