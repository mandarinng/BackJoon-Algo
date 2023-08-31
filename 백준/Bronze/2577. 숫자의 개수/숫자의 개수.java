import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		String abc = A * B * C + "";

		int[] nums = new int[10];// 0~9까지
		for (int i = 0; i < abc.length(); i++) {
			for (int j = 0; j < 10; j++) {
				if (abc.charAt(i) - '0' == j) {
					nums[j]++;
					break;
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(nums[i]);
		}

	}

}