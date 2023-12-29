import java.util.*;
import java.io.*;

public class Main {

	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static int V, E, start;
	static List<Node>[] adjList;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수

		start = Integer.parseInt(br.readLine()); // 시작 정점

		// 인접한 정점과 가중치를 저장할 인접리스트 : adjList
		adjList = new ArrayList[V + 1];// 정점의 번호가 1번부터 V번까지니까
		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 최단 길이를 저장할 배열 : dist
		dist = new int[V + 1];// 정점의 번호가 1번부터 V번까지니까
		Arrays.fill(dist, Integer.MAX_VALUE); // 최단 거리를 구해야 하니까 우선 최대값으로 채워두기

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());// 시작 정점
			int B = Integer.parseInt(st.nextToken());// 도착 정점
			int W = Integer.parseInt(st.nextToken());// 가중치

			// 유향 그래프니까 단방향으로 인접리스트에 넣어주기
			adjList[A].add(new Node(B, W)); // A인덱스에 도착 정점B와 가중치를 넣기

		}
		
		dijkstra(start);
		
		for(int i=1; i<V+1; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}

	}

	public static void dijkstra(int startNode) {
		boolean[] visited = new boolean[V + 1]; // 방문 배열

		dist[startNode] = 0;// 시작정점~시작정점까지의 거리는 0

		// 선택하지 않은 정점 중 dist가 가장 작은 값을 고르기
		for (int i = 1; i < V + 1; i++) { // V까지 해도 ㄱㅊ. 어차피 마지막 노드에서는 선택할 수 있는 노드가 없으니까 V, V+1결과는 같음 픂퓨ㅠ ㅍ퓨 ㅍㅍ

			int min = Integer.MAX_VALUE;
			int idx = -1;

			for (int j = 1; j < V+1; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}

			if (idx == -1)
				break; // 연결된 간선이 없으면 break

			visited[idx] = true; // 선택

			// 현재 방문중인 정점 : curr. 여기엔 이미 나와 연결된 노드들만 들어감!
			for (Node curr : adjList[idx]) {
				// 방문하지 않았고, 연결 되어있으면서 (인접리스트라 확인하지 않아도 되긴함)
				// 이미 가지고 있는 값보다 갱신할 여지가 있으면 갱신 하기
				if (!visited[curr.v] && dist[curr.v] > dist[idx] + curr.w) {
					dist[curr.v] = dist[idx] + curr.w;
				}
			}
		}

	}

}