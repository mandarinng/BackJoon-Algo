//백준 16928번 뱀과 사다리 게임
import java.io.*;
import java.util.*;

public class Main {
	
	static int [] board;
	static boolean [] visited;
	static int answer;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		board = new int[101];
		visited = new boolean[101];
		answer=0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			board[start] = end;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			board[start] = end;
		}
		bfs();
		System.out.println(answer);
	}
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				if(current == 100) return;
				for(int dice=1; dice<=6; dice++) {
					int next = current + dice;
					
					if(next > 100) {
						continue;
					}
					if(board[next] != 0) {
						next = board[next];
					}
					if(!visited[next]) {
						queue.add(next);
						visited[next] = true;
					}
				}
			}
			answer++;
		}
	}
}