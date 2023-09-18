import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static ArrayList<Integer>[] graph;//간선을 나타내는 리스트
	static boolean [] visited;//노드를 방문했는지 표시할 배열
	static int maxcnt;// 최장 경로(거쳐가는 노드의 수)
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); //1~N 정점의 개수
			int M = sc.nextInt(); //M개의 간선
			
			//간선의 정보를 담을 리스트
			graph = new ArrayList[N+1]; // 정점이 1번부터 시작하니까  노드의 수 +1 크기로 만들기
			for(int i=0; i<N+1; i++) {
				graph[i] = new ArrayList<>();
			}
			visited = new boolean[N+1];// 정점이 1번부터 시작하니까  노드의 수 +1 크기로 만들기
			
			for(int i=0; i<M; i++) {
				int st = sc.nextInt(); //시작 정점
				int end = sc.nextInt();//끝 정점
				
				graph[st].add(end);
				graph[end].add(st); //무방향 그래프니(==양방향)까 양쪽 방향에서 모두 값을 넣어줘야 한다. 
			}
			maxcnt = 0;//출력할 최장 경로
			//노드는 1번부터니까 1부터 돌기
			for(int i=1; i<N+1; i++) {
//				cnt=0;//새로운 노드부터 시작할때 거쳐간 노드의 수 초기화
				dfs(i,1);//dfs시작. i노드이 경로의 수를 셀 것임. 일단 i번째 노드를 거쳐서 시작하니까 거쳐간 경로의 수는 1
			}
			
			System.out.println("#"+tc+" "+maxcnt);
		}
	}
	//(시작 노드, 거쳐간 노드의 개수)
	public static void dfs(int node,int cnt) {
		visited[node] = true;//거쳐간 노드 표시해주기
		
		maxcnt = Math.max(maxcnt, cnt);//최장 경로 갱신
		
		for(int x : graph[node]) {
			if(!visited[x]) {//거쳐가지 않은 노드만 dfs하기
				dfs(x, cnt+1);//노드 수 하나 거쳐갈때마다 ++ 해주기
			}
		}
		visited[node] = false;//dfs다 돌고 나면 방문했던 기록 초기화하기
	}

	
	
}