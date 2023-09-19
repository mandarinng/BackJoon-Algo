import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int cnt=1;
	static int N;
	static int M;
	static int [][] maze;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
 			for(int j=0; j<M; j++) {
				maze[i][j] = input.charAt(j)-'0';
			}
		}
		int result = bfs(0,0);
		System.out.println(result);

	}
	public static int bfs(int row, int col) {
		boolean [][] visited = new boolean[N][M];//방문처리
		int [][] copymaze = new int[N][M];
		visited[row][col] = true;//0,0 방문처리
		copymaze[row][col] = cnt++;
		Queue <Point> queue = new LinkedList<>();
		queue.add(new Point(row,col));
		
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();//큐에서 x,y좌표 꺼내기
			for(int d=0; d<4; d++) {
				int nr = p.x+dr[d];
				int nc = p.y+dc[d];
				//범위를 벗어나지 않고, 아직 방문하지 않은, 미로에서 이동할 수 있는 칸(1)을 만나면 이동하기
				if(nr<N && nc<M && nr>=0 && nc>=0 && visited[nr][nc] == false && maze[nr][nc]==1) {
					visited[nr][nc] = true;//방문 표시
					copymaze[nr][nc] = copymaze[p.x][p.y]+1;
					queue.add(new Point(nr,nc));//이동한 위치의 좌표 큐에 넣기
				}
				if(nr==N-1 && nc==M-1) {
					return copymaze[nr][nc];
				}
			}
		}
		
		return 0;
	}

}