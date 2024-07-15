//백준 1929 소수 구하기
//에라토스테네스의 체 검색해보기!!
import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean [] arr = new boolean[N+1];//N까지의 수가 소수인지 저장할 배열
		Arrays.fill(arr, true);//우선 다 소수라고 치기
		
		arr[0] = arr[1] = false; //0,1은 소수가 아님
		
		//에라토스테네스의 체 알고리즘
		//i가 N의 제곱근 이하일 때만 검사하기
		for(int i=2; i*i <= N; i++) { //n의 제곱근 이후의 수는 i를 약수로 가지고 있을 것이기 때문에 검사 제외!
			if(arr[i]) {//아직 검사되지 않은 수 일때
				for(int j=i*i; j<=N; j+=i) {//i는 제외하고, i의 배수들은 소수가 아님
					arr[j] = false;
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i=M; i<=N; i++) {
			if(arr[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);

	}

}