//백준 1260 dfs와 bfs
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	static List<ArrayList<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}
		visited = new boolean[n + 1];
		dfs(start);
		sb.append("\n");
		bfs(start);
		System.out.println(sb.toString());
	}
	public static void dfs(int node) {
		visited[node] = true;
		sb.append(node).append(" ");

		for (int n : graph.get(node)) {
			if (!visited[n]) {
				dfs(n);
			}
		}
	}
	public static void bfs(int node) {
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		sb.append(node).append(" ");
		while (!queue.isEmpty()) {
			int p = queue.poll();
			for (int n : graph.get(p)) {
				if (!visited[n]) {
					visited[n] = true;
					sb.append(n).append(" ");
					queue.add(n);
				}
			}
		}
	}
}