//백준 1238 파티
import java.io.*;
import java.util.*;

public class Main {
	static class Country implements Comparable<Country>{
		int destination;
		int time;

		public Country(int destination, int time) {
			this.destination = destination;
			this.time = time;
		}
		public int compareTo(Country other) {
			return Integer.compare(this.time, other.time);
		}
	}

	static int n, m, x;
	static List<List<Country>> graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // n명의 학생
		m = Integer.parseInt(st.nextToken()); // m개의 도로
		x = Integer.parseInt(st.nextToken()); // x번째 마을에서 모임

		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Country(end, time)); // 단방향 도로
		}
		// 1: x도시에서 시작해서 1~n번 도시까지의 최단거리 계산 : 다익스트라  dist0
		int [] dist0 = new int[n+1]; // x도시에서 1~n도시까지의 최단거리
		Arrays.fill(dist0, Integer.MAX_VALUE);
		dijkstra(x, dist0);
		// 각 도시에서 x도시로 이동하는 최단거리 계산 : 다익스트라 for문 돌면서 dist1[x]구하기
		int [] dist1 = new int[n+1];
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist1, Integer.MAX_VALUE);
			dijkstra(i, dist1);
			// 최소값 계산
			answer = Math.max(answer, dist0[i] + dist1[x]); // x~i번째 도시 거리 + i도시~x도시까지 거리
		}
		System.out.println(answer);
	}

	public static void dijkstra(int start, int [] dist) {
		PriorityQueue<Country> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Country(start, 0));
		
		while(!pq.isEmpty()) {
			Country c = pq.poll();
			if(c.time > dist[c.destination]) continue;
			for(Country next : graph.get(c.destination)) {
				if(dist[next.destination] > next.time + dist[c.destination]) {
					dist[next.destination] = next.time + dist[c.destination];
					pq.add(new Country(next.destination, next.time + dist[c.destination]));
				}
			}
		}
		
	}
}