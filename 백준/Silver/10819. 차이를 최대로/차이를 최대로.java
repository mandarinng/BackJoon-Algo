//백준 10819 차이를 최대로
import java.io.*;
import java.util.*;

public class Main {
	static int max = -987654321;
	static int n;
	static int [] nums;
	static boolean [] visited;
	static int [] result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		nums = new int[n];
		result = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0);
		System.out.println(max);
	}
	public static void combination(int depth) {
		if(depth == n) {
			int c = calculate();
			if(c > max) max = c;
//			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = nums[i];
				combination(depth+1);
				visited[i] = false;
			}
		}
	}
	public static int calculate() {
		int sum = 0;
		for(int i=0; i<n-1; i++) {
			sum += Math.abs(result[i] - result[i+1]);
		}
//		System.out.println(sum);
		return sum;
	}

}