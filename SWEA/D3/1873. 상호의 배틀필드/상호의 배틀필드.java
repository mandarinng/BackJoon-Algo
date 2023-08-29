import java.util.Scanner;

public class Solution {

	static char[][] map;
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	// 전차의 방향 전환할 때 사용할 변수
	static int dir = 0;
	
	// 전차의 처음 위치를 저장할 변수
	static int r = 0;
	static int c = 0;
	// 전차가 이동할 다음 위치
	static int nr = 0;
	static int nc = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int H = sc.nextInt();// 맵의 높이
			int W = sc.nextInt();// 맵의 너비
			map = new char[H][W];

		
			for (int i = 0; i < H; i++) {
				String s = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
					// 우선 전차의 위치 찾기
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
						// 전차의 현재 위치 인덱스 저장
						r = i;
						c = j;
						if (map[i][j] == '^') // 상
							dir = 0;
						else if (map[i][j] == 'v')// 하
							dir = 1;
						else if (map[i][j] == '<')// 좌
							dir = 2;
						else // 우
							dir = 3;
					}

				}
			}

			int N = sc.nextInt(); // 사용자가 넣을 입력의 개수
			String s = sc.next();

			// 입력받는 문자 동작 저장할 배열
			char[] move = new char[N]; // N개의 문자 동작
			// U:up / D:dwon / L:left / R:right / S:shoot
			for (int i = 0; i < N; i++) {
				move[i] = s.charAt(i);
			}

			// 주어진 문자 동작 순회
			for (int i = 0; i < N; i++) {

				switch (move[i]) {
				// 포탄일때 : 현재 바라보고 있는 방향으로 벽돌이면 평지로 바꾸고, 아니면 다른 일이 일어나지 않음.
				case 'S':
					int k = 1;
					// 벽을 만나거나 경계에 다다를때까지 포탄을 쏠 것임
					while (true) {
						// 다음 위치.
						nr = r + (dr[dir] * k);
						nc = c + (dc[dir] * k);
						// 포탄을 쐈을때 범위를 벗어나거나 강철벽#을 만나면 아무 일도 일어나지 않고 전차가 이동하지 않음
						if (nc < 0 || nr < 0 || nc >= W || nr >= H || map[nr][nc] == '#')
							break;
						// 포탄을 쐈을때 벽돌을 만났을 경우 벽돌이었던 위치(바라보고 있는 다음 위치)가 .(평지)로 바뀜.전차 이동x
						else if (map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;

						}
						k++;// 정해진 방향으로 계속 이동
					}
					break;
					// 방향이 전환될 경우 밑의 changeDirection에서 지정한대로 움직임
				case 'U':
				case 'D':
				case 'R':
				case 'L':
					
					changeDirection(move[i]);
					nr = r + dr[dir];
					nc = c + dc[dir];
					// 범위를 벗어나는 경우에는 넘어가고 다음 문자 동작 읽어주기
					if (nr < 0 || nc < 0 || nr >= H || nc >= W) {
						continue; // for문으로 돌아감
					}
					// 범위 내에서 평지(.)를 만나면 원래 위치는 평지로 변하고, 전차를 그 위치로 옮김
					else if (map[nr][nc] == '.') {
						map[nr][nc] = map[r][c];
						map[r][c] = '.';
						r = nr;
						c = nc;
					}
					break;
				}
			}

			System.out.print("#" + tc + " ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	public static void changeDirection(char ch) {

		if (ch == 'U') {
			map[r][c] = '^';
			dir = 0;

		} else if (ch == 'D') {
			map[r][c] = 'v';
			dir = 1;
		} else if (ch == 'L') {
			map[r][c] = '<';
			dir = 2;
		} else if (ch == 'R') {
			map[r][c] = '>';
			dir = 3;
		}

	}
}