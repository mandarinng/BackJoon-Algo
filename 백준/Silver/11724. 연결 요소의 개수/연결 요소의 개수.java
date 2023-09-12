import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static boolean [] visited;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 수
		// 간선을 나타낼 리스트 배열
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		//해당 노드를 방문했는지 표시할 배열
		visited = new boolean[N+1];
		 
		//간선 입력받아서 리스트에 넣어 연결된 것 표현하기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());//간선 시작점
			int end = Integer.parseInt(st.nextToken());//간선 끝점
			
			list[start].add(end);
			list[end].add(start);
		}
		//출력할 숫자. 연결 요소의 개수
		int cnt=0;
		
		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}
	public static void dfs(int node) {
		visited[node] = true;
		for(int x:list[node]) {
			if(!visited[x]) {
				dfs(x);
			}
		}
	}

}