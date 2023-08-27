import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			String nums = sc.next();
			int [] person = new int[nums.length()];
			for(int i=0; i<person.length; i++) {
				person[i] = nums.charAt(i)-'0';
			}
			
			int clap = 0; //현재 박수치는 사람 수
			int result = 0;
			
			for(int i=0; i<person.length; i++) {
				clap += person[i];
				if(clap < (i+1)) {

					while(clap < (i+1)) {
						clap++;
						result++;
					}
				}
			}

			System.out.println("#"+tc+" "+result);
		}

	}

}