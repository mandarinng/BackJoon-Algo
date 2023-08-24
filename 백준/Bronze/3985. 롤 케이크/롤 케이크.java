import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); // 롤케이크 길이
		int N = sc.nextInt(); // 방청객 수
		// 가장 많은 조각을 원한 사람이 원한 조각의 수
		int max = 0;
		// 조각을 가장 많이 원한 사람의 인덱스 번호
		int midx = 0;
		// 1부터 L까지의 수를 갖는 배열( 전체 롤케이크 번호) 롤케이크 번호가 1번부터니까+1 크기로 만들기
		int[] roll = new int[L + 1];
		for (int i = 1; i <= L; i++) {
			roll[i]++; // 다 값이 1씩 들어있음
		}
		// N명의 사람이 실제로 가질 수 있는 롤케이크의 개수를 저장한 배열
		int[] n = new int[N];

		for (int i = 0; i < N; i++) {
			int start = sc.nextInt(); // start 조각부터
			int end = sc.nextInt();// end 조각까지 원해요
			if (max < (end - start)) {
				max = end - start;
				midx = i;
			}
			//start부터 end까지 수가 배열에 남아있으면 빼주기
			for (int j = start; j <= end; j++) {
				if (roll[j] > 0) {
					roll[j]--;
					n[i]++;
				} else {//없으면 다시 수 ++
					continue;
				}
			}

		}
		// 실제로 롤케이크를 젤 많이 갖는 사람의 인덱스
		int rMidx = -1;
		// 가장 많이 롤케이크를 갖는 사람이 갖은 케이크 수
		int rollmax = 0;
		for (int i = 0; i < n.length; i++) {
			if (rollmax < n[i]) {
				rollmax = n[i];
				rMidx = i;
			}
		}
		// 조각을 처음에 젤 많이 원했던 사람의 인덱스인데, 1번부터니까 +1해주기
		System.out.println(midx + 1);
		// 실제로 젤 많이 갖은 사람의 인덱스인데, 사람 번호가 1번부터니까 +1해주기
		System.out.println(rMidx + 1);
	}

}
