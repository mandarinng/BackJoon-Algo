//백준 2776번 암기왕
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {

			int N = Integer.parseInt(br.readLine());// 수첩1
			int[] note1 = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				note1[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(note1);

			int M = Integer.parseInt(br.readLine());// 수첩2
			
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int x = Integer.parseInt(st.nextToken());
				int low = 0;
				int high = N-1;
				boolean found = false;
				
				while(low <= high) {
					int mid = (low+high)/2;
					if(note1[mid] < x)
						low = mid+1;
					else if(note1[mid] > x)
						high = mid-1;
					else {
						sb.append(1).append("\n");
						found = true;
						break ;
					}
				}
				if(!found) 
					sb.append(0).append("\n");
			}

		}
		System.out.println(sb.toString());

	}

}