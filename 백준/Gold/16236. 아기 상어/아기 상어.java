//백준 16236 아기 상어
import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] fishBowl;
	static boolean[][] visited;
	static Point shark;
	static int babyShark = 2;
	static int time = 0;
	static boolean flag = true;
	static int eatCnt=0;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static class Fish implements Comparable<Fish>{
		int row;
		int col;
		public Fish(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public int compareTo(Fish o) {
			if(this.row == o.row) {
				return Integer.compare(this.col, o.col);
			}
			return Integer.compare(this.row, o.row);
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		fishBowl = new int[n][n];

		shark = new Point(-1, -1);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				fishBowl[i][j] = Integer.parseInt(st.nextToken());
				if (fishBowl[i][j] == 9) {
					shark.r = i;
					shark.c = j;
					fishBowl[i][j] = 0;
				}
			}
		}
		while (flag) {
			bfs(shark.r, shark.c);
		}
		System.out.println(time);
	}

	public static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean[n][n];

		//상좌우하
		int[] dr = { -1, 0, 0, 1 };
		int[] dc = { 0, -1, 1, 0 };
		int dist = 0;
		ArrayList<Fish> list = new ArrayList<>();

		queue.add(new Point(r, c));
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			int qSize = queue.size();
			dist++;
			
			while (qSize-- > 0) {
				Point p = queue.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc] || fishBowl[nr][nc] > babyShark) {
						continue;
					}
					//먹을 수 없는 경우
					if(fishBowl[nr][nc] > babyShark) {
						continue;
					}
					//먹을 수 있거나, 크기가 같거나, 0인 경우 모두 방문처리, queue에 넣기
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc));
					//먹을 수 있는 물고기 만났을 때 list에 넣기
					if (fishBowl[nr][nc] < babyShark && fishBowl[nr][nc] != 0) {
						list.add(new Fish(nr, nc));
					}
					
				}
			}
			//먹을 수 있는 물고기를 찾은 경우
			if(!list.isEmpty()) {
				Collections.sort(list);
				Fish fish = list.get(0);
				fishBowl[fish.row][fish.col] = 0; //물고기 먹음
				shark = new Point(fish.row, fish.col);//상어위치 변경
				time += dist; //이동 거리만큼 시간 증가
				eatCnt++;
				//먹은 마리수랑 상어크기 같을 때 상어 크기 증가
				if(babyShark == eatCnt) {
					babyShark++;
					eatCnt = 0;
				}
				flag = true; //먹을 수 있는 물고기 있는 경우에는 flag=true
				return;
			}
		}
		flag = false;
		return;
	}
}