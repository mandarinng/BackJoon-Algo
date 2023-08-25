import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
//			int [] num = sc.next().toCharArray()-'0';
			// 입력받은 한 줄의 문자를 하나씩 떼서 int형 배열에 넣음
			String s = sc.next();
			int[] num = new int[s.length()];
			for (int i = 0; i < s.length(); i++) {
				num[i] = s.charAt(i) - '0';
			}
			// 모두 0으로 초기화된 초기값
			int[] start = new int[num.length];
			// bit를 골라 덮어씌우는 횟수
			int cnt = 0;
			//두 배열의 똑같은 위치에서 값이 다를 떄
			for(int i=0; i<num.length; i++) {
				if(num[i] != start[i]) {
					cnt++;//바꾼 횟수 카운트
					//달랐던 인덱스부터 0->1    / 1->0
					for(int j=i; j<num.length; j++) {
						start[j]=(start[j]==0)?1:0;
						
					}
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}

	}

}