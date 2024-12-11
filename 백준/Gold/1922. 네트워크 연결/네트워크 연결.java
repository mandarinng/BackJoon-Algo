//백준 1922 네트워크 연결
import java.io.*;
import java.util.*;
public class Main {
	static class Edge implements Comparable<Edge>{
		int u;
		int v;
		int value;
		public Edge(int u, int v, int value) {
			this.u = u;
			this.v = v;
			this.value = value;
		}
		public int compareTo(Edge other) {
			return Integer.compare(this.value, other.value);
		}
	}
	static int [] parent;
	static int find(int x) {
		if(parent[x] == x) return x; // 현재 노드가 루트노드이면 그대로 반환하기(상위 루트 노드가 존재x)
		return parent[x] = find(parent[x]); // 경로 압축 : 현재 노드의 부모를 루트로 설정해 반환
	}
	static void union(int x, int y) {
		int rootX = find(x); //각각의 루트 노드를 찾기
		int rootY = find(y);
		if(rootX != rootY) { // 루트 노드가 다르다면 두 개의 집합 병합하기
			parent[rootY] = rootX; // y의 루트를 x의 루트로 설정
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		List<Edge> graph = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.add(new Edge(a,b,c));
		}
		// 크루스칼 1단계 : 간선을 정렬(오름차순)
		Collections.sort(graph);
		// 크루스칼 2단계 : n-1개의 간선을 뽑아야 하는데, 사이클이 발생하지 않도록 뽑기
		parent = new int[n+1]; // 대표(루트노드)를 저장할 배열
		for(int i=1; i<=n; i++) {
			parent[i] = i; // 우선 자신의 부모 노드는 자신
		}
		int answer = 0; // 정답으로 출력할 최소 가중치
		int edgeCnt = 0; // edgeCnt==n-1이 되면 모두 연결된 것!
		//크루스칼 3단계 : 실행
		for(Edge e : graph) {
			if(find(e.u) != find(e.v)) { // 두 정점의 대표가 다르다면
				union(e.u, e.v); // 같은 집합으로 두 정점 병합하기
				answer += e.value; // 가중치 더하기
				edgeCnt++; // 간선 수 ++
				if(edgeCnt == n-1) {
					break; // n-1개의 간선이 선택됐드면  MST가 완성된 것!
				}
			}
		}
		System.out.println(answer);
	}
}