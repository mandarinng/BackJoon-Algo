import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();// 점원의 수
			int B = sc.nextInt(); // 선반의 높이
			int[] hight = new int[N];// n명의 직원들의 키
			for (int i = 0; i < N; i++) {
				hight[i] = sc.nextInt();
			}
			int cnt = 0;
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < (1 << N); i++) {
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) {
						cnt += hight[j];
					}
				}
				if (cnt >= B) {
					list.add(cnt);
				}
				cnt = 0;
			}
			Collections.sort(list);
			int result = list.get(0)-B;
			System.out.println("#" + tc + " " + result);
		}

	}

}