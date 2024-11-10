import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int [][] map;
	static int [][][] visited; // 몇 초만에 방문했는지 int로 나타냄
	static int [] dr = {0,1,0,-1};
	static int [] dc = {1,0,-1,0}; 
	static class Point{
		int row;
		int col;
		int check;
		public Point(int row, int col, int check) {
			this.row = row;
			this.col = col;
			this.check = check;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		//visited[x][y][0]: 위치 (x, y)에 벽을 부수지 않고 도달했을 때의 방문 시간
		//visited[x][y][1]: 위치 (x, y)에 벽을 한 번 부수고 도달했을 때의 방문 시간
		visited = new int[n][m][2];
		System.out.println(bfs());
	}
	public static int bfs() {
		Queue <Point> queue = new LinkedList<>();
		visited[0][0][0] = 1; //시작점은 1초만에 방문
		queue.add(new Point(0,0,0)); //시작지점 큐에 넣기
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int broken = p.check;
			if(p.row == n-1 && p.col == m-1) {
				return visited[p.row][p.col][broken];
			}
			for(int d=0; d<4; d++) {
				int nr = dr[d] + p.row;
				int nc = dc[d] + p.col;
				
				if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
				if(map[nr][nc] == 0 && visited[nr][nc][broken] == 0) { // 아직 방문 안 한 길인 경우
					visited[nr][nc][broken] = visited[p.row][p.col][broken]+1;
					queue.add(new Point(nr, nc, broken));
				}else if(map[nr][nc] == 1 && broken == 0 && visited[nr][nc][broken] == 0){ //아직 방문하지 않은 벽을 만났고, 벽을 한 번도 안 부순 경우
					visited[nr][nc][1] = visited[p.row][p.col][broken] +1; //broken을 1로 바꿔줌!(벽 뿌!)
					queue.add(new Point(nr, nc, 1));
				}
			}
		}
		return -1;
	}
}