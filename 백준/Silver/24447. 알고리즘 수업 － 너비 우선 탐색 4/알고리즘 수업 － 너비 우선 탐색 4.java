import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] graph; // 그래프를 표현하는 ArrayList 배열
    static boolean[] visited; // 방문 여부를 나타내는 배열
    static long[] depthArr; // 각 노드의 깊이(거리)를 나타내는 배열
    static long[] orderArr; // 각 노드의 방문 순서를 나타내는 배열 - depth와 곱할 것.
    static long cnt=1;//방문 순서를 나타내는 변수
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//노드의 수
		int M = Integer.parseInt(st.nextToken());//간선의 수
		int R = Integer.parseInt(st.nextToken());//시작 노드
		graph = new ArrayList[N+1]; //노드 번호가 1부터 시작하므로 N+1 크기로 생성
		visited = new boolean[N+1];
		depthArr = new long [N+1];
		orderArr = new long [N+1];
		
		// 그래프 초기화
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		 // 양방향 간선 입력받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
			
		}
		//정점 번호를 오름차순으로 정렬
		for(int i=0; i<N+1; i++) {
			Collections.sort(graph[i]);
		}
		for(int i=1; i<N+1; i++) {
			depthArr[i] = -1; //방문하지 않은 노드는 -1이므로 일단 -1로 초기화
		}
		bfs(R,0);//시작노드부터 BFS탐색 시작. 시작 노드의 깊이는 0
		long result = 0;
		for(int i=1; i<N+1; i++) {
			result +=depthArr[i]*orderArr[i];
		}
		System.out.println(result);
	}
	public static void bfs(int node, int depth) {
		visited[node] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		orderArr[node] = cnt++;//현재 노드의 방문 순서 기록.순서는 계속 올라가니까 ++ 해주기
		depthArr[node] = depth;//현재 노드의 깊이를 기록
		// 현재 노드와 연결된 인접 노드들을 방문하며 깊이를 설정
		while(!queue.isEmpty()) {
			int currNode = queue.poll();
			for(int x : graph[currNode]) {
				if(!visited[x]) {
					visited[x] = true;
					queue.add(x);
					orderArr[x] = cnt++;//방문 순서 기록
					depthArr[x] = depthArr[currNode]+1;// 현재 노드의 깊이에 1을 더함
				}
			}
		}
	}

}