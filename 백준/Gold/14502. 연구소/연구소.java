import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map, copyMap;
	static ArrayList<Point> virus, blank;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 세로
		M = Integer.parseInt(st.nextToken());// 가로

		map = new int[N][M];// 연구소
		virus = new ArrayList<>();// 바이러스들의 좌표를 넣을 큐
		blank = new ArrayList<>();// 빈칸의 좌표를 넣을 리스트

		int cnt = 0;// 공백(0)의 개수를 셀 변수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {// 바이러스 좌표들 리스트에 넣기
					virus.add(new Point(i, j));
				} else if (map[i][j] == 0) {
					blank.add(new Point(i, j));
					cnt++;
				}
			}
		}

		// 0(빈칸)들의 개수를 세서 빈칸의 수 C 3(조합)해서 벽을 세울 경우의 수 만들기-백트래킹
		visited = new boolean[cnt]; // 공백 3개씩 뽑아 조합 만들때 사용할 방문 배열. 위치는 여기!
		combination(0, 0);

		System.out.println(max);
	}

	// 빈칸들 중에 3개씩 뽑는 조합 파트
	public static void combination(int start, int blank) {// start : 조합을 위한 파라미터, blank : 현재까지 뽑힌 빈칸의 수
		// 3개의 빈칸이 선택되었으면 선택된 칸 벽으로 바꾸기
		if (blank == 3) {
			toWall();
			return;
		}

		for (int i = start; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(i + 1, blank + 1);
				visited[i] = false;
			}
		}

	}

	// 만들어진 조합의 경우마다 뽑힌 칸을 벽(1)로 만들기
	// 근데 연구소 자체를 바꾸면 1로 바꿨던걸 다시 0으로 바꿔야하니까 입력받은 연구소와 똑같은 카피연구소만 매 조합 경우마다 1로채우고
	// new해서 다시 만들기
	public static void toWall() {

		copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		// 빈 칸의 좌표를 하나씩 꺼내 해당 빈칸이 조합에서 뽑힌 빈칸이라면 1(벽)으로 바꾸기
		for (Point zero : blank) {
			if (visited[blank.indexOf(zero)]) {
				copyMap[zero.x][zero.y] = 1;
			}
		}

		// 3개 뽑아서 벽으로 다 만들었으면 이제 바이러스 확산하러 가기
		spread();

	}// toWall()
	
	// virus 확산
	// virus좌표를 하나씩 꺼내고, 그 좌표를 기준으로 4방탐색해서 0(빈칸)이면 2로 바꿔주기
	public static void spread() {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		// 매 조합 경우마다 바이러스를 확산해야하니까 조합 생성 후에 queue에 바이러스 좌표들 매번 넣어주기! 안 그러면 첫번째 시행에서만 바이러스가 퍼짐.
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			queue.add(virus.get(i));
		}
		
		while (!queue.isEmpty()) {
			Point two = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = two.x + dr[d];
				int nc = two.y + dc[d];
				if (nr < N && nc < M && nr >= 0 && nc >= 0 && copyMap[nr][nc] == 0) {
					copyMap[nr][nc] = 2;
					queue.add(new Point(nr, nc));
				}
			}
		}

		// 확산 끝났으면 이제 빈칸(0)의 수 세러 가기
		calculate();
	}

	// 빈칸(0)을 세는 함수를 따로 만들어서 바이러스 전염이 끝날때마다 0의 개수 최대값 max 갱신하기
	public static void calculate() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);
	}

//	static void print() {
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.printf("%3d", copyMap[i][j]);
//			}
//			System.out.println();
//		}
//	}

}
