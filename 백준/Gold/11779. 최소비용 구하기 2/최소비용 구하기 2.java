import java.util.*;
import java.io.*;

import java.io.BufferedReader;

public class Main {
	
	static StringTokenizer st;
	static int N,M,end;
	static List<Node>[] adjList;
	static int [] distance;
	static StringBuilder sb = new StringBuilder();
	static int [] result;
	
	public static class Node implements Comparable <Node>{
		
		int node;
		public Node(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

		int cost;
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //도시의 개수
		M = Integer.parseInt(br.readLine()); //버스의 개수
		
		adjList = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken()); //시작 노드
			int B = Integer.parseInt(st.nextToken()); //도착 노드
			int C = Integer.parseInt(st.nextToken()); //가중치
			
			adjList[A].add(new Node(B,C));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());//시작 노드
		end = Integer.parseInt(st.nextToken());//도착 노드
		
		result = new int[N+1];
		
		dijkstra(start);
		
		sb.append(distance[end]).append("\n");
		
		Stack<Integer> stack = new Stack<>();
		int n = end;
		stack.add(n);
		
		while(true) {
			stack.add(result[n]);
			n = result[n];
			if(n == start) break;
		}
		
		sb.append(stack.size()).append("\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
		
	}
	public static void dijkstra(int startNode) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		distance[startNode] = 0;
		pq.add(new Node(startNode, 0)); //큐에 시작 노드와 시작노드~시작노드까지의 이동 최소 비용
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(curr.cost > distance[curr.node]) continue;
			
			for(Node nextNode : adjList[curr.node]) {
				if(distance[nextNode.node] > distance[curr.node] + nextNode.cost) {
					distance[nextNode.node] = distance[curr.node] + nextNode.cost;
					pq.add(nextNode);
					result[nextNode.node] = curr.node;
				}
			}
		}
		
	}

}