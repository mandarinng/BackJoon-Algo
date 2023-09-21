import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int [][] tomato;//입력받을 토마토가 들어있는 상자
	static boolean[][] visited;//방문표시 배열
	static int [][] day;//각 칸의 토마토가 익어가는 날짜를 기록할 배열
	static Queue<Point> queue;//익은 토마토(입력이 1)가 있는 좌표들을 넣을 큐 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());// 상자 세로
        m = Integer.parseInt(st.nextToken());// 상자 가로
        
        tomato = new int[m][n];// 토마토가 있는 상자
        // 토마토 상자 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[m][n];
        day = new int[m][n];
        //큐에 익은 토마토가 있는 칸의 좌표 기록
        queue = new LinkedList<>();
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(tomato[i][j] == 1) {
        			queue.add(new Point(i,j));
        			visited[i][j] = true;
        			day[i][j] = 0;
        		}
        	}
        }
        
        bfs();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else {
                    continue;
                }
            }
        }
        int Maxdepth = 0;
        for (int i = 0; i <m; i++) {
            for (int j = 0; j <n; j++) {
                Maxdepth = Math.max(Maxdepth, day[i][j] );
            }
        }
        System.out.println(Maxdepth);
        
	}
	public static void bfs() {
		
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.x+dr[d];
				int nc = p.y+dc[d];
				if(nr<m && nc<n && nr>=0 && nc>=0 && visited[nr][nc]==false && tomato[nr][nc]==0) {
					tomato[nr][nc] = 1;
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc));
					day[nr][nc] = day[p.x][p.y]+1;
				}
			}
			
		}
	}

}