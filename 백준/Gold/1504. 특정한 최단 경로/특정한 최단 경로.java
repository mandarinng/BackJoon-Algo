//백준 1504 특정한 최단 경로
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int node;
		int cost;
		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
	static int n, e;
	static List<List<Node>> graph;
	static int [] dist1;
	static int [] dist2;
	static int [] dist3;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Node(end, cost));
			graph.get(end).add(new Node(start, cost)); // 양방향
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());//꼭 들러야 하는 두 점
		int v2 = Integer.parseInt(st.nextToken());
		
		dist1 = new int[n+1]; //1에서 출발하는 dist배열
		dist2 = new int[n+1]; //v1에서 출발하는 dist배열
		dist3 = new int[n+1]; //v2에서 출발하는 dist배열
		Arrays.fill(dist1, Integer.MAX_VALUE);
		Arrays.fill(dist2, Integer.MAX_VALUE);
		Arrays.fill(dist3, Integer.MAX_VALUE);
		dijkstra(1, dist1);
		dijkstra(v1, dist2);
		dijkstra(v2, dist3);
		// 1-> v1 -> v2 -> n
		int a = dist1[v1] + dist2[v2] + dist3[n];
		// 1-> v2 -> v1 -> n
		int b = dist1[v2] + dist3[v1] + dist2[n];
		if(dist1[v1]==Integer.MAX_VALUE ||  dist2[v2]==Integer.MAX_VALUE || dist3[n]==Integer.MAX_VALUE) {
			a = Integer.MAX_VALUE;
		}
		if(dist1[v2]==Integer.MAX_VALUE ||  dist3[v1]==Integer.MAX_VALUE || dist2[n]==Integer.MAX_VALUE) {
			b = Integer.MAX_VALUE;
		}
		int answer = Math.min(a, b);
		System.out.println(answer >= Integer.MAX_VALUE ? -1 : answer);
	}
	public static void dijkstra(int start, int [] dist) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(dist[curr.node] < curr.cost) continue;
			for(Node next : graph.get(curr.node)) {
				if(dist[next.node] > next.cost + dist[curr.node]) {
					dist[next.node] = next.cost + dist[curr.node];
					pq.add(new Node(next.node, next.cost + dist[curr.node]));
				}
			}
		}
	}
}