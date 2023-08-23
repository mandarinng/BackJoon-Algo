
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 스위치 개수
		int[] sw = new int[N];// 각 스위치 상태 입력받기. 인덱스랑 번호가 하나 차이나니까+1해주기
		for (int i = 0; i < N; i++) {
			// 스위치 번호랑 맞추기 위해 인덱스1번부터 받을것.
			sw[i] = sc.nextInt(); // 1:on / 0:off
		}

		int student = sc.nextInt();// 학생수
		int[][] arr = new int[student][2]; // 학생의 성별, 받은 번호
		for (int i = 0; i < student; i++) {
			arr[i][0] = sc.nextInt();// 성별 남:1 / 여:2
			arr[i][1] = sc.nextInt();// 받은 번호 1~N까지
		}

		// 새로운 배열에 스위치 번호랑 맞추기 위해 +1크기로해서 인덱스1번부터 받을것.
		int[] sarr = new int[N + 1]; // 예제 입력이면 0 0 1 0 1 0 0 0 1
		for (int i = 1; i < N + 1; i++) {
			sarr[i] = sw[i - 1];
		}
//		for(int i=0; i<N+1; i++) {
//			System.out.print(sarr[i]+" ");
//		}
//		System.out.println();

		// 학생 수 만큼 반복
		for (int i = 0; i < student; i++) {
			// 남학생
			if (arr[i][0] == 1) {

				// 받은 번호의 배수와 해당 인덱스의 값들 바꿔주기.0번 인덱스는 제외.
				for (int k = 1; k < N + 1; k++) {
					if (k % arr[i][1] == 0) {
						sarr[k] = (sarr[k] == 1) ? 0 : 1;
					}
				}
			}
			// 여학생
			else {
				// 좌우로 이동하기 위한 변수
				int cnt = 0;
				// 입력값 변수k에 넣어둠
				int k = arr[i][1];
				// 범위를 벗어나면 안됨
				while (k - cnt >= 1 && k + cnt < N + 1) {
					// 기준 인덱스의 좌우가 일치하나?
					// 일치하면 해당인덱스랑 좌우 인덱스 모두 바꾸기
					if (sarr[k - cnt] == sarr[k + cnt]) {

						if (sarr[k - cnt] == 0) {
							sarr[k - cnt] = 1;
							sarr[k + cnt] = 1;
						} else {
							sarr[k - cnt] = 0;
							sarr[k + cnt] = 0;
						}
						cnt++;

					} else {
						break;
					}

				}
				
			}
		}

		for (int i = 1; i < sarr.length; i++) {
			System.out.print(sarr[i] + " ");
			if(i%20 == 0) {
				System.out.println();
			}
		}
		
	}

}