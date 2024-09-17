//백준 5567 결혼식
import java.io.*;
import java.util.*;

public class Main {
	
	static List<ArrayList<Integer>> graph;
	static boolean [] visited;
	static int cnt = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());//친구 수
		
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[n+1];
		visited[1] = true;
		
		int len = Integer.parseInt(br.readLine());
		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		dfs(1, 0);
		for(int i=2; i<visited.length; i++) {
			if(visited[i])cnt++;
		}
		System.out.println(cnt);

	}
	public static void dfs(int node, int depth) {
		if(depth == 2) {
			return;
		}
		
		for(int x : graph.get(node)) {
				visited[x] = true;
				dfs(x, depth+1);
		}
	}
}