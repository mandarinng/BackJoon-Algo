//백준 13305 주유소
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//도시의 수
		int [] weight = new int[N-1]; //두 도시를 연결하는 도로의 가중치
		int [] oil = new int[N];// 각 도시별 기름값
		int [] dp = new int[N];//각 도시까지의 최소 기름값 합산 배열
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < weight.length; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < oil.length; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = oil[0];// 지금까지의 도시 중 기름값이 가장 최소인 가격
		dp[0] = 0;//첫 번째 도시는 0리터로 갈 수 있음
		
		for(int i=1; i<N; i++) {
			min = Math.min(min, oil[i-1]);//최소 오일값 갱신
			dp[i] = Math.min(dp[i-1]+oil[i-1]*weight[i-1], dp[i-1]+min*weight[i-1]);
		}
		System.out.println(dp[N-1]);
	}

}