//백준 16236 아기 상어
import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int [] nums;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int [m];
		
		visited = new boolean[n+1];
		
		permutation(0);
		
		System.out.println(sb.toString());
	}
	public static void permutation(int depth) {
		if(depth == m) {
			for(int i=0; i<m; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<n+1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				nums[depth] = i;
				permutation(depth+1);
				visited[i] = false;
			}
		}
	}
	
}