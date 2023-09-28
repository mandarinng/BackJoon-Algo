import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[][] board; //NXN 체스판
	static int N;//체스판 크기
	static int result = 0;//출력할 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N]; 

		backTracking(0); //0: 현재 퀸의 수 이자 행의 번호가 될것! 원래같으면 1부터 시작이지만 배열이니까 0부터.

		System.out.println(result);//n개의 퀸을 놓을 수 있는 횟수 출력   

	}

	public static void backTracking(int queen) {

		if (queen == N) {//퀸이 N개 놓였으면 정잡이므로  +1해주기
			result++;
			return;//다시 백트래킹해서 가능한 경우 찾아
		}
		//2중 FOR문 돌리면 안됨! i도 사용해서 if(board[i][j]==0)하게되면 의도하지 않은 곳을 가리키게 됨
		//어차피 퀸은 한 행에 한 개씩밖에 둘 수 없으므로 queen이 행을 가리킬 수 있음
		//아직 값이 0인 부분(값이 채워지지 않은 부분!!)을 만나면 change()로 가로 세로 대각선을 현재 값에 +1씩 해주기
		//true/false 하면 안됨->int형 사용하기
		for (int j = 0; j < N; j++) {
			if (board[queen][j] == 0) {
				change(queen, j);// 현재 말을 둔 위치와 행,열 인덱스값을  파리미터로 넣음
				backTracking(queen + 1);//다음 퀸 놓기
				rechange(queen, j);//백트래킹
			}
		}

	}
	//현재 말을 둔 위치와 행,열,대각선 인덱스가 일치하면 현재의 값+1
	public static void change(int row, int col) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == row || j == col || i + j == row + col || i - j == row - col) {
					board[i][j]++;
				}
			}
		}
	}
	//백트래킹 부분
	//현재 돌아온 위치와 행,열,대각선 인덱스가 일치하면 현재의 값-1
	public static void rechange(int row, int col) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == row || j == col || i + j == row + col || i - j == row - col) {
					board[i][j]--;
				}
			}
		}
	}

}