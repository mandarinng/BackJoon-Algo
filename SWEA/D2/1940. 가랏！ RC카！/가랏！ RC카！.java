import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// command의 수
			int N = sc.nextInt();
			// 현재 속도
			int nv = 0;
			// 출력한 총 이동 거리
			int s = 0;
			int[][] arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				// 0 : 유지 / 1 : 가속 / 2: 감속
				arr[i][0] = sc.nextInt();// 가속할지 감속할지
				if (arr[i][0] != 0) {
					arr[i][1] = sc.nextInt();// 변할 속도
				}
			}

			for (int i = 0; i < N; i++) {
				// 속도 유지
				if (arr[i][0] == 0) {
					s += nv;
				}
				// 가속
				else if (arr[i][0] == 1) {
					nv += arr[i][1];
					s += nv;
				}
				// 감속
				else if (arr[i][0] == 2) {
					if (nv < arr[i][1])
						nv = 0;
					else
						nv -= arr[i][1];
					s += nv;
				}

			}

			System.out.println("#" + tc + " " + s);
		}

	}

}