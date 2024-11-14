//백준 1167 트리의 지름
import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int data;
		int value;
		public Node(int data, int value) {
			this.data = data;
			this.value = value;
		}
	}
	static boolean [] visited;
	static int n;
	static List<List<Node>> graph;
	static int max_dist = 0;
	static int far_node = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken()); // 정점 번호
			while(true) {
				int other =  Integer.parseInt(st.nextToken()); // 정점과 이어진 정점번호
				if(other == -1) break; // 종료 조건
				int dist = Integer.parseInt(st.nextToken()); // node와 other 사이의 거리
				graph.get(node).add(new Node(other, dist));
				graph.get(other).add(new Node(node, dist));
			}
		}
		visited = new boolean[n+1];
		//임의의 한 노드(나는 그냥 1로 잡음)에서 가장 거리가 먼 노드 찾기
		dfs(1,0);
//		System.out.println(far_node);
		//위에서 찾은 한 노드에서부터 가장 거리가 먼 노드 찾기
		Arrays.fill(visited, false);
		dfs(far_node, 0);
		System.out.println(max_dist);
	}
	public static void dfs(int current, int sum) {
		if(sum > max_dist) {
			max_dist = sum;
			far_node = current;
		}
		visited[current] = true;
		for(Node n : graph.get(current)) {
			if(!visited[n.data]) {
				dfs(n.data, sum + n.value);
			}
		}
	}
}