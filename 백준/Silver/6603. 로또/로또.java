//백준 16236 아기 상어
import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int [] nums;
	static boolean [] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			
			nums = new int[n];
			visited = new boolean[n];
			
			for(int i=0; i<n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			combination(0,0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	public static void combination(int start, int depth) {
		if(depth == 6) {
			for(int i=0; i<n; i++) {
				if(visited[i]) {
					sb.append(nums[i]).append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		//조합
		for(int i=start; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
}