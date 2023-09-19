import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[][] cheese;
	static boolean[][] visited;
	static int N;
	static int currCheese;
	static int day;
	static int maxCheese;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // tc개수
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine()); // 치즈 한 변의 길이
			cheese = new int[N][N];//치즈
			visited = new boolean[N][N];//방문을 나타내는 배열
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxDay = 0;// 정사각형 치즈에 적혀있는 숫자(x번째 날)중 가장 큰 값
			//가장 나중 날짜 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					maxDay = Math.max(maxDay, cheese[i][j]);
				}
			}
			day = 0;// 요정이 치즈를 먹는 날짜는 0일차부터 시작
			currCheese = 0;// 현재 일차의 치즈 덩어리 수
			maxCheese = 0;// 출력할 수. 가장 치즈 덩어리가 많을 떄의 치즈 덩어리 수
			
			// 0일차부터 가장 나중 일차까지 반복하면서 최대 덩어리 수를 찾기
			while (day <= maxDay) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						//현재 일차와 치즈에 적힌 날짜가 같으면 그 부분을 0으로 바꿔주기
						if (cheese[i][j] == day)
							cheese[i][j] = 0;
					}
				}
				//위에서 0으로 바꾼 치즈 부분이 아니고, 아직 방문하지 않은 부분만 dfs 함수로 갈것
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (cheese[i][j] != 0 && visited[i][j] == false) {
							dfs(i, j);
							currCheese++;//dfs가 끝났다는 것은 치즈 한 부분을 찾은 것이므로 +1개 해주기
						}
					}
				}
				day++;// 해당 일차에 치즈 덩어리 개수 다 찾았으니까 다음 일차로 넘어가기
				visited = new boolean[N][N];//다음 일차는 새로 방문해야 하니까 visited함수 초기화
				maxCheese = Math.max(maxCheese, currCheese);//다음 일차로 넘어가기 전에 해당 일차와 지금까지의 일차 중 최대 치즈 덩어리 수 구하기
				currCheese = 0;//다음 일차로 넘어가기 전에 현재 치즈 덩어리 수 초기화
			}
			
			System.out.println("#" + tc + " " + maxCheese);
		}

	}

	public static void dfs(int row, int col) {
		visited[row][col] = true;//방문한 치즈 부분 표시해주기
		//델타로 돌면서 치즈 범위를 넘어가지 않고, 해당 일차보다 큰 수가 적힌 치즈만 탐색하며, 아직 방문하지 않은 부분의 치즈에서 dfs 돌기
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			if (nr < N && nc < N && nr >= 0 && nc >= 0 && cheese[nr][nc] != 0 && visited[nr][nc] ==false) {
				dfs(nr, nc);
			}
		}
	}
}