import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] nums = new int[10];
		int sum=0;

		for (int i = 0; i < 10; i++) {
			nums[i] = sc.nextInt(); // 우선 10개의 수를 입력받고
			sum += nums[i];//인덱스들의 누적 합을 구하고
			nums[i] = sum;//인덱스 별 누적합을 다시 배열에 넣어줌
		}
		int result=0;
		int min = Integer.MAX_VALUE;//nums배열의 각 요소-100의 절대값 중 가장 작은 것 찾기. 일단 맨 마지막꺼가 젤 작다고 가정
		//값이 겹칠 경우 둘 중 더 큰 수를 선택한다고 했으니까 배열 뒤에서부터 순회
		for(int i= 9; i>=0; i--) {
			if(Math.abs(nums[i]-100) < min) {
				min = Math.abs(nums[i]-100);//최소값을 찾아서
				result = nums[i];
			}
		}

		System.out.println(result);
	}

}
