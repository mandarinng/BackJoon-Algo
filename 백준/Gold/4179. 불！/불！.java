import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean flag;
	static int R, C, second = 0;
	static char[][] maze;
	static boolean[][] visited;
	static Queue<Point> fq = new LinkedList<>();
	static Queue<Point> jq = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		maze = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				maze[i][j] = s.charAt(j);
				if (maze[i][j] == 'F') {
					fq.add(new Point(i, j));
				} else if (maze[i][j] == 'J') {
					jq.add(new Point(i,j));
				}
			}
		}

		int result = bfs();
		
		if(result == -1) System.out.println("IMPOSSIBLE");
		else System.out.println(result);
	
	}

	public static int bfs() {

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		while (!jq.isEmpty()) { 
			// 1초 지날때마다 불 확산
			int size = fq.size();
			for(int k=0; k<size; k++) {
				Point p = fq.poll();
				for (int d = 0; d < 4; d++) {
					int nfr = p.x + dr[d];
					int nfc = p.y + dc[d];
					if (nfr < R && nfr >= 0 && nfc < C && nfc >= 0 && maze[nfr][nfc] == '.') {
						maze[nfr][nfc] = 'F';
						fq.add(new Point(nfr, nfc));
					}
				}
			}
			//지훈이 이동 : 어차피 지훈이가 왔던 길로 돌아올 일은 없으니까 J 안 지우고 이동해도 됨
			int jsize = jq.size();
			while(jsize-->0) {
				Point p = jq.poll();
				for(int d=0; d<4; d++) {
					int njr = p.x + dr[d];
					int njc = p.y + dc[d];
					if(njr < 0 || njc <0 || njr>=R || njc>=C) {
						return second+1;
					}
					if(maze[njr][njc] == '.') {
						jq.add(new Point(njr, njc));
						maze[njr][njc] = 'J';
					}
				}
			}
//			print();
			second++;
		}
		
		return -1;
	}
	public static void print() {
		System.out.println();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.printf("%3c", maze[i][j]);
			}
			System.out.println();
		}
	}
}