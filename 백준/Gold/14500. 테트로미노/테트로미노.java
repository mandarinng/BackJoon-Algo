import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int N;
    static int M;
    static boolean[][] visited;
    static int maxsum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]);
                visited[i][j] = false;
                checkException(i, j);
            }
        }

        System.out.println(maxsum);
    }

    public static void dfs(int row, int col, int cnt, int sum) {
        if (cnt == 4) {
            maxsum = Math.max(maxsum, sum);
            return;
        }

        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, cnt + 1, sum + paper[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }

    public static void checkException(int row, int col) {
        // ㅏ
        if (row - 1 >= 0 && row + 1 < N && col + 1 < M) {
            int sum = paper[row][col] + paper[row - 1][col] + paper[row + 1][col] + paper[row][col + 1];
            maxsum = Math.max(maxsum, sum);
        }
        // ㅓ
        if (row - 1 >= 0 && row + 1 < N && col - 1 >= 0) {
            int sum = paper[row][col] + paper[row - 1][col] + paper[row + 1][col] + paper[row][col - 1];
            maxsum = Math.max(maxsum, sum);
        }
        // ㅗ
        if (row - 1 >= 0 && col - 1 >= 0 && col + 1 < M) {
            int sum = paper[row][col] + paper[row - 1][col] + paper[row][col - 1] + paper[row][col + 1];
            maxsum = Math.max(maxsum, sum);
        }
        // ㅜ
        if (row + 1 < N && col - 1 >= 0 && col + 1 < M) {
            int sum = paper[row][col] + paper[row + 1][col] + paper[row][col - 1] + paper[row][col + 1];
            maxsum = Math.max(maxsum, sum);
        }
    }
}