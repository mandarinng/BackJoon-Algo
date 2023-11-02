import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static boolean[][] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// 가로
		M = Integer.parseInt(st.nextToken());// 세로

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;

		while (true) {

			bfs(0, 0);
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 1)
						cnt++;
				}
			}

			time++;
			if (cnt == 0)
				break;
		}

		System.out.println(time);

	}

	public static void bfs(int row, int col) {
		visited = new boolean[N][M];

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(row, col));
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if (nr < N && nc < M && nr >= 0 && nc >= 0 && !visited[nr][nc]) {
					if (board[nr][nc] == 0) {
						visited[nr][nc] = true;
						queue.add(new Point(nr, nc));
					}
				}
			}

		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == 1) {
					int cnt=0;
					for(int d=0; d<4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr < N && nc < M && nr >= 0 && nc >= 0 && visited[nr][nc] && board[nr][nc] == 0) {
							cnt++;
						}
					}
					if(cnt >= 2) {
						board[i][j] = 0;
					}
				}
				
			}
		}

	}

}