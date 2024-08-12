//백준 20125 쿠키의 신체 측정
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] square = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				if (s.charAt(j) == '*') {
					square[i][j] = 1;
				} else {
					square[i][j] = 0;
				}
			}
		}

		int startX = -1;
		int startY = -1;

		a: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (square[i][j] == 1) {
					startX = i;// 머리 행 : 1
					startY = j;// 머리 열 : 2
					sb.append(startX + 2).append(" ").append(startY + 1).append("\n");// 심장 위치
					break a;
				}
			}
		}
		int cnt = 0;
		// 왼팔 :
		for (int i = startY - 1; i >= 0; i--) {
			if (square[startX + 1][i] != 0) {
				cnt++;
			} else {
				break;
			}
		}
		sb.append(cnt).append(" ");
		cnt = 0;
		// 오른팔
		for (int i = startY + 1; i < N; i++) {
			if (square[startX + 1][i] != 0) {
				cnt++;
			} else {
				break;
			}
		}
		sb.append(cnt).append(" ");
		// 허리
		cnt = 0;
		int waistX = -1;// 허리 행
		int waistY = -1;// 허리 열
		for (int i = startX + 2; i < N; i++) {
			if (square[i][startY] != 0) {
				cnt++;
			} else {
				waistX = i - 1;
				waistY = startY;
				break;
			}
		}
		sb.append(cnt).append(" ");
		// 왼다리
		cnt = 0;
		for (int i = waistX + 1; i < N; i++) {
			if (square[i][waistY - 1] != 0) {
				cnt++;
			} else {
				break;
			}
		}
		sb.append(cnt).append(" ");
		// 오른다리
		cnt = 0;
		for (int i = waistX + 1; i < N; i++) {
			if (square[i][waistY + 1] != 0) {
				cnt++;
			} else {
				break;
			}
		}
		sb.append(cnt).append(" ");

		System.out.println(sb.toString());
	}

}