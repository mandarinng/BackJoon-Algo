import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			//파스칼 삼격형의 크기
			int N = sc.nextInt();
			int [][] pascal = new int[N][N];
			for(int i=0; i<N; i++) {
				pascal[i][0] = 1;
			}
			for(int i=1; i<N; i++) {
				for(int j=1; j<N; j++) {
					pascal[i][j] = pascal[i-1][j-1]+pascal[i-1][j];
				}
			}
			
			System.out.println("#"+tc+" ");
			for(int i=0; i<N; i++) {
				for(int j=0; j<=i; j++) {
					System.out.print(pascal[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}