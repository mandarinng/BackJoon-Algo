//백준 15685 드래곤 커브
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { 1, 0, -1, 0 };
		int n = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[101][101];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 시작 방향
			int g = Integer.parseInt(st.nextToken()); // 세대

			ArrayList<Integer> direction = new ArrayList<>();// 방향들을 넣을 list
			direction.add(d); // 시작 방향 넣음
			// 세대 만큼 for문
			for (int j = 0; j < g; j++) {
				int size = direction.size(); // 현재 세대의 방향 개수
				for (int k = size - 1; k >= 0; k--) { // 뒷 순번(가장 최신 방향)부터 방향 90도씩 돌려서 direction에 넣기
					int new_dir = (direction.get(k) + 1) % 4; // 90돌린 방향들 쌓기
					direction.add(new_dir);
				}
			}

			// map에 표시
			int r = row;
			int c = col;
			map[r][c] = true;
			for (int j = 0; j < direction.size(); j++) {
				r += dr[direction.get(j)];
				c += dc[direction.get(j)];
				if (r >= 0 && c >= 0 && r < 101 && c < 101) {
					map[r][c] = true;
				}
			}

		}
		// 박스 수 세기
		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
					answer++;
			}
		}
		System.out.println(answer);
	}
}