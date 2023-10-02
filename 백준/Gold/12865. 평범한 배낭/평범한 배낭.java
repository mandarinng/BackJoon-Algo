import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//N개의 물건
		int K = sc.nextInt();//버틸 수 있는 무게 K
		// 물건 당 첫 번째 열[0]에는 물건의 무게/ 두 번째 열[1]에는 물건의 가치를 저장한다.
		// 물건이 없는 경우도 고려하여 인덱스가 0인 경우를 추가해준다.
		int [][] items = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			items[i][0] = sc.nextInt();
			items[i][1] = sc.nextInt();
		}
		
		// 먼저 i번째 물건의 j번째 무게에서 가질 수 있는 최댓값을 저장할 수 있는 2차원 dp테이블을 정의한다.
		int [][] dp = new int[N+1][K+1];
		
		// 1번째 물건부터 N번째 물건까지 모두 고려한다.
		for (int i = 1; i <=N; i++) {
			// 무게가 1인 경우부터 무게가 K인 경우까지 모두 고려한다.
			for (int j = 1; j <=K; j++) {
				///현재 고려할 물건의 무게가 임시무게를 벗어나 고려할수 없을떄
				if(items[i][0] > j) {
					// i - 1번째 물건까지 고려했을때 무게 j에서의 최대 가치(최적해)를 그대로 가져온다.
					dp[i][j] = dp[i-1][j];
				}
				// 해당 위치에 물건을 넣을 수 있는 경우.
				// i - 1번째 물건까지 고려했을 때 무게 j에서의 최대 가치(dp[i-1][j])와,
                // i - 1번째 물건까지 고려했을 때 무게 j - items[i][0]에서의 최대 가치(dp[i-1][j-items[i][0]]) + 현재 물건의 가치(items[i][1]) 중에서
                // 더 큰 값을 선택합니다.
				else {
					dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j - items[i][0]]+items[i][1]);
				}
				
			}
		}
		// dp[N][K]를 출력한다(dp테이블의 정의에 따르면 N가지 물건을 모두 고려했을때 K무게에서의 최대 가치를 출력하는 것!)
		System.out.println(dp[N][K]);
	}

}