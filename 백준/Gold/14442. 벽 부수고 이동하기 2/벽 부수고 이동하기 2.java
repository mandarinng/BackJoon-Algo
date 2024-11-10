//백준 14442 벽 부수고 이동하기2
import java.io.*;
import java.util.*;

public class Main {
	static int n,m,k;
	static int [][] map;
	static int [][][] visited;
	static int [] dr = {0,1,0,-1};
	static int [] dc = {1,0,-1,0};
	static class Point{
		int row;
		int col;
		int broken;
		public Point(int row, int col, int broken) {
			this.row = row;
			this.col = col;
			this.broken = broken;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		visited = new int[n][m][k+1];
		System.out.println(bfs());
	}
	public static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0,0)); 
		visited[0][0][0] = 1;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.row == n-1 && p.col == m-1) {
				return visited[p.row][p.col][p.broken];
			}
			int broken = p.broken;
			for(int d=0; d<4; d++) {
				int nr = dr[d] + p.row;
				int nc = dc[d] + p.col;
				if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
				//방문안한 빈 칸
				if(map[nr][nc]==0 && visited[nr][nc][broken]==0) {
					queue.add(new Point(nr, nc, broken));
					visited[nr][nc][broken] = visited[p.row][p.col][broken]+1;
				}
				//방문안하고 아직 k만큼 안 뚫었을 때 벽
				else if(map[nr][nc]==1 && broken<k && visited[nr][nc][broken+1]==0) {
					queue.add(new Point(nr, nc, broken+1));
					visited[nr][nc][broken+1] = visited[p.row][p.col][broken]+1;
				}
			}
		}
		return -1;
	}
}