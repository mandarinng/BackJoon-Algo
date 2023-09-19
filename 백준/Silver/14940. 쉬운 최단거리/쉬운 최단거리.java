import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int M;
    static int [][] map;
    static int [][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//지도의 세로 크기
        M = Integer.parseInt(st.nextToken());//지도의 가로 크기
        map = new int[N][M];//입력받을 지도
        result = new int [N][M];//출력할 배열 -> 목표지점까지의 거리를 나타낸 배열;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int startRow = 0;//목표 지점의 행 좌표
        int startCol = 0;//목표지점의 열 좌표
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 2) {//목표지점을 찾으면 그 좌표 기록해두기
                    startRow=i;
                    startCol=j;
                }
                else if(map[i][j] == 1) {//길인데 끝까지 방문하지 못한 땅은 -1을 출력해야 하니까 일단 길(1)은 -1로 초기화
                    map[i][j] = -1;
                }
            }
        }
        bfs(startRow,startCol);//기록해둔 목표지점 좌표에서 bfs시작
        
        for (int i = 0; i <N; i++) {
			for (int j = 0; j <M; j++) {
				if(map[i][j]==-1 && result[i][j]==0) {
					result[i][j] = -1;
				}
				
			}
		}
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    //bfs
    public static void bfs(int row, int col) {
        boolean [][] visited = new boolean[N][M];//방문표시할 배열
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row,col));//목표지점 좌표 큐에 넣어주기
        visited[row][col] = true;//목표지점 좌표 방문표시 해주기

        int [] dr = {0,1,0,-1};
        int [] dc = {1,0,-1,0};
        //큐가 빌때까지 1,2 반복
        while(!queue.isEmpty()) {
            //1. 현재 지점의 좌표 꺼내기
            Point p = queue.poll();
            for(int d=0; d<4; d++) {
                int nr = p.x+dr[d];
                int nc = p.y+dc[d];
                //범위 내에서 아직 방문하지 않았고, 길일때(-1)
                if(nr<N && nc<M && nr>=0 && nc>=0 && visited[nr][nc] == false && map[nr][nc] == -1) {
                    visited[nr][nc] = true;//방문 표시
                    result[nr][nc] = result[p.x][p.y]+1;//거리 나타내는 배열에 목표지점까지의 거리 입력
                    queue.add(new Point(nr,nc));//2. 좌표 큐에 넣기
                }
            }
        }
        
    }

}