//백준 10816 숫자 카드 2
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
				
			sb.append(upper_bound(num, arr) - lower_bound(num, arr)).append(" ");
			
		}
		System.out.println(sb.toString());
	}
	//상한선(이분탐색에서, 찾고자 하는 값을 초과한 처음 나타나는 위치)
	public static int upper_bound(int num, int [] arr) {
		int low = 0;
		int high = N;

		//low와 high가 같아질 때 까지 반복
		while(low < high) {
			int mid = (low + high) / 2;
			
			if(arr[mid] <= num) low = mid+1; // 현재 원소가 num 이하면, 범위를 오른쪽으로 좁히기
			else high = mid; // 현재 원소가 num 초과이면, 범위를 왼쪽으로 좁힘
		}
		return low;
		
	}
	//하한선(이분탐색에서, 찾고자 하는 값 이상(같거나 높은)의 값이 처음 나타나는 위치)
	public static int lower_bound(int num, int [] arr) {
		int low = 0;
		int high = N;

		//low와 high가 같아질 때 까지 반복
		while(low < high) {
			int mid = (low + high) / 2;

			if(arr[mid] < num) low = mid+1; // 현재 원소가 num 이상이면, 범위를 왼쪽으로 좁힘
			else high = mid; // 현재 원소가 num 미만이면, 범위를 오른쪽으로 좁힘
		}
		return low;
	}
}