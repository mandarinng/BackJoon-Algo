//백준 1253 좋다
import java.io.*;
import java.util.*;

//투포인터!
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int [] nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			int start = 0;
			int end = n-1;
			int target = nums[i];
			
			while(start < end) {
				if(i == start) {
					start++;
					continue;
				}
				if(i == end) {
					end--;
					continue;
				}
				int sum = nums[start] + nums[end];
				if(sum > target) {
					end--;
				}else if(sum < target) {
					start++;
				}else {
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}