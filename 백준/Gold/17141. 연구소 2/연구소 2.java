//백준 17141 연구소2
import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int row;
		int col;
		int time;
		public Point(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
	
	static List<Point> list;
	static boolean [] visited;
	static int empty_cnt;
	static int n;
	static int [][] map;
	static int answer;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		empty_cnt = 0; // 빈 칸의 개수
		list = new ArrayList<>(); //바이러스를 둘 수 있는 칸 좌표 넣을 list
		answer = Integer.MAX_VALUE;
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) empty_cnt++;
				if(map[i][j] == 2) {
					list.add(new Point(i, j, 0));
				}
				if(map[i][j] == 1) {
					map[i][j] = -1; //벽은 음수로 바꾸기
				}
			}
		}
		visited = new boolean[list.size()]; //combination에서 쓸 방문 배열 : true면 뽑힌 위치임
		empty_cnt += (list.size()-m); //바이러스 시작 가능 칸 중 m개를 제외한 다른 칸에도 바이러스 전파 가능
		//list에 들어있는 것 중 m개만 뽑기
		combination(m,0, 0);
		
		System.out.println(answer != Integer.MAX_VALUE? answer : -1);

	}
	public static void combination(int m, int depth, int start) {
		//m개의 바이러스 위치가 뽑히면 bfs 시작
		if(depth == m) {
			int sec = bfs();
			answer = Math.min(answer, sec);
			return;
		}
		for(int i=start; i<list.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(m, depth+1, i+1);
				visited[i] = false;
			}
		}
	}
	//뽑힌 좌표들에서 시작해서 map에서 -1이 아닌 모든 지역에 바이러스 증식 : empty_cnt == 0 되면 return
	public static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		
		int [][] copy = new int[n][n]; //map 대신
		int cnt = empty_cnt; //바이러스 전파 가능한 칸 수 복사해두고 사용하기
		//바이러스 시작 위치들 넣기
		for(int i=0; i<list.size(); i++) {
			if(visited[i]) {
				queue.add(new Point(list.get(i).row, list.get(i).col, 0));
				copy[list.get(i).row][list.get(i).col] = -2; //선택된 바이러스 시작 구역은 -2로 바꾸기 : 사실은 time==0인 지역
			}
		}
		int t=0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = dr[d] + p.row;
				int nc = dc[d] + p.col;
				if(nr<0 || nc<0 || nr>=n || nc>=n) continue;
				
				if(map[nr][nc] >= 0 && copy[nr][nc] == 0) {
					copy[nr][nc] = p.time+1;
					cnt--;
					queue.add(new Point(nr, nc, p.time+1));
					t = p.time+1;
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(copy[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		if(cnt == 0) {
			return t;
		}else {
			return Integer.MAX_VALUE; //다 전파시키지 못한 경우 큰 수를 반환함
		}
	}
}