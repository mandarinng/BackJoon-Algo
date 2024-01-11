import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M,N, count=0;
	static int [][] banner;
	static boolean [][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); //행
		N = Integer.parseInt(st.nextToken()); //열
		
		banner = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				banner[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(banner[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}
	public static void bfs(int row, int col) {

		visited[row][col] = true;
		
		int [] dr = {-1,0,1,1,1,0,-1,-1};
		int [] dc = {1,1,1,0,-1,-1,-1,0};
		
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(row, col));
		
		while(!queue.isEmpty()) {
			
			Point p = queue.poll();

			for(int d=0; d<8; d++) {
				
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				
				if(nr<M && nr>=0 && nc<N && nc>=0 && !visited[nr][nc] && banner[nr][nc]==1) {
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
 				
			}
			
		}
	}

}