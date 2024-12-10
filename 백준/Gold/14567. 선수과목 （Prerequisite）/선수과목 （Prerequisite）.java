//백준 14567 선수과목
import java.io.*;
import java.util.*;
public class Main {
	static int n,m;
	static List<List<Integer>> graph;
	static int [] answer;
	static boolean [] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 과목  수
		m = Integer.parseInt(st.nextToken()); // 선수 조건의 수
		graph = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			graph.get(a).add(b);
		}
		answer = new int[n+1];
		Arrays.fill(answer, 1); // 기본적으로 최소 1학기에 수강 가능
		visited = new boolean[n+1];
		for(int i=1; i<=n; i++) {
//			if(graph.get(i).size() == 0) continue;
//			Arrays.fill(visited, false);
			dfs(i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int node) {
		for (int next : graph.get(node)) {
            if (answer[next] < answer[node] + 1) {
                answer[next] = answer[node] + 1; // 선수 과목 학기 기준 업데이트
                dfs(next); // 다음 노드 탐색
            }
        }	
	}
}