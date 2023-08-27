import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int cnt=0;
			char alpha = 'A';
			int N = sc.nextInt();//받을 제목의 개수
			String [] title = new String[N];
			for(int i=0; i<N; i++) {
				title[i] = sc.next();
			}
			for(int i=0; i<N; i++) {
				if(title[i].charAt(0) == alpha) {
					cnt++;
					alpha++;
					i=-1;
				}
				
			}

			System.out.println("#"+tc+" "+cnt);
		}

	}

}