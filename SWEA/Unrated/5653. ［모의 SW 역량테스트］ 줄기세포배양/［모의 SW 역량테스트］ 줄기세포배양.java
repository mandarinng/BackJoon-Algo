import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int [][] board;
	static boolean [][] visited;
	static PriorityQueue<Cell> queue;
	static int N,M,K;
	
	
	public static class Cell implements Comparable<Cell>{
		int row;//세포의 행 좌효
		int col;//세포의 열 좌표
		int life;//세포의 생명력(입력받는 수)
		int time;//세포가 활성화돼있는 시간(life로 시작해서 -로 줄어드는 수)
		
		public Cell(int row, int col, int life, int time) {

			this.row = row;
			this.col = col;
			this.life = life;
			this.time = time;
		}
		
		// 생명력 수치가 높은 줄기 세포의 우선순위를 높이기 위해
		@Override
		public int compareTo(Cell o) {
			return o.life - this.life;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T= Integer.parseInt(st.nextToken());
			for(int tc=1; tc<=T; tc++) {
				
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());//세로
				M = Integer.parseInt(st.nextToken());//가로
				K = Integer.parseInt(st.nextToken());//배양 시간
				
				//초기 세포 입력
				board = new int[N+K+2][M+K+2];
				//방문 처리
				visited = new boolean[N+K+2][M+K+2];
				//살아있는 줄기 세표(비활성화 + 활성화 상태의 세포)들을 넣을 우선순위큐
				//우선순위 큐를 사용한 이유는 동시 번식할 때 생명력이 높은 친구를 먼저 뽑기 위해서
				queue = new PriorityQueue<>();
				
				int set = K/2+1;
				for(int i=set; i<N+set; i++) {
					 st = new StringTokenizer(br.readLine());
					 for(int j=set; j<M+set; j++) {
						 board[i][j] = Integer.parseInt(st.nextToken());
						 if(board[i][j] != 0) {
							 queue.add(new Cell(i,j, board[i][j], board[i][j]));
							 visited[i][j] = true;
						 }
					 }
				}
				
				cultivate();
				
				//pq에 남아있는 세포가 살아있는 세포들.
				System.out.println("#"+tc+" "+queue.size());
			}
			
	}
	public static void cultivate() {
		
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		
		//한 시간마다 배양한 후 살아있는 줄기세포들을 임시로 담아들 큐
		Queue<Cell> q = new LinkedList<>();
		
		//K시간동안 증식
		while(K-- >0) {
			
			while(!queue.isEmpty()) {
				Cell cell = queue.poll(); //pq에서 꺼낸 세포(life 수가 높은 것 부터 뽑힘)
				cell.time--; // 활성화 시간-1(이미 수명이 끝났으도 -로 계속 줄어듦)
				// ex. board에 1이 입력 됐을 때, 1초 후에 활성화 되고, 또 1초 후에 번식되기 시작하니까 -1이 됐을 때 증식함.
				if(cell.time < 0) {
					//증식
					for(int d=0; d<4; d++) {
						int nr = cell.row + dr[d];
						int nc = cell.col + dc[d];
						
						if(visited[nr][nc]) continue;//이미 세포가 있는 부분 처리
						
						board[nr][nc] = cell.life;
						visited[nr][nc] = true;
						
						q.add(new Cell(nr, nc, board[nr][nc], board[nr][nc]));
					}
					
				}
				if(cell.life + cell.time == 0) continue; // 죽은 세포는 pq에 안 넣으려고 처리해준 부분
				q.add(cell); // 죽지 않은 세포는 다시 큐에 넣어주기
				
			}
			//임시 큐를 원래 큐에 넣어주기
			while(!q.isEmpty()) {
				queue.add(q.poll());
			}
			
		}
		
	}
	
}