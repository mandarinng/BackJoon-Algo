import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static int [][] maze;
	static boolean [][] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
	
		for(int tc=1; tc<=10; tc++) {
			int T = sc.nextInt();
			maze = new int [16][16];
			visited = new boolean [16][16];
			result=0; // 매 테스트케이스마다 result=0으로 초기화해줌
			for(int i=0; i<16; i++) {
				char [] input = sc.next().toCharArray();
				for(int j=0; j<16; j++) {
					maze[i][j] = input[j]-'0';
				}
			}
			//시작점을 만나면 dfs시작
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					if(maze[i][j] == 2) {
						dfs(i,j);
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}

	}
	public static void dfs(int row, int col) {
		
		visited[row][col] = true; //방문 표시
		
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		
		for(int d=0; d<4; d++) {
			int nr = row+dr[d];
			int nc = col+dc[d];
			//범위를 벗어나지 않고, 아직 방문하지 않았고, 길일때(0일떄) dfs 반복
			if(nr<16 && nc<16 && nr>=0 && nc>=0 && maze[nr][nc] == 0 && visited[nr][nc] == false) {
				dfs(nr,nc);
			}
			//끝점을 만나면(3을 만나면) 길이 있는 거니까 result=1
			if(maze[nr][nc] == 3) {
				result = 1;
				return ;
			}
		}
	}

}