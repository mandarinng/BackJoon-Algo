//백준 2660 회장뽑기
import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static List<List<Integer>> graph;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		while (true) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			if (a == -1 && b == -1)
				break;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		int minScore = Integer.MAX_VALUE;
		visited = new boolean[n + 1];
		int[] scores = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(visited, false);
			scores[i] = bfs(i);
			if (scores[i] != Integer.MAX_VALUE) {
				minScore = Math.min(minScore, scores[i]);
			}
		}
		ArrayList<Integer> candidate = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (scores[i] == minScore) {
				candidate.add(i);
			}
		}
		sb.append(minScore).append(" ").append(candidate.size()).append("\n");
		for (int i = 0; i < candidate.size(); i++) {
			sb.append(candidate.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}
	public static int bfs(int curr) {
		Queue<Integer> queue = new LinkedList<>();
		visited[curr] = true;
		queue.add(curr);
		int cnt = n - 1;
		int score = 0;
		while (!queue.isEmpty()) {
			score++;
			int size = queue.size();
			while (size-- > 0) {
				int p = queue.poll();
				for (int n : graph.get(p)) {
					if (!visited[n]) {
						visited[n] = true;
						queue.add(n);
						cnt--;
					}
				}
			}
		}
		if (cnt == 0) { // 다 이어졌을 때
			return score-1; // 마지막 증가된 score 조정
		} else { // 다 안이어졌을 때
			return Integer.MAX_VALUE;
		}
	}
}