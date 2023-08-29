import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //A[1]~A[N]개의 정수
		//A 배열에서 나중에 입력받는 내가 원하는 값과 일치하는 값이 있는지 찾을거임
		int [] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt(); 
		}
		Arrays.sort(A);//이분탐색을 위해 배열을 정렬함(오름차순)
		
		int result=-1;
		int M = sc.nextInt();//M개의 정수 중 A와 일치하는게 있나요?
		for(int i=0; i<M; i++) {
			//찾으려고 하는 값이 A에 존재하면1 , 없으면 0
			if(binarySearch(A, sc.nextInt()) >=0) {
				result = 1;
			}
			else {
				result = 0;
			}
			System.out.println(result);
		}
	}
	//target은 위에서 M개의 입력받은 값을 의미함. A[]에서 target과 일치하는 값이 있나요?
	public static int binarySearch(int [] A, int target) {
		int start=0;//탐색할 범위의 첫번째 인덱스
		int end=A.length-1; //탐색할 범위의 마지막 인덱스
		
		//start와 end가 같아지기 전까지 반복 ->start와 end가 같으면 찾는 값이 없는것!
		while(start<=end) {
			int mid = (start+end)/2; //mid는 중간값
			
			//target이 mid값보다 작은 경우 end값을 중간-1 인덱스값으로 내림
			if(target<A[mid]) {
				end = mid-1;
			}
			//target이 mid 값보다 큰 경우 start값을 중간+1 인덱스값으로 올림
			else if(target>A[mid]) {
				start = mid+1;
			}
			//target값과 mid가 일치할 경우!!
			else {
				return mid;
			}
		}
		return -1; // 내가 찾고자 하는 값이 없을 경우
		
	}
}