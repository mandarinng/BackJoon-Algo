import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [][] paper = new int[101][101];
		//각 색종이가 차지하는 부분을 전체 도화지[101][101]에서 번호로 채우기
		//새로운 종이로 덮으면 다음 숫자로 덮어짐
		//해당 숫자로 입력된 배열의 값을 더하면 넓이를 알 수 있음
		for(int i=0; i<N; i++) {
			int rstart = sc.nextInt();
			int cstart = sc.nextInt();
			int width = sc.nextInt();
			int hight = sc.nextInt();
			for(int j=rstart; j<rstart+width; j++) {
				for(int k=cstart; k<cstart+hight; k++) {
					paper[j][k]=i+1;//int배열은 0으로 초기화돼어있으므로 1부터 값 채우기
				}
			}
			
		}

		
		for(int i=1; i<=N; i++) {
			int cnt=0;
			for(int j=0; j<101; j++) {
				for(int k=0; k<101; k++) {
					if(paper[j][k]==i) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}

}
