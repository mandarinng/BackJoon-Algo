import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 좌석 수
		String s = sc.next();
		char [] seat = new char[N];
		for(int i=0; i<N; i++) {
			seat[i] = s.charAt(i);
		}
		int cnt = 0; //L의 개수
		for(int i=0; i<N; i++) {
			if(seat[i] == 'L') {
				cnt++;
			}
		}
		//커플석이 없거나, 한 번 있을 때
		if(cnt <= 2) {
			System.out.println(N);//좌석 수 그대로 출력
		}
		//커플석이 2개 이상 있을 때
		else {
			System.out.println(N-(cnt/2-1));
		}

	}

}
