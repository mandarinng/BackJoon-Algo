import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static int[] nums;
	public static int[] tmp;

	public static void main(String[] args) throws IOException {
		// 병합정렬 해보쟝
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {

			// 입력받은 백만개의 숫자를 nums배열에 저장. -> 정렬할 배열
			nums = new int[1000000];
			// 정렬할때 요소들을 임시로 저장해둘 배열
			tmp = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {

				nums[i] = Integer.parseInt(st.nextToken());
			}
			mergeSort(0, nums.length - 1);
			System.out.println(nums[500000]);
		}
	}

	// 분할정렬
	// mid를 기준으로 왼쪽과 오른쪽 나누고, merge함수를 통해 병합하기
	// mergetSort를 통해 각 배열을 반씩 잘라서 나누고, merge로 병합할 것임.
	public static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);// mid를 기준으로 왼쪽 부분
			mergeSort(mid + 1, right);// mid를 기준으로 오른쪽 부분
			merge(left, mid, right);// 병합하는 부분
		}
	}

	// 병합해주는 함수
	public static void merge(int left, int mid, int right) {
		// part1은 왼쪽 부분의 시작인덱스, part2는 오른쪽 부분의 시작 인덱스
		int part1 = left;
		int part2 = mid + 1;
		// 임시 저장 배열에 저장할 인덱스
		int idx = left;

		// 왼쪽 부분이나 오른쪽 부분 둘 중 어느것이라도 다 정렬되어 빌때까지 while문 실행
		while (part1 <= mid && part2 <= right) {
			// part1에서 지금 가리키고 있는 인덱스와 part2에서 지금 가리키고 있는 인덱스 중 더 작은 값을 임시저장배열에 넣기
			// 오름차순 기준
			if (nums[part1] <= nums[part2]) {
				tmp[idx++] = nums[part1++];
			} else {
				tmp[idx++] = nums[part2++];
			}
		}

		// 왼쪽 부분이나 오른쪽 부분이 모두 정렬되어 완성되고, 남은 쪽도 넣어줘야함
		// 이 부분이 남은 쪽의 수들을 임시 배열에 넣어주는 부분
		// 왼쪽 부분이 남은 경우
		if (part1 <= mid) {
			for (int i = part1; i <= mid; i++) {
				tmp[idx++] = nums[i];
			}
		}
		// 오른쪽 부분이 남은 경우
		else {
			for (int i = part2; i <= right; i++) {
				tmp[idx++] = nums[i];
			}
		}

		// 이제 오른쪽, 왼쪽 부분 모두 정렬되어 임시 배열에 들어갔으니 본 배열에 복사해주기
		for (int i = left; i <= right; i++) {
			nums[i] = tmp[i];
		}

	}
}