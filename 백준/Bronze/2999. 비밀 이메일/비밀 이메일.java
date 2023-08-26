import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pw = sc.next();
		int N = pw.length();
		
		int R=0;
		int C=0;
		for(int i=1; i<N; i++) {
			if(N%i==0 && i<=N/i) {
				R = i;
				C = N/R;
			}
		}
		char [][] arr = new char[R][C];
		int m=0;
		a :for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				arr[j][i] = pw.charAt(m++);
				if(m == pw.length())
					break a;
			}
		}

		String answer = "";
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				answer += arr[i][j];
			}
		}
		System.out.println(answer);

	}

}