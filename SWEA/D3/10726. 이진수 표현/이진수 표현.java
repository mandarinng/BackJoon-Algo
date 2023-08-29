import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		a:for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();//M의 마지막  N개의 비트 :모두 1인지 아닌지
			int M = sc.nextInt();//10진수 M -> 2진수로 표현했을때
			for(int i=0; i<N; i++) {
				if((M & (1 <<i)) != 0) {
					continue;
				}
				else {
					System.out.println("#"+tc+" "+"OFF");
					continue a;
				}
			}
			System.out.println("#"+tc+" "+"ON");
		}

	}

}