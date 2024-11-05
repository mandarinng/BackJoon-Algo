//백준 11403 경로 찾기
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int [][] map;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean [] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					graph.get(i).add(j);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			visited = new boolean[n];
			dfs(i);
			for(int j=0; j<n; j++) {
				if(visited[j]) {
					map[i][j] = 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int node) {
		
		for(int x : graph.get(node)) {
			if(!visited[x]) {
				visited[x] = true;
				dfs(x);
			}
		}
	}
}