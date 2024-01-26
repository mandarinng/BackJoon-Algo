import java.util.*;
import java.io.*;

public class Main {
	
	static int N,K, result, kg=500;
	static int [] kit;
	static boolean [] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());// N개의 중량 키드
		K = Integer.parseInt(st.nextToken());// 매일 K 중량씩 체중 감소

		kit = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		backTracking(500,0);// 백트래킹 시작 (초기 체중 500)
		
		System.out.println(result);
	}
	// 순열로 N개의 수 [0]~[N-1]를 나열함
	public static void backTracking(int weight, int cnt) {
		
		if(weight < 500) {
			return; //현재 중량이 500 미만이면 리턴
		}
		
		if(cnt == N) {
			result++;// 모든 키트를 사용할 수 있는 경우 결과 증가
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;// 키트 사용 표시
				backTracking(weight-K+kit[i], cnt+1);// 체중 변경, 다음 키트 선택
				visited[i] = false;// 백트래킹 (키트 사용 해제)
			}
		}
		
	}
	

}