import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int T = sc.nextInt();
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#"+tc+" "+power(N,M));
		}

	}
	
	public static int power(int N, int M) {
		//기저 조건
		if(M == 1) return N;
		
		//재귀 조건
		
		if(M%2 == 0) {
			int pow = power(N,M/2);
			return pow*pow;
		}
		else {
			int pow = power(N, (M-1)/2);
			return pow*pow*N;
		}
	}
}