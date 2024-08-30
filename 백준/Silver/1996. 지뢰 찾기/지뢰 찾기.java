//백준 1996 지뢰 찾기

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] windows = new int[N][N];

		for (int i = 0; i < windows.length; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < windows.length; j++) {
				if (c[j] == '.') {
					windows[i][j] = 0;
				} else {
					windows[i][j] = c[j] - '0';
				}
			}
		}
		char[][] answer = new char[N][N];
		int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(windows[i][j] != 0) {
					answer[i][j] = '*';
					continue;
				}
				for (int k = 0; k < 8; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						sum += windows[nr][nc];
					}
				}
				if (sum >= 10) {
					answer[i][j] = 'M';
				} else {
					answer[i][j] = (char) (sum+'0');
				}
				sum = 0;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(answer[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}