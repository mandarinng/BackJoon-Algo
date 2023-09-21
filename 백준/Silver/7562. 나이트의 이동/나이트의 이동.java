import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int I;
	static int[][] chess;
	static int targetRow;
	static int targetCol;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());// tc 수
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			I = Integer.parseInt(st.nextToken());// 체스판 한 변의 길이
			chess = new int[I][I];// 체스판

			// 두 줄에 걸쳐 나이트의 시작 좌표와 목표 좌표가 주어진다.
			st = new StringTokenizer(br.readLine());
			int startRow = Integer.parseInt(st.nextToken());
			int startCol = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			targetRow = Integer.parseInt(st.nextToken());
			targetCol = Integer.parseInt(st.nextToken());

			for (int i = 0; i < I; i++) {
				for (int j = 0; j < I; j++) {
					if (i == startRow && j == startCol) {
						bfs(i, j, 1); // 말의 시작 좌표에서 bfs 시작
					}
				}
			}
			int result = 0;
			for (int i = 0; i < I; i++) {
				for (int j = 0; j < I; j++) {
					if (startRow == targetRow && startCol == targetCol) {
						result = 1;
					} else
						result = Math.max(result, chess[i][j]);
				}
			}

			System.out.println(result - 1);
		}

	}

	public static void bfs(int row, int col, int depth) {
		// 오른쪽 위부터 시계방향으로 나이트가 움직일 방향 벡터
		int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));
		chess[row][col] = depth++;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 8; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if (nr < I && nc < I && nr >= 0 && nc >= 0 && chess[nr][nc] == 0) {
					chess[nr][nc] = chess[p.x][p.y] + 1;
					queue.add(new Point(nr, nc));
				}
				if (nr == targetRow && nc == targetCol) {
					return;
				}

			}
		}
	}

}