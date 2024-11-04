import java.awt.Point;
import java.io.*;
import java.util.*;
//백준 5427 불
public class Main {
	static class SG{
		int row;
		int col;
		int time;
		public SG(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
	static char [][] building;
	static int r,c;
	static boolean[][] visited;
	static int [] start;
	static List<Point> fires;
	static int sec;
	static boolean flag;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			building = new char[r][c];
			visited = new boolean[r][c];
			start = new int [2]; //[0]에 시작 row, [1]에 시작 col 저장
			fires = new ArrayList<>();
			
			for (int i = 0; i < r; i++) {
				String s = br.readLine();
				for (int j = 0; j < c; j++) {
					building[i][j] = s.charAt(j);
					if(building[i][j] == '@') {
						start[0] = i;
						start[1] = j;
					}
					if(building[i][j] == '*') {
						fires.add(new Point(i, j));
					}
				}
			}
			sec = 0;
			flag = false;
			bfs();
			System.out.println(flag ? sec : "IMPOSSIBLE");
		}
	}
	public static void bfs() {
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		
		Queue<SG> sg = new LinkedList<>();//상근 위치
		sg.add(new SG(start[0], start[1], 0));
		visited[start[0]][start[1]] = true;
		
		Queue<Point> fire = new LinkedList<>();//불 위치 (여러 개 일 수 있음)
		for(int i=0; i<fires.size(); i++) {
			fire.add(new Point(fires.get(i).x, fires.get(i).y));
		}
		
		while(!sg.isEmpty()) {
			//불 먼저 전파 : 벽만 아니면 계속 전파하기
			int qSize = fire.size();
			while(qSize-- > 0) {
				Point p = fire.poll(); //불 위치
				for(int d=0; d<4; d++) {
					int nr = dr[d] + p.x;
					int nc = dc[d] + p.y;
					//경계 넘으면 pass
					if(nr<0 || nc<0 || nr>=r || nc>=c) {
						continue;
					}
					//벽이거나 이미 불이면 불 전파 못함
					if(building[nr][nc] == '#' || building[nr][nc] == '*') {
						continue;
					}
					//빈 칸 이거나 상근이가 있는 위치면 불 전파
					if(building[nr][nc] == '@' || building[nr][nc] == '.') {
						building[nr][nc] = '*';
						fire.add(new Point(nr, nc));
					}
				}
			}
			int qsize = sg.size();
			while(qsize-- >  0) {
				//상근이 이동
				SG location = sg.poll(); //상근이 현 위치
				for(int d=0; d<4; d++) {
					int nr = dr[d] + location.row;
					int nc = dc[d] + location.col;
					
					//탈출
					if(nr<0 || nc<0 || nr>=r || nc>=c) {
						sec = location.time + 1;
						flag = true;
						return;
					}
					//아직 방문하지 않았고, 빈 칸이면 이동
					if(!visited[nr][nc] && building[nr][nc] == '.') {
						sg.add(new SG(nr, nc, location.time+1));
						visited[nr][nc] = true;
						building[nr][nc] = '@';
					}
				}
			}
//			print();
		}
	}
	public static void print() {
		for (int i = 0; i < building.length; i++) {
			for (int j = 0; j < building[0].length; j++) {
				System.out.print(building[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}