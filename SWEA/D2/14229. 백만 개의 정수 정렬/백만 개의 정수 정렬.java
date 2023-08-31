import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	//병합 정렬 함수를 선언하고, 정렬할 배열을 인자로 받기
	public static void mergeSort(int [] nums) {
		// 병합 정렬은 똑같은 크기의 임시 저장 공간이 필요함. 
		int [] tmp = new int[nums.length];
		// 정렬할 배열, 임시 저장소, 처음과 끝 인덱스로 재귀호출 시작
		mergeSort(nums, tmp,0,nums.length-1);
	}
	public static void mergeSort(int []nums, int[]tmp, int start, int end) {
		//시작 인덱스가 끝 인덱스보다 작은 동안만 재귀호출 할 것.
		if(start < end) {
			//함수가 호출되면 배열을 반 갈라서 확인함-> 가운데 인덱스 필요 :mid
			int mid = (start+end)/2;
			mergeSort(nums,tmp,start,mid);
			mergeSort(nums,tmp, mid+1,end);
			//재귀함수가 돌아왔을 때 가운데를 기준으로 왼쪽과 오른쪽이 정렬되어있는 상태.
			// merge함수를 호출해서 이제 두개로 나뉜 배열을 병합해줌
			merge(nums,tmp, start,mid ,end);
		}
	}
	// 두개로 나뉜 배열을 값에 따라 순서대로 병합해주는 함수임
	private static void merge(int[] nums, int[] tmp,int start, int mid, int end) {
		// 임시 저장소에 정렬된 배열을 필요한 만큼 복해해줌
		for(int i=start; i<=end; i++) {
			tmp[i] = nums[i];
		}
		// mid를 기준으로 배열이 나뉘어 있는데, 양 쪽 배열의 첫 시작 부분을 part에 저장
		int part1 = start;
		int part2 = mid+1;
		int idx = start;//양 쪽 배열에서 작은 값을 하나씩  복사할때 마다 결과 배열에 저장하기 위해 기억해둘 수 있는 변수 생성
		//양 쪽의 배열이중 하나라도 끝까지 갈 때 까지 while문 돌아감
		while(part1 <= mid && part2 <=end) {
			// 양 쪽 배열의 첫 번째 값들부터 비교 시작
			if(tmp[part1] <= tmp[part2]) {
				//앞쪽이 작을 때
				nums[idx] = tmp[part1];
				part1++;
			}
			//뒤쪽 배열이 더 작을 때
			else {
				nums[idx] = tmp[part2];
				part2++;
			}
			idx++;//양 쪽 배열 중 어디를 옮겼어도 인덱스는 늘려줘야 함.
		}
		//둘 중 한 배열만 끝까지 돌아가고, 한 쪽 배열은 정렬이 덜 됐을 상황도 있음.
		//앞 쪽 배열에 데이터가 남아있을 경우. 앞 쪽 포인터가 
		for(int i=0; i<mid-part1; i++) {
			nums[idx+i] = tmp[part1+i];
		}
		
	}
	public static void main(String[] args) throws IOException {
		//병합정렬 해보쟝
		Scanner sc = new Scanner(System.in);
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
		//입력받은 백만개의 숫자를 nums배열에 저장. -> 정렬할 배열
		
		int [] nums = new int[1000000];
		for(int i=0; i<nums.length; i++) {
	
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		System.out.println(nums[500000]);
	}

}