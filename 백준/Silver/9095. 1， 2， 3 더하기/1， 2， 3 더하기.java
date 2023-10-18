import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[11];
		arr[1] = 1; // 1만드는 방법 1개
		arr[2] = 2; //2만드는 방법 2개
		arr[3] = 4; //3만드는 방법 4개
		//4부터는 이 전 세 개를 더한 값
		for (int i = 4; i <= 10; i++) {
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
		}
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			System.out.println(arr[n]);
		}

	}

}
