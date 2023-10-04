import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static int[][] house;
	static int[] cleaner = new int[2];// 공기청정기(-1)의 좌표 -> 항상 [0]열에 위치하니까 행 좌표만 받기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());// 집 세로
		C = Integer.parseInt(st.nextToken());// 집 가로
		T = Integer.parseInt(st.nextToken());// T초 후 미세먼지 양 출력

		house = new int[R][C];
		Arrays.fill(cleaner, -1);
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
				// 공기청정기의 좌표 입력받기
				if (house[i][j] == -1) {// 공기청정기가 입력되었고,
					if (cleaner[0] == -1) {// 아직 청정기의 첫 칸이 입력되지 않았다면
						cleaner[0] = i; // 청정기[0]에 위치 입력받기
					} else {// 이미 첫 -1이 들어왔었다면(청정기 첫 칸이 입력됐었다면)
						cleaner[1] = i;// 청정기[1]에 위치 입력받기
					}
				}
			}
		} // 입력 끝

		// T초동안 미세먼지가 확산되고, 공기청정기가 작동한다.
		for (int t = 0; t < T; t++) {
			spreadDust(); // 미세먼지 확산
			airClear(); // 공기청정기 작동
		}

		int totalDust = calculate(); // T초가 지난 후 남은 미세먼지의 양 계산
		System.out.println(totalDust);

	}

	// 미세먼지 확산
	static void spreadDust() {

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		// 연쇄작용 방지하기위해 newhouse를 새로 만들어서 확산된 미세먼지 양(새롭게 계산된)만 저장해두고 초기값과 더해주자
		int[][] newHouse = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 퍼트릴 미세먼지가 존재하는 칸 일 떄
				if (house[i][j] > 0) {
					// 우선 상하좌우칸에 퍼트릴 미세먼지 양 구해두기
					int sDust = house[i][j] / 5;

					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						// 범위를 벗어나지 않고, 공기청정기가 아닌 칸일떄
						if (nr < R && nc < C && nr >= 0 && nc >= 0 && house[nr][nc] != -1) {
							newHouse[nr][nc] += sDust;// 확산이 일어난다.
							house[i][j] -= sDust;// 원래칸(house)에는 확산된 만큼 값 빼주기
						}

					}

				}
			}
		}
		// house에는 확산된 먼지의 양을 빼준 만큼 남았고, newHouse에는 확산된 양을 저장해두었으므로 둘을 더해주면 1초 후 최종적으로
		// 미세먼지가 확산된 값이 남게된다ㅏ.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				house[i][j] += newHouse[i][j];
			}
		}

	}

	static void airClear() {

		// 위쪽 공기청정기는 반시계방향으로 회전
		int top = cleaner[0];// 위칸 공기청정기

		// 1. 위쪽 공기청정기에서 공기청정기 바로 위의 먼지([0]열)를 한 칸씩 내려줌
		// [0][0]은 [0][1]에서 옮겨와야 하므로 일단 1번행부터 공기청정기 전 행까지만 값 밑으로 옮겨주기
		for (int i = top - 1; i > 0; i--) {
			house[i][0] = house[i - 1][0];
		}
		// 2. 맨 윗줄([0]행)값들 왼쪽으로 땡기기
		for (int i = 0; i < C - 1; i++) {
			house[0][i] = house[0][i + 1];
		}
		// 3. 가장 오른쪽 열 위로 한칸씩 옮기기
		for (int i = 0; i < top; i++) {
			house[i][C - 1] = house[i + 1][C - 1];
		}
		// 4.공기청정기 있는 행 오른쪽으로 한 칸씩 옮기기
		for (int i = C - 1; i > 1; i--) {
			house[top][i] = house[top][i - 1];
		}
		// 5.공기청정기 바로 오른쪽 칸[top][1]은 항상 0
		house[top][1] = 0;

		// 밑쪽 공기청정기는 시계방향으로 회전
		int bottom = cleaner[1];// 밑쪽 공기청정기
		// 1. [0]열 한칸씩 위로 옮기기
		for (int i = bottom + 1; i < R - 1; i++) {
			house[i][0] = house[i + 1][0];
		}
		// 2.맨 밑 행[R-1] 한 칸씩 왼쪽으로 옮기기
		for (int i = 0; i < C - 1; i++) {
			house[R - 1][i] = house[R - 1][i + 1];
		}
		// 3.가장 오른쪽 열[C-1] 한 칸씩 밑으로 내리기
		for (int i = R - 1; i > bottom; i--) {
			house[i][C - 1] = house[i - 1][C - 1];
		}
		// 4. 밑쪽 공기청정기 있는 칸 오른쪽으로 땡기기
		for (int i = C - 1; i > 1; i--) {
			house[bottom][i] = house[bottom][i - 1];
		}
		// 5. 아래쪽 공기청정기 바로 오른쪽 칸은 항상 0
		house[bottom][1] = 0;

	}

	// 최종적으로 남은 미세먼지 양을 계산하는 함수
	static int calculate() {
		int result = 2;// 미세먼지 양을 구하는거니까 공기청정기(-1)값은 제외하고 더하기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				result += house[i][j];

			}
		}
		return result;
	}

}