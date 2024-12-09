//백준 13023 abcde
import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static boolean answer = false;
	static boolean [] visited;
	static List<List<Integer>> graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			Arrays.fill(visited, false);
			dfs(i, 1);
			if(answer) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	public static void dfs(int node, int depth) {
		if(depth == 5) {
			answer = true;
			return;
		}
		visited[node] = true;
		for(int next : graph.get(node)) {
			if(!visited[next]) {
				dfs(next, depth+1);
			}
		}
		visited[node] = false;
	}
}