import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean [] visited;//방문을 표시할 배열
	static ArrayList<Integer>[] graph;//간선의 관계를 표시할 리스트
	static int [] result;//각 노드가 몇 번째로 탐색되는지 작성할 배열(출력할 배열)
	static int cnt=1;//방문 순서를 나타내는 변수.순서는 1부터 시작

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//정점의 수
		int M = Integer.parseInt(st.nextToken());//간선의 수
		int R = Integer.parseInt(st.nextToken());//시작 정점
		//노드가 1번부터 시작되니까 n+1크기로 만들기
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		result = new int [N+1];
		//양방향 간선 입력받아서 리스트에 넣기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		//오름차순으로 노드를 방문하므로 오름차순 정렬
		for(int i=1; i<N+1; i++) {
			Collections.sort(graph[i]);
		}
		//시작정점부터 bfs시작
		bfs(R);
		//스빌에 담아서 한번에 출력
		StringBuilder sb = new StringBuilder();
		//1~N번 노드의 방문 순서 출력하기
		for(int i=1; i<=N; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
		
	}
	public static void bfs(int node) {
		visited[node] = true;// 현재 노드 방문했다고 표시하기
		//bfs는 queue를 사용해서 푸는데, 자바에서 queue는 링크드리스트로 구현함
		Queue<Integer> queue = new LinkedList<>();
		//우선 (시작)노드를 큐에 넣음
		queue.add(node);
		//방문 순서를 나타내야 하므로 result배열에 현재 노드의 순서를 기록함
		result[node] = cnt++;
		//큐가 비어있지 않을때까지 1번과 2번 반복하기
		while(!queue.isEmpty()) {
			// 1) 맨 처음 등록되었던 노드를 뽑아냄
			int currNode = queue.poll();
			// 2) 뽑아낸 노드와 연결되어 있던 노드들 중에 아직 방문하지 않은 노드를 찾아 방문표시 해주고, 큐에 넣기
			for(int x : graph[currNode]) {
				if(!visited[x]) {
					visited[x] = true;
					queue.add(x);
					result[x] = cnt++;//큐에 들어간 순서대로 뽑힐거니까 큐에 삽입될 때 방문 순서 기록하기
				}
				
			}
		}
		
	}

}