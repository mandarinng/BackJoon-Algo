//백준 17835 면접보는 승범이네
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int node;
		long value; // 가중치는 long형으로 선언 (이것땜에 83% 틀림 ㅠㅠ)
		public Node(int node, long value) {
			this.node = node;
			this.value = value;
		}
		public int compareTo(Node other) {
			return Long.compare(this.value, other.value);
		}
	}
	static int n, m, k;
	static List<List<Node>> graph;
	static long [] dist; // 가중치 합이 maxvalue 넘어갈 수도 있으니까 long형 선언
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 도시의 수
		m = Integer.parseInt(st.nextToken()); // 도로의 수
		k = Integer.parseInt(st.nextToken()); // 면접장의 수
		graph = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		dist = new long[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			//단방향
			graph.get(v).add(new Node(u,c)); // 역방향 경로 저장
		}
		// 면접장들 미리 알아두기
		int [] interviews = new int[k];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			interviews[i] = Integer.parseInt(st.nextToken());
		}
		dijkstra(interviews);
		long max = 0;
		int max_node = 0;
		for(int i=1; i<=n; i++) {
			if(max < dist[i]) {
				max = dist[i];
				max_node = i;
			}
		}
		System.out.println(max_node);
		System.out.println(max);
	}
	public static void dijkstra(int [] interviews) {
		//면접장 장소들 pq에 넣어주기
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=0; i<interviews.length; i++) {
			pq.add(new Node(interviews[i], 0)); // 각 인터뷰장까지의 최단거리 = 0
			dist[interviews[i]] = 0;
		}
		//다익 한 번 돌려서 각 지점까지의 최단거리 계산하기
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int n = curr.node;
			long v = curr.value;
			if(dist[n] < v) continue; // 81% 시간초과 여기서 남!!
			for(Node next : graph.get(n)) {
				if(dist[next.node] > dist[n]+next.value) {
					dist[next.node] = dist[n]+next.value;
					pq.add(new Node(next.node, dist[n]+next.value));
				}
			}
		}
	}
}