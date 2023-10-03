import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 북동남서(일단 입력받을때 북동남서가 0123이니까 그대로 쓰기 - 시계방향)
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int cnt = 0;// 출력할 변수. 청소한 칸의 수
	static int N, M;
	static int[][] room;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 세로
		M = Integer.parseInt(st.nextToken());// 가로 : NXM크기의 방

		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());// 현재 행 위치
		int col = Integer.parseInt(st.nextToken());// 현재 열 위치
		int dir = Integer.parseInt(st.nextToken());// 현재 바라보는 방향

		room = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		 // 로봇 청소기 동작 함수 호출
		clean(row, col, dir);

		System.out.println(cnt);

	}

	public static void clean(int row, int col, int dir) {
		// 현재 칸이 빈칸이면 일단 청소
		if (room[row][col] == 0) {
			room[row][col] = 2;// 청소한 곳은 2로 표시
			cnt++;
		}
		int origin = dir;// 초기 방향 저장
		boolean canMove = false; // 이동 가능한지 여부를 나타내는 변수
		
		// 4방향을 확인하여 청소할 공간이 있는지 확인
		for (int d = 0; d < 4; d++) {
			//ndir : 현재 방향에서 왼쪽으로 회전한 방향을 계산하는 부분. ndir 변수에는 현재 방향에서 왼쪽으로 회전한 방향이 저장됨.
			//ndir은 계산된 값을 저장하기 위한 변수임. 
			int ndir = (dir + 3) % 4; // 현재 방향에서 왼쪽으로 회전한 방향
			int nr = row + dr[ndir];
			int nc = col + dc[ndir];
			// 청소할 공간이 있으면 이동
			if (nr < N && nc < M && nr >= 0 && nc >= 0 && room[nr][nc] == 0) {
				clean(nr, nc, ndir);
				canMove = true;
				break;

			}
			//실제로 로봇의 방향을 왼쪽으로 회전시키는 부분.
			dir = (dir+3)%4;
		}
		
		// 네 방향 모두 청소가 불가능한 경우
		if(!canMove) {
			int backDir = (dir+2)%4;// 후진할 방향
			int nr = row + dr[backDir];
			int nc = col + dc[backDir];
			
			// 후진할 수 있는지 확인
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && room[nr][nc] != 1) {
               clean(nr, nc, origin);// 바라보는 방향 유지한 채 후진
            } 
		}
		
		

	}

}
//방향 계산하는 부분
//입력(dir)  ->   왼쪽으로 90도 이동
//0(북) 		->    3(서)
//1(동) 		->    0(북)
//2(남) 		->    1(동) 
//3(서) 		->    2(남)
// 이렇게 되려면  dir = (dir + 3) % 4; 해야함.