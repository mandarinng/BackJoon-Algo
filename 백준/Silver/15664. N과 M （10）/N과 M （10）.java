//백준 16236 아기 상어
import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] nums;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		result = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		visited = new boolean[n];
		

		permutation(0, 0);
		
		System.out.println(sb.toString());
	}

	public static void permutation(int start, int depth) {
		StringBuilder tmp = new StringBuilder();
		if(depth == m) {
			for(int i=0; i<m; i++) {
//				sb.append(result[i]).append(" ");
				tmp.append(result[i]).append(" ");
			}
			
			String s = tmp.toString();
			if(!set.contains(s)) {
				set.add(s);
				sb.append(s).append("\n");
			}
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = nums[i];
				permutation(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
}