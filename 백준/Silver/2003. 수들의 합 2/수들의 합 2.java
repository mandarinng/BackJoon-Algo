import java.util.*;
import java.io.*;

//투포인터
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum=0;
		int end=0;
		for(int start=0; start<N; start++) {
			while(end<N && sum<M) {
				sum += arr[end];
				end++;
			}
			
			if(sum == M) result++;
			
			sum -= arr[start];
		}
		
		System.out.println(result);

	}

}