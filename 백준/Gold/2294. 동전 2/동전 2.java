import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 동전 종류의 개수
        int k = sc.nextInt(); // 목표 금액

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 10001); // 초기값을 무한대로 설정

        dp[0] = 0; // 0원을 만들 때 필요한 동전 개수는 0개

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                // 현재 금액 j에서 동전 coins[i]을 사용하는 경우와 사용하지 않는 경우 중 작은 값 선택
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        if (dp[k] == 10001) {
            System.out.println(-1); // 만들 수 없는 경우
        } else {
            System.out.println(dp[k]);
        }
    }
}