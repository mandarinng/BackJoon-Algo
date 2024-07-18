import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int low=0;
			int high=N-1;
			int flag = 0;
			
			while(low <= high) {
				int mid = (low+high)/2;
				
				if(arr[mid] < num) low = mid+1;
				else if(arr[mid] > num) high = mid-1;
				else if(arr[mid] == num) {flag = 1; break;}
			}
			sb.append(flag).append(" ");
		}
		System.out.println(sb.toString());
	}

}