import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int[] depth;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점의 수
		int M = Integer.parseInt(st.nextToken());// 간선의 수
		int R = Integer.parseInt(st.nextToken());// 시작 정점

		// 방문 순서를 담을 배열. 우선은 아직 방문하지 않았다는 의미로 모두 -1로 채우기
		depth = new int[N + 1];
		for(int i=1; i<N+1; i++) {
			depth[i] = -1;
		}

		// 양방향 간선을 입력받을 배열. 정점이 1부터 시작이니까 N+1크기로 만들어줌
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		// M개의 간선 (양방향 간선이니까 바꿔서도 넣어주기)
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list[u].add(v);
			list[v].add(u);
		}
		// 인점 정점을 오름차순으로 방문해야 하므로 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(list[i]);
		}
		
//		//시작 노드의 깊이는 0
//		depth[R] = 0;
		//(시작 정점, 깊이)깊이는 0부터 시작
		dfs(R,0);		

		// 깊이는 0부터인데 cnt=1부터 시작했으므로 -1 해준 값을 출력하기
		// 방문하지 않은 노드는 -1이 출력되어야 하는데 방문하지 않으면 기본값0이니까 0-1==-1
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(depth[i]).append("\n");
		}
		System.out.println(sb);

	}

	public static void dfs(int node,int d) {
		depth[node] = d;
		for (int x : list[node]) {
			if (depth[x] == -1) {
				dfs(x,d+1);
			}
		}
	}

}