import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] person = new int[N + 1]; // 사람이1번부터니까
		person[1] = 1;// 1번이 공을 갖고 시작하니까 일단 1
		int i = 1;
		int cnt = 0;
		while (person[i] < M) {
			// person[i]가 홀수 ->방향
			if (person[i] % 2 == 1) {
				person[(i+L)%N]++;
				i = (i+L)%N;
				cnt++;
			}
			// person[i]가 짝수 <-방향
			else {
				if(i-L<0) {
					i = i-L+N;
					person[i]++;
					cnt++;
				}
				else {
					i = i-L;
					person[i]++;
					cnt++;
				}
			}

		}
		
		System.out.println(cnt);

	}
}