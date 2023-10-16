import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 수열의 크기
		
		int [] A = new int[N];// 수열을 다담을 배열
		for (int i = 0; i <N; i++) {
			A[i] = sc.nextInt();
		}
		int [] dp = new int[N];
		for (int i = 0; i < N; i++) {
			dp[i] = 1;//우선 증가하는 가장긴 부분 수열의 길이는 모두 자기 자신만 포함한 1로 초기화
			for(int j=0; j<i; j++) {
				if(A[i] > A[j]) {// A[i]를 기준으로 A[j]와 비교.->증가하는 수열일 경우!!
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
		}//dp 배열에 각 원소에 대한 가장 긴 증가 수열의 길이가 저장
		int result=-1;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
		
		
		
	}

}