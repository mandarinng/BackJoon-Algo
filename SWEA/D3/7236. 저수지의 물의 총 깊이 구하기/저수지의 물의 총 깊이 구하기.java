import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 저수지 구획 크기(N)
			char[][] water = new char[N][N];// 저수지
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					water[i][j] = sc.next().charAt(0);
				}
			}

			// 8방탐색
			// 행 : 위, 위오른쪽, 오른쪽, 오른쪽아래, 아래, 왼쪽아래, 왼쪽, 왼쪽위
			int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
			int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
			// 출력할 최고 깊이
			int mcnt = 0;
			// 현재 위치의 깊이
			int cnt = 0;
	
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// W를 만나면 8방 탐색 시작
					if(water[i][j] == 'W') {
						cnt=0;
						for(int d=0; d<8;d++) {

							//범위 내에 들어왔을 때 W만나면 cnt++
							if(i+dr[d]>=0 && i+dr[d]<N && j+dc[d]>=0 && j+dc[d]<N && water[i+dr[d]][j+dc[d]] == 'W') {
								cnt++;
							}
						}//d for문
					}//if문
					if(cnt>mcnt)
						mcnt = cnt;
				}
			}
			if(mcnt==0)
				mcnt=1;
			System.out.println("#" + tc + " " + mcnt);

		}
	}
}