import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static char [][] arr ;
	public static int N ;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		arr = new char[N][N];
		//우선 n*n 크기 배열에 별 모두 찍기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = '*'; 
			}
		}
		//재귀함수로 중간 부분을 공백으로 바꾸기
		star(N,0,0);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	public static void star(int N, int x, int y) {
	    // 기저파트
		//  N부터 시작해서 행, 열이 /3씩 작아지다가 크기가 1인 배열이 되면 return
	    if (N == 1) {
	        return;
	    }
	    
	    
	    // N이 1이 아닌경우
	    // N을 3으로 나눠서 size에 저장. size의 크기에 해당하는 (size x size)중간 부분을 빈 칸으로 채우기
	    int size = N / 3;

	    // 별로 가득 찬 배열의 중간을 공백으로 바꿔줌
	    for (int i = x + size; i < x + size * 2; i++) {
	        for (int j = y + size; j < y + size * 2; j++) {
	            arr[i][j] = ' ';
	        }
	    }

	    // 3x3 크기로 나눠서 재귀호출하기
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (i == 1 && j == 1) {
	                continue;
	            }
	            star(size, x + size * i, y + size * j);
	        }
	    }
	}

}