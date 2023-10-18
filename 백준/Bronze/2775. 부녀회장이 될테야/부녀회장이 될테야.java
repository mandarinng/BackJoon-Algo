import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		int [][] apart = new int[15][15];//0~14층
		for (int i = 0; i < 15; i++) {
			apart[0][i] = i; //0층에 i호에는 i명씩 거주
			apart[i][1] = 1; //각 층의 1호에는 모두 1명씩 거주
		}
		//1층부터 14층까지 , 1호부터 14호까지 거주민 수 구하기
		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				apart[i][j] = apart[i-1][j] + apart[i][j-1];
			}
		}
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
		
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println(apart[N][M]);
		}
	}
}
