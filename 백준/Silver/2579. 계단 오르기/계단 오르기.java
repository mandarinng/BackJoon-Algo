import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 계단의 개수
        int[] stairs = new int[n + 1]; // 계단별 점수를 저장할 배열
        int[] dp = new int[n + 1]; // i번째 계단까지 올랐을 때 최대 점수를 저장할 DP 배열

        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt(); 
        }

        dp[1] = stairs[1]; // 첫 번째 계단의 점수는 입력받은 그대로
        if (n >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }//dp[2] = stairs[1] + stairs[2];을 그냥 실행한다면, n이 1인 경우에도 두 번째 계단을 처리하게 되어 오류가 발생할 수 있음

        for (int i = 3; i <= n; i++) {
            // 3번 계단 부터는 현재 계단을 밟을 때와 밟지 않을 때(그 전 계단을 밟았을 때) 중 큰 값을 선택
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(dp[n]); 
    }
}