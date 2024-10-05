//백준  16208 귀찮음
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int [] arr = new int[n];
		long sum=0;
		 st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		long answer=0;
		for(int i=0; i<n-1; i++) {
			answer += arr[i]*(sum-arr[i]);
			sum -= arr[i];
		}
		System.out.println(answer);
	}
}