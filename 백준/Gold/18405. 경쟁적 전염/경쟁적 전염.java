import java.util.*;
import java.io.*;

public class Main {

    static int N,K,X,Y,S;
    static int [][] arr;
    static PriorityQueue<Node> pq;
    static boolean [][] visited;

    public static class Node implements Comparable<Node>{
        int row;
        int col;
        int cost;//바이러스 번호


        public Node(int row, int col, int cost){
            super();
            this.col = col;
            this.row = row;
            this.cost = cost;

        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;//낮은 순서대로 pq에 넣기
        }

    }
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//N줄에 걸쳐 시험관의 정보
        K = Integer.parseInt(st.nextToken());//K이하의 바이러스 번호

        arr = new int[N][N];
        pq = new PriorityQueue<Node>();
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
//                if (arr[i][j] > 0) {
//                    pq.add(new Node(i, j, arr[i][j]));
//                    visited[i][j] = true;
//                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());//S초 후의 바이러스 번호
        X = Integer.parseInt(st.nextToken())-1;//행
        Y = Integer.parseInt(st.nextToken())-1;//열

        while(S-->0){
            if(arr[X][Y] != 0){
                break;
            }
            bfs();
        }

        System.out.println(arr[X][Y]);

    }
    public static void bfs() {

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) {
                    visited[i][j] = true;
                    pq.add(new Node(i, j, arr[i][j]));
                }
            }
        }

            while (!pq.isEmpty()) {

                Node n = pq.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = n.row + dr[d];
                    int nc = n.col + dc[d];
                    //범위내이고, 아직 전파 안됐으면 전파
                    if (nr < N && nc < N && nr >= 0 && nc >= 0 && arr[nr][nc] == 0) {
                        arr[nr][nc] = n.cost;
                        visited[nr][nc] = true;
                    }
                }


            }


        }
    }