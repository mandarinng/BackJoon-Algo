//백준 10282 해킹
import java.io.*;
import java.util.*;

public class Main {
	static class Virus implements Comparable<Virus>{
		int node;
		int value;
		public Virus(int node, int value) {
			this.node = node;
			this.value = value;
		}
		public int compareTo(Virus other) {
			return Integer.compare(this.value, other.value); //오름차순
		}
	}
	static int n,d,c,a,b,s;
	static List<List<Virus>> graph;
	static int [] dist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
	
		for(int tc=0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());//컴퓨터 개수
			d = Integer.parseInt(st.nextToken());//의존성 개수
			c = Integer.parseInt(st.nextToken());//해킹당한 컴퓨터 번호
			graph = new ArrayList<>(); // 컴퓨터 개수만큼
			for(int i=0; i<=n; i++) {
				graph.add(new ArrayList<>());
			}
			dist = new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			for(int di=0; di<d; di++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());//a 예비 감염자
				b = Integer.parseInt(st.nextToken());//b 보균자
				s = Integer.parseInt(st.nextToken());//b가 감염되면 s초 후 a가 감염됨
				graph.get(b).add(new Virus(a,s));
			}
			dijkstra();
			int cnt=0; // 연결된 횟수 세기
			int max = 0; // 최대 초
			for(int i=1; i<=n; i++) {
				if(dist[i] != Integer.MAX_VALUE) {
					cnt++;
					max = Math.max(max, dist[i]);
				}
			}
			sb.append(cnt).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void dijkstra() {
		PriorityQueue<Virus> pq = new PriorityQueue<>();
		pq.add(new Virus(c,0)); // 바이러스 시작 위치 넣기
		dist[c] = 0; // 시작 위치에 0초 넣기
		while(!pq.isEmpty()) {
			Virus p = pq.poll();
			for(Virus next : graph.get(p.node)) {
				if(dist[next.node] > dist[p.node]+next.value) {
					dist[next.node] = dist[p.node]+next.value;
					pq.add(new Virus(next.node, dist[p.node]+next.value));
				}
			}
		}
	}
}