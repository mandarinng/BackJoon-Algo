//백준 1967 트리의 지름
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<List<Node>> graph;
	static boolean [] visited;
	static int answer=0;
	static int dist; // 이번 턴 가중치합
	static int max=0;
	static int first; //가장 처음 골라진 루트노드에서 가중치가 젤 높은 노드
	static class Node{
		int node;
		int value;
		public Node(int node, int value) {
			this.node = node;
			this.value = value;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			graph.get(parent).add(new Node(child, value));
			graph.get(child).add(new Node(parent, value));
		}
		visited = new boolean[n+1];
		List<Integer> leaf = new ArrayList<>(); //리프노드들만 모아둔 list
		for(int i=1; i<=n; i++) {
			if(graph.get(i).size() == 1) {
				leaf.add(i);
			}
		}
		//루트노드에서 가중치합이 젤 큰 노드 하나 찾기!
		for(int i=0; i<leaf.size(); i++) {
			Arrays.fill(visited, false);
			dfs(leaf.get(i), 1, 0);
			if(dist > max) {
				max = dist;
				first = leaf.get(i);
			}
		}
		//앞서 찾은 제일 가중치합 큰 노드에서 다른 리프노드들 까지의 가중치합이 젤 큰게 답
		for(int i=0; i<leaf.size(); i++) {
			Arrays.fill(visited, false);
			dfs(leaf.get(i), first, 0);
			answer = Math.max(answer, dist);
		}
		System.out.println(answer);
	}
	public static void dfs(int current, int end, int curr_dist) {
		if(current == end) {
			dist = curr_dist;
			return;
		}
		visited[current] = true;
		for(Node n : graph.get(current)) {
			if(!visited[n.node]) {
				dfs(n.node, end, curr_dist + n.value);
			}
		}
	}
}