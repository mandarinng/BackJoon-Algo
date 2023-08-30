import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();//N개의 자연수 중 최소 1개 수 이상 선택해 합이 K가 되는 것 찾기
			int [] A = new int[N];//N개의 자연수 수열
			for(int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			int cnt=0;
			// 0000부터 1111까지 모든 경우의 수 중에서
			for(int i=0; i<(1<<N); i++) {
				int sum=0;
				// 0001, 0010, 0100, 1000 과 같이 1의 위치를 N번 옮기면서
				// 해당 자리에 &로 1이 있는지 체크(해당 자리에 1이 있다면 &했을때 둘다 1이 있어서 결과가 0이 아니므로)
				// 해당 자리에 1이 있다면 해당 자리번째 수를 선택한 것이므로 sum에 더해준다!
				for(int j=0; j<N; j++) {
					if( (i & (1<<j)) !=0 ) {
						sum += A[j];
					}
				}
				// 만약 이 부분집합에서 선택한 자리번째 수를 다 더했을 때, K와 같다면 경우의 수 증가
				if(sum == K) {
					cnt++;
				}
				
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}

}