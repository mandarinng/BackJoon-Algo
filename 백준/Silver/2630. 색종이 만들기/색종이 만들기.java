import java.util.Scanner;

public class Main {
	
	public static int white = 0;
	public static int blue = 0;
	public static int [][] paper;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//nxn 크기의 하얀 종이 입력받기
		int N = sc.nextInt();
		paper = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		//재귀호출
		cut(0,0,N);//맨 처음엔 색종이 전체부터 검사하므로 N부터 검사 시작
		System.out.println(white);
		System.out.println(blue);

	}
	//색이 같은지 확인된 종이의 경우, 색종이 색+1을 해주고, 다른 종이들이 섞인 경우는 종이를 잘라 다시 한번 잘린 종이의 색들이 확인되게 재귀호출한다.
	public static void cut(int row, int col, int size) {
		//재귀의 탈출 조건 부분.
		//밑에 정의한 colorCheck 함수를 호출해 모두 흰색 || 파란색인지 검사한다.
		if(colorCheck(row,col,size)) {
			if(paper[row][col]==0) {//모두 흰색이면 흰색 종이+1
				white++;
			}
			else {//모두 파란색이면 파란색종이+1
				blue++;
			}
			return;//두 색깔 중 하나의 색을 선택하게 되면 재귀 탈출.
		}
		//색종이의 크기 점점 줄여가며 검사
		// 크기가 8->4->2->1 순으로 줄어듦.
		int range = size/2;//해당 종이 내의 모든 색종이 색이 같지 않았을 경우,종이를 계속 1/4크기로 잘라낸다.
		
		//재귀호출
		cut(row,col,range);//2사분면
		cut(row,col+range,range);//1사분면
		cut(row+range,col,range);//3사분면
		cut(row+range,col+range,range);//4사분면
		  
	}
	// 현재 잘린 부분의 모든 색이 같은지 확인하는 부분
	public static boolean colorCheck(int row, int col, int size) {
		//우선 해당 종이의 가장 왼쪽 위 색깔을 기준 색으로 잡는다.
		int nowColor = paper[row][col];
		//기준 색과 현재 보고 있는 색종이의 색이 일치하는지 확인
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(paper[i][j]  != nowColor) {
					return false;//하나라도 시작종이 색과 일치하지 않는게 있다면 false -> 다시 종이 자르기
				}
			}
		}
		//여기까지 통과됐다는 것은 모든 색이 같다는 의미.
		return true;//잘린 종이의 모든 색이 일치하는 경우 true반환
	}

}