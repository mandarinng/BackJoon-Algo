import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			// H개 층, W개 호수 가진 호텔 배열
			int[][] hotel = new int[H][W];
			if(N%H==0) {
				System.out.println(H*100+(N/H));
			}else {
				System.out.println((N%H)*100+(N/H+1));
			}
			
		}

	}

}