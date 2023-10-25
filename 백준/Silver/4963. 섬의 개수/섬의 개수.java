import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] island;
	static boolean[][] visited;
	static int W, H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken()); // 섬 세로
			H = Integer.parseInt(st.nextToken()); // 섬 가로
			int result = 0;
			if (H == 0 && W == 0)
				break;

			island = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					island[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (island[i][j] == 1 && !visited[i][j]) {
//						System.out.println(i+" "+j);
						dfs(i, j);
						result++;
					}
				}
			}
			System.out.println(result);
		}

	}

	public static void dfs(int row, int col) {
		visited[row][col] = true;

		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int d = 0; d < 8; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			if (nr < H && nc < W && nr >= 0 && nc >= 0 && !visited[nr][nc] && island[nr][nc] == 1) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}

	}

}
