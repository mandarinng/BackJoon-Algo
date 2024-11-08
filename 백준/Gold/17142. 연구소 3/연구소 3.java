import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int row, col, time;
        public Point(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    static int n, m;
    static int[][] map;
    static List<Point> virus;
    static int empty_cnt;
    static boolean[] visited;
    static Queue<Point> queue;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map_copy;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        virus = new ArrayList<>();
        empty_cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) empty_cnt++;
                else if (map[i][j] == 2) virus.add(new Point(i, j, 0));
                else if (map[i][j] == 1) map[i][j] = -1; // 벽은 -1로 표시
            }
        }

        visited = new boolean[virus.size()];
        map_copy = new int[n][n]; // bfs 실행 시마다 초기화만 진행하도록 함

        if (empty_cnt == 0) {
            System.out.println(0);
            return;
        }
        
        combination(0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void combination(int start, int depth) {
        if (depth == m) {
            int sec = bfs();
            answer = Math.min(answer, sec);
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int bfs() {
        queue = new LinkedList<>();

        // 매 bfs 실행 시 map_copy를 초기화하여 메모리 낭비 방지
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, map_copy[i], 0, n);
        }

        int cnt = empty_cnt;

        // 선택된 바이러스를 큐에 넣고 초기화
        for (int i = 0; i < virus.size(); i++) {
            if (visited[i]) {
                Point v = virus.get(i);
                queue.add(new Point(v.row, v.col, 0));
                map_copy[v.row][v.col] = -3; // 활성 바이러스 위치
            }
        }

        // BFS로 바이러스 확산
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = p.row + dr[d];
                int nc = p.col + dc[d];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                
                // 빈 칸일 경우
                if (map_copy[nr][nc] == 0) {
                    queue.add(new Point(nr, nc, p.time + 1));
                    map_copy[nr][nc] = p.time + 1;
                    cnt--;
                    if (cnt == 0) { // 모든 빈 칸에 바이러스가 퍼진 경우
                        return p.time + 1;
                    }
                } else if (map_copy[nr][nc] == 2) { // 비활성 바이러스인 경우
                    queue.add(new Point(nr, nc, p.time + 1));
                    map_copy[nr][nc] = -3; // 활성화된 바이러스로 변경
                }
            }
        }
        return Integer.MAX_VALUE; // 바이러스가 다 퍼지지 못한 경우
    }
}