import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 시험장 수
		int[] student = new int[N];// 각 시험장의 응시자 수 넣을 배열
		for (int i = 0; i < N; i++) {
			student[i] = sc.nextInt();
		}
		int B = sc.nextInt();// 총감독관이 수용 가능한 학생 수
		int C = sc.nextInt();// 부감독관이 수용 가능한 학생 수

		long cnt = N;// 우선 총 감독관은 시험장당 1명
		for (int i = 0; i < N; i++) {
			student[i] -= B;
			if(student[i]<=0) 
				continue;
			if (student[i] % C == 0)
				cnt += student[i] / C;
			else
				cnt += student[i] / C + 1;
		}
		System.out.println(cnt);
	}

}