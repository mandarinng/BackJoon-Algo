//백준 1240 노드사이의 거리
import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int node;
		int value;

		Node(int node, int value) {
			this.node = node;
			this.value = value;
		}
	}

	static List<List<Node>> graph;
	static int sum;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, value));
			graph.get(v).add(new Node(u, value));
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			visited = new boolean[n + 1];
			dfs(start, end, 0);
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int current, int end, int sum) {
		visited[current] = true;
		if (current == end) {
			sb.append(sum).append("\n");
			return ;
		}
		for (Node n : graph.get(current)) {
			if (!visited[n.node]) {
				dfs(n.node, end, sum+n.value);
//				visited[n.node] = false;
			}
		}
	}
}