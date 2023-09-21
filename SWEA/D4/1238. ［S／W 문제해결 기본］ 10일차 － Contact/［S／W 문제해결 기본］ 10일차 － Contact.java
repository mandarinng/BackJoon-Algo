import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static ArrayList<Integer>[] graph;
	static boolean [] visited;//각 노드가 탐색되는 깊이를 기록할 배열
	static int [] order;//방문 순서 기록할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int len = Integer.parseInt(st.nextToken());// 간선 수*2
			int startNode = Integer.parseInt(st.nextToken());// 시작 노드
			
			visited = new boolean[101];
			order = new int[101];
			
			graph = new ArrayList[101];//노드는 1번부터 100번까지 있으니까 크기101
			for(int i=0; i<101; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < (len / 2); i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				//방향이 있는 그래프
				graph[start].add(end);
			}
			
			bfs(startNode,0);//시작 노드에서 dfs 시작. 시작 노드의 깊이는 0
			int maxDepth=0;// 가장 깊은 깊이값 찾기
			for(int i=0; i<101; i++) {
				maxDepth = Math.max(maxDepth, order[i]);
			}
			
			
			int result = 0;//출력할 수
			//깊이가 가장 높은 노드중에(리프노드) 값이 가장 큰 수가 답이다.
			for(int i=0; i<101; i++) {
				if(order[i] == maxDepth) {
					result = Math.max(result, i);
				}
			}
			
			
			System.out.println("#"+tc+" "+result);
		}

	}
	
	public static void bfs(int node, int depth) {
		visited[node] = true;
		
		Queue <Integer> queue = new LinkedList<>();
		queue.add(node);
		order[node] = depth;
		while(!queue.isEmpty()) {
			int currNode = queue.poll();
			for(int x : graph[currNode]) {
				if(visited[x] == false) {
					visited[x] = true;
					queue.add(x);
					order[x] = order[currNode]+1;
				}
			}
		}
		
	}

}