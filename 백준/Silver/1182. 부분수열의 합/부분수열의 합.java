//백준 1182 부분수열의 합
import java.util.*;
import java.io.*;

public class Main {

	static int N, S, answer;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0,0);
		
		System.out.println(S==0? answer-1 : answer);

	}

	public static void dfs(int depth, int sum) {
		if(depth == N) {
			if(sum == S) {
				answer ++;
			}
			return;
		}

		dfs(depth+1, sum+nums[depth]);
		dfs(depth+1, sum);
	}

}