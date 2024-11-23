//백준 14267 회사 문화 1
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int [] compliment;
	static List<List<Integer>> tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); // 최초의 칭찬 회수
		tree = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			tree.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			int master = Integer.parseInt(st.nextToken());
			if(master != -1) {
				tree.get(master).add(i);
			}
		}
		compliment = new int[n+1]; // 칭찬횟수
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int employee = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			// 우선 입력받은 칭찬 횟수만 먼저 저장
			compliment[employee] += value;
		}
		dfs(1, 0);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			sb.append(compliment[i]).append(" "); 
		}
		System.out.println(sb.toString());
	}
	// 현재 사원, 부모의 점수
	public static void dfs(int curr, int score) {
		compliment[curr] += score;
		for(int next : tree.get(curr)) {
			dfs(next, compliment[curr]);
		}
	}
}