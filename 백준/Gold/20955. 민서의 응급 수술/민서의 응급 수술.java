//백준 20955 민서의 응급수술
import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static List<List<Integer>> graph;
	static int n, m;
	static int removeCnt = 0;// 지워야 할 간선 수
	static int addCnt = 0;// 더해야 할 간선 수
	static List<int[]> removeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 뉴런의 개수
		m = Integer.parseInt(st.nextToken()); // 시냅스의 개수

		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		// 1. DFS로 사이클 제거
		// 1-1. 아직 방문하지 않은 노드들부터 dfs시작해서 사이클 생기면,
		// 가장 마지막에 탐지된 간선 제거하기 (따로 삭제 리스트에 저장해뒀다가 한 번에 삭제함)
		// 1-2. parent 노드 : dfs로 탐색 중 현재 노드로 들어온 부모 노드 정보를 저장함
		visited = new boolean[n + 1];
		removeList = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i, -1); // 부모 노드가 아직 없으니까 -1로 일단 설정
			}
		}
		for(int [] edge : removeList) {
			graph.get(edge[0]).remove(Integer.valueOf(edge[1]));
            graph.get(edge[1]).remove(Integer.valueOf(edge[0]));
            removeCnt++;
		}
		
		
		// 트리의 개수를 세서 (개수-1)만큼 시냅스 수 더하기
		Arrays.fill(visited, false);
		for (int i = 1; i <= n; i++) {
			if(!visited[i]) {
				addCnt++;
				countTree(i);
			}
		}
		//양방향 간선이라 removeCnt가 두 배이므로 반으로 나눠주기
		System.out.println((addCnt-1)+(removeCnt/2)); 
	}
	// 이미 방문한 노드를 다시 만났을 때,
	// 1. 사이클 때문에 만나는지, 2. 단순히 부모 노드로 돌아온건지(양방향 간선이라 발생함) 구분하기위해 paent 변수 필요
	public static void dfs(int curr, int parent) {
		visited[curr] = true;
//		System.out.println(curr);
		for (int n : graph.get(curr)) {
			if (!visited[n]) {
				dfs(n, curr);
			} else { // 방문했던 노드가 1.사이클 발생인지 2.부모노드인지 판단하기
				if (n != parent) { // 1.사이클이 발생한 경우 : 연결 끊기!
					removeList.add(new int[] {n, curr});
//					System.out.println(n+" "+curr);
				} else { // 2. 부모노드로 돌아온 경우 사이클 아님: pass
					continue;
				}
			}
		}
	}
	public static void countTree(int node) {
		visited[node] = true;
		for(int n : graph.get(node)) {
			if(!visited[n]) {
				countTree(n);
			}
		}
	}
}