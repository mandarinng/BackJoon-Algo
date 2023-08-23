import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];
		int midx = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();

		}
		int max = arr[0];
		for (int i = 1; i < 9; i++) {
			if (max < arr[i]) {
				max = arr[i];
				midx = i;
			}
		}
		Arrays.parallelSort(arr);

		System.out.println(arr[arr.length - 1]);
		System.out.println(midx + 1);
	}

}
