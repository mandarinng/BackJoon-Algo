import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] graph;
	static long [] depth;
	static long cnt;
	static long [] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점의 수
		int M = Integer.parseInt(st.nextToken()); //간선의 수
		int R = Integer.parseInt(st.nextToken()); //시작 정점
		
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		cnt=1;
		visited = new long[N+1];
		
		depth = new long[N+1];
		for(int i=0; i<N+1; i++) {
			depth[i] = -1;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		for(int i=1; i<N+1; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(R,0);
		
		long sum=0;
		for(int i=1; i<N+1; i++) {
			sum += visited[i]*depth[i];
		}
		System.out.println(sum);
	}
	public static void dfs(int node, int d) {
		visited[node] = cnt;
		depth[node] = d;
		for(int x : graph[node]) {
			if(depth[x] == -1 && visited[x] == 0) {
				cnt++;
				dfs(x, d+1);
			}
		}
	}

}