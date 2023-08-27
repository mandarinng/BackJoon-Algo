import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			String [][] arr = new String[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.next();
				}
			}

			//결과로 출력할 배열
			String [][] result = new String [N][N];
			//90도 회전한 result의 [0]열
			for(int i=0; i<N; i++) {
				String s = "";
				for(int j=0; j<N; j++) {
					s += arr[N-1-j][i];
				}
				result[i][0] = s;
			}
			//180도 회전한 result의 [1]열
			for(int i=0; i<N; i++) {
				String s = "";
				for(int j=0; j<N; j++) {
					s += arr[i][N-1-j];
				}
				result[N-1-i][1] = s;
			}
			//270도 회전한 result의 [1]열
			for(int i=0; i<N; i++) {
				String s = "";
				for(int j=0; j<N; j++) {
					s += arr[j][N-1-i];
				}
				result[i][2] = s;
			}
			System.out.println("#"+tc+" ");
			for(int i=0; i<N; i++) {
				for(int j=0; j<3; j++) {
					System.out.print(result[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}