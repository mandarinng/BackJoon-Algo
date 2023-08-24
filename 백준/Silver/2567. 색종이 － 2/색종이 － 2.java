import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] paper = new int[100][100];
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int rstart = sc.nextInt();
			int cstart = sc.nextInt();
			for (int j = rstart; j < rstart + 10; j++) {
				for (int k = cstart; k < cstart + 10; k++) {
					paper[j][k]++;
				}
			}
		}
		
		int cnt = 0;
		// 범위를 벗어나지 않고, 값이 0이 아닌 다른 수로 채워져 있을 때 4방탐색해서0의 개수 세기
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] != 0) {
					if (i-1 >= 0 && paper[i - 1][j] == 0) {
						cnt++;
					}
					else if(i == 0) {
						cnt++;
					}
					if (i+1<100 && paper[i + 1][j] == 0) {
						cnt++;
					}
					else if(i == 99) {
						cnt++;
					}
					if (j-1>=0 && paper[i][j - 1] == 0) {
						cnt++;
					}
					else if(j == 0) {
						cnt++;
					}
					if (j+1<100 && paper[i][j + 1] == 0) {
						cnt++;
					}
					else if(j == 99) {
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);

	}

}
