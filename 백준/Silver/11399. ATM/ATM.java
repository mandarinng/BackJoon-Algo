import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람 수
		int[] person = new int[N];
		// 각 사람마다 걸리는 시간
		for (int i = 0; i < N; i++) {
			person[i] = sc.nextInt();
		}
		// 걸린 시간이 젤 작은 순으로 정렬
		Arrays.sort(person);
		
		// 젤 작은 값부터 카운트해준 값을 저장한 배열
		int[] arr = new int[N];
		// 젤 작은 시간부터 카운트 한 값을 다 더해주면 답
		// 다 더해준 값
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				arr[i] += person[j];
			}
			sum += arr[i];
		}

		System.out.println(sum);
	}

}
