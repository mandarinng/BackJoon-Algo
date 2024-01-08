import java.util.*;
import java.io.*;

public class Main {
	
	static int H,W, count;
	static char [][] field;
	static boolean [][] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=0; tc<T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			count = 0;
			
			field = new char[H][W];
			visited = new boolean[H][W];
			
			for(int i=0; i<H; i++) {
				String input = br.readLine();
				for(int j=0;j<W; j++) {
					field[i][j] = input.charAt(j);
				}
			}
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(!visited[i][j] && field[i][j] == '#') {
						dfs(i,j);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
			
		}
	}
	public static void dfs(int row, int col) {
		
		visited[row][col] = true;
		
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		
		for(int d=0; d<4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			if(nr<H && nc<W && nr>=0 && nc>=0 && field[nr][nc] == '#' && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
		
		
	}

}