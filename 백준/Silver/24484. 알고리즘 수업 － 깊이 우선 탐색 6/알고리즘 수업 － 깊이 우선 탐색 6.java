import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] graph;
	static long [] visited;
	static long cnt;
	static long [] deptharr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		deptharr = new long[N+1];
		for(int i=0; i<N+1; i++) {
			deptharr[i] = -1;//방문하지 않은 노드의 기본 깊이는 -1
		}
		visited = new long[N+1];//방문순서 담을 배열
		cnt=1;//방문 순서
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		for(int i=0; i<N+1; i++) {//내림차순 정렬
			Collections.sort(graph[i],Collections.reverseOrder());
		}
		
		dfs(R, 0);
		long sum=0;
		for(int i=0; i<N+1; i++) {
			sum += deptharr[i] * visited[i];
		}
		System.out.println(sum);
	}
	public static void dfs(int node, int depth) {
		visited[node] = cnt++;
		deptharr[node] = depth;
		for(int x: graph[node]) {
			if(visited[x] == 0 && deptharr[x]==-1 )
			dfs(x, depth+1);
		}
	}

}