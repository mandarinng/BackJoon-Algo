import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static int result;
	static boolean [] visited;
	static ArrayList<Integer>[] graph;
	static int start;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();// 정점의 개수
			int M = sc.nextInt();// 간선의 개수
			
			graph = new ArrayList[N+1];
			for(int i=0; i<N+1; i++) {
				graph[i] = new ArrayList<>();
			}

			for(int i=0; i<M; i++) {
				int st = sc.nextInt();
				int end = sc.nextInt();
				
				graph[st].add(end);
				graph[end].add(st);
			}

			result = 0;
			
			for(int i=1; i<N+1; i++) {
				start=i;
//				visited[i] = true;
				dfs(i,1);
//				visited[i] = false;
			}
			System.out.println("#"+tc+" "+result);
		}

	}
	public static void dfs(int node, int cnt) {

		if(cnt==3 && find(graph[node], start)) {
			result++;
			return;
		}
		else if(cnt>3) {
			return;
		}
		
//		System.out.println(N);
		for(int i=node+1; i<N+1; i++) {
//			System.out.println(i);
			if(find(graph[node], i)) {
//				visited[i] = true;
				dfs(i,cnt+1);
//				visited[i] = false;
			}
		}
	}
	public static boolean find(ArrayList<Integer> list, int node) {
		for(int x: list) {
			if(x == node) {
				return true;
			}
		}
		return false;
	}

}