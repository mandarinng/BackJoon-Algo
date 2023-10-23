import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] sour; // 재료의 신맛 저장 배열
	static int[] bitter; // 재료의 쓴맛 저장 배열, 0번째 인덱스부터 사용
	static int []visited; // 조합할 때 선택된 재료의 인덱스 저장 배열
	static int min = Integer.MAX_VALUE; // 최소 맛 차이를 저장할 변수
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//재료의 개수
		
		sour = new int[N]; 
	    bitter = new int[N];
		visited = new int[N];
		
		for (int i = 0; i < N; i++) {
			sour[i] = sc.nextInt();//신
			bitter[i] = sc.nextInt();//쓴
		}
		
		// 1개부터 n개까지 재료를 선택하여 조합을 생성하고 최솟값 찾기
        for (int i = 1; i <= N; i++) {
           
            combination(0, 0, i); // n개 중에서 i개를 고르는 조합
        }
        
        System.out.println(min); // 최소 맛 차이 출력
		
	}
	//N개 중 i개를 고르는 조합 만들기
	public static void combination(int start, int cnt, int food) {
		if(cnt == food) { // i개의 재료를 선택한 경우
			int b = 0;//쓴 맛 누적 변수 - 합이니까 0부터
			int s = 1;//신 맛 누적 변수 - 곱이니까 1부터
			for (int i = 0; i < food; i++) {
                s *= sour[visited[i]]; // 선택된 재료의 신맛을 곱함
                b += bitter[visited[i]]; // 선택된 재료의 쓴맛을 더함
            }
			min = Math.min(min, Math.abs(b - s)); // 최소 맛 차이 업데이트
			return;
		}
		
		for (int i = start; i <N; i++) {
			visited[cnt] = i;
			combination(i+1, cnt+1, food);
		}
		 
		
	}

}