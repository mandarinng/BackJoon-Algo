import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		parent = new int[N + 1];

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		bfs(1);
		
		for(int i=2; i<=N; i++) {
			System.out.println(parent[i]);
		}

	}

	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(node);
		visited[node] = true;

		while (!queue.isEmpty()) {
			int p = queue.poll();
			visited[p] = true;
			
			for (int x : graph[p]) {
				if (!visited[x]) {
					queue.add(x);
					parent[x] = p;
				}
			}
		}
	}

}