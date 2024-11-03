//백준 6593 상범 빌딩
import java.io.*;
import java.util.*;

public class Main {
	
	public static class Position {
		int floor;
		int row;
		int col;
		int time;
		public Position(int floor, int row, int col, int time) {
			this.floor = floor;
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
	
	static char [][][] building;
	static boolean [][][] visited;
	static int [] start;
	static int sec = 0;
	static int L,R,C;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken()); //높이
			R = Integer.parseInt(st.nextToken()); //행
			C = Integer.parseInt(st.nextToken()); //열
			if(L==0 && R==0 && C==0)break;
			
			building = new char[L][R][C];
			visited = new boolean[L][R][C];
			start = new int[3]; //[0]에 시작 층[1]에 시작행 [2]에 시작열 저장
			
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String s = br.readLine();
					for (int k = 0; k < C; k++) {
						building[i][j][k] = s.charAt(k);
						if(building[i][j][k] == 'S') {
							start[0] = i;
							start[1] = j;
							start[2] = k;
						}
					}
				}
				br.readLine();
			}
			boolean flag = bfs();
			if(flag) {
				sb.append("Escaped in "+sec+" minute(s).").append("\n");
			}else {
				sb.append("Trapped!").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	public static boolean bfs() {
		//동남서북상하
		int [] df = {0,0,0,0,-1,1};
		int [] dr = {0,1,0,-1,0,0};
		int [] dc = {1,0,-1,0,0,0};
		
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(start[0], start[1], start[2], 0));
		visited[start[0]][start[1]][start[2]] = true;
		
		while(!queue.isEmpty()) {
			Position p = queue.poll();
//			sec++;
			for(int d=0; d<6; d++) {
				int nf = df[d]+p.floor;
				int nr = dr[d]+p.row;
				int nc = dc[d]+p.col;
				if(nf<0 || nr<0 || nc<0 || nf>=L || nr>=R || nc>=C) continue;
				if(visited[nf][nr][nc]) continue; //방문했으면 pass
				if(building[nf][nr][nc] == '#')continue; //벽이면  pass
				if(building[nf][nr][nc] == 'E') {
					sec = p.time+1;
					return true; //탈출구면 return
				}
				
				//아직 방문하지 않고, 이동 가능한 빈칸이면 queue에 넣고 방문처리
				queue.add(new Position(nf, nr, nc, p.time+1));
				visited[nf][nr][nc] = true;
			}
		}
		
		return false;
	}
}