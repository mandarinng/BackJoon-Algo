import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int K, num, d; // 회전 수, 톱니번호, 회전 방향
	static int[][] graph;
	static boolean[] need; // 돌려야할 톱니 구하기
	static int[] dir; // 톱니가 돌아간다면 어느 방향으로 돌아야하는지

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		graph = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < 8; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		} // 입력 완

		K = sc.nextInt(); // 회전 수

		for (int t = 0; t < K; t++) {
			num = sc.nextInt() - 1; // 톱니 번호 -> 0,1,2,3번으로 바꿈
			d = sc.nextInt(); // 회전 방향

			dir = new int[4];

			if (num % 2 == 0) {
				for (int i = 0; i < 4; i++) {
					if (i % 2 == 0) {
						dir[i] = d;
					} else {
						dir[i] = d * (-1);
					}
				}
			} else {
				for (int i = 0; i < 4; i++) {
					if (i % 2 == 0) {
						dir[i] = d * (-1);
					} else {
						dir[i] = d;
					}
				}
			}

			// 돌아야할 톱니 번호를 구할거야
			turnNeed();

			// 돌아야할 톱니 바퀴를 돌려
			for (int i = 0; i < 4; i++) {
				// i번째가 true이면 돌려야하는 톱니바퀴임
				if (need[i]) {
					rotation(i);
				}
			}

		} // 회전 수만큼 반복문 돌리기

		int ans = 0; // 점수의 합을 저장할 변수

		if (graph[0][0] == 1)
			ans += 1;
		if (graph[1][0] == 1)
			ans += 2;
		if (graph[2][0] == 1)
			ans += 4;
		if (graph[3][0] == 1)
			ans += 8;

		System.out.println(ans);

	}// main

	static void turnNeed() {
		// 각 톱니마다 돌아야할지 안돌아야할지 표시
		need = new boolean[4];

		need[num] = true; // 주어진 톱니바퀴는 무조건 돌아가므로 true

		// 낮은 번호로 내려가면서 검사
		for (int i = num; i > 0; i--) {
			if (graph[i][6] != graph[i - 1][2]) {
				need[i - 1] = true;
			} else
				break;
		}

		// 높은 번호로 올라가면서 검사
		for (int i = num; i < 3; i++) {
			if (graph[i][2] != graph[i + 1][6]) {
				need[i + 1] = true;
			} else
				break;
		}

	}// turnNeed

	// idx번 톱니바퀴 방향에 맞게 돌리기
	static void rotation(int idx) {
		// 시계 방향으로 돌리기
		if (dir[idx] == 1) {
			int first = graph[idx][7];
			for (int i = 7; i > 0; i--) {
				graph[idx][i] = graph[idx][i - 1];
			}
			graph[idx][0] = first;
		}
		// 반시계 방향으로 돌리기
		else {
			int last = graph[idx][0];
			for (int i = 0; i < 7; i++) {
				graph[idx][i] = graph[idx][i + 1];
			}
			graph[idx][7] = last;

		}

	}// rotation

}