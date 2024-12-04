//백준 14284 간선 이어가기2
import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static List<List<Node>> graph;
	static int [] dist;
	static class Node implements Comparable<Node>{
		int node;
		int value;
		public Node(int node, int value) {
			this.node = node;
			this.value = value;
		}
		public int compareTo(Node other) {
			return Integer.compare(this.value, other.value);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b,c));
			graph.get(b).add(new Node(a,c));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start, end);
		System.out.println(dist[end]);
	}
	public static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			for(Node next : graph.get(curr.node)) {
				if(dist[next.node] > dist[curr.node]+next.value) {
					dist[next.node] = dist[curr.node]+next.value;
					pq.add(new Node(next.node, dist[curr.node]+next.value));
				}
			}
		}
	}
}