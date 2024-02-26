import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K, S, R, C;
    static int[][] arr;
    static PriorityQueue<Node> pq;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static class Node implements Comparable<Node> {
        int row;
        int col;
        int cost; // 바이러스 번호

        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        // 바이러스 번호가 낮은 순서부터 pq에 들어가도록 정렬
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    pq.add(new Node(i, j, arr[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());//시간
        R = Integer.parseInt(st.nextToken()) - 1;//행
        C = Integer.parseInt(st.nextToken()) - 1;//열

        spreadVirus();//바이러스 확산

        System.out.println(arr[R][C]);
    }

    public static void spreadVirus() {
        //S초 만큼만 확산하기
        for (int time = 0; time < S; time++) {
            //현재 시각에 전염된 지역은 q에 임시 저장
            Queue<Node> q = new LinkedList<>();
            while (!pq.isEmpty()) {
                Node n = pq.poll();
                int r = n.row;
                int c = n.col;
                int num = n.cost;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    //범위내에 있고, 아직 확산되지 않은 지역만 확산하기
                    if (nr < N &&  nc < N && nr >= 0 && nc >= 0 && arr[nr][nc] == 0) {
                        q.add(new Node(nr, nc, num));
                        arr[nr][nc] = num;
                    }
                }
            }
            //해당 시각에 전파된 바이러스 임시큐에서 pq로 옮기기
            while (!q.isEmpty()) {
                Node temp = q.poll();
                pq.add(temp);
            }
            //1초 경과
        }
    }


}