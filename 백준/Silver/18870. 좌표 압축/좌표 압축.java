//백준 18870 좌표 압축
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int [] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//set에 arr2 수를 중복제거해서 넣음
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<n; i++) {
			set.add(arr[i]);
		}
		//중복 제거한 set을 배열 copy에 넣음
		int [] copy = new int[set.size()];
		int x = 0;
		for(int num : set) {
			copy[x++] = num;
		}
		Arrays.sort(copy);
		
		for(int i=0; i<arr.length; i++) {
			int target = arr[i];
			int idx = binary(target, copy); //이분탐색을 통해 각 수의 인덱스 값을 반환(인덱스 값이 바로 자기보다 작은 수의 수임)
			sb.append(idx).append(" ");
		}		
		System.out.println(sb.toString());
	}
	public static int binary(int target, int [] copy) {
		int start = 0;
		int end = copy.length-1;
		
		while(start <= end) {
			int mid = (start+end)/2;
			
			if(copy[mid] < target) {
				start = mid+1;
			}else if(copy[mid] > target) {
				end = mid-1;
			}else {
				return mid;
			}
		}				
		return -1;
	}
}