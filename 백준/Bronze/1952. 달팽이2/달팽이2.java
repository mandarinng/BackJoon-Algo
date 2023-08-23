
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int [][] arr = new int[M][N];
		//몇번 꺾였나?cnt
		int cnt = 0;
		//행 열 전환 배열 : 오른쪽, 아래, 왼쪽, 위
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		//현재 인덱스
		int r=0;
		int c=0;
		//방향전환 변수
		int dir=0;
		int num=1;
		arr[r][c] = num;
		
		//while문 빠져나오려고. 숫자 넣어봐서 MXN이 되면 빠져나오기
	
		while(num<M*N) {
			dir %= 4;

			if(r+dr[dir]>=0 && c+dc[dir]>=0 && r+dr[dir]<M && c+dc[dir]<N && arr[r+dr[dir]][c+dc[dir]]==0) {
				r += dr[dir];
				c += dc[dir];
				arr[r][c] = ++num;
			}
			else {
				dir++;
				cnt++;
			}
		
		}
		
		System.out.println(cnt);
		
	}

}
