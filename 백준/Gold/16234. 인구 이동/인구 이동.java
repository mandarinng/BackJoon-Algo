import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        while (true) {
            visited = new boolean[N][N]; // 매번 새로운 visited 배열 생성
            boolean isMoved = false; // 인구 이동이 발생했는지 확인하는 플래그

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) { // 인구 이동이 발생하면 플래그를 true로 설정
                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) { // 인구 이동이 발생하지 않았다면 종료
                break;
            }

            result++;
        }

        System.out.println(result);
    }

    public static boolean bfs(int row, int col) {
        ArrayList<Point> list = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        visited[row][col] = true;
        list.add(new Point(row, col));
        int sum = map[row][col];

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = p.x + dr[d];
                int nc = p.y + dc[d];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
                    int diff = Math.abs(map[nr][nc] - map[p.x][p.y]);
                    if (diff >= L && diff <= R) {
                        visited[nr][nc] = true;
                        list.add(new Point(nr, nc));
                        queue.add(new Point(nr, nc));
                        sum += map[nr][nc];
                    }
                }
            }
        }

        if (list.size() > 1) { // 인구 이동이 발생하면
            int avg = sum / list.size();
            for (Point point : list) {
                map[point.x][point.y] = avg; // 인구 이동 수행
            }
            return true;
        }

        return false;
    }
}