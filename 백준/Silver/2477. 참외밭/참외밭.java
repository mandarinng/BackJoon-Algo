import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//참외 개수
		int N = sc.nextInt();
		//방향과 변의 길이를 가진 배열 : 6개의 변을 가지니까 둘 다 크기는 6
		int [][] field = new int[6][6];
		for(int i=0; i<6; i++) {
			field[i][0] = sc.nextInt();// 방향: 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4
			field[i][1] = sc.nextInt();// 변의 길이
		}
		//동서남북 입력 중 count 세서 count가 1인 수 두개가 가로 최대값, 세로 최대값임
		int [] count = new int[5];
		for(int i=0; i<6; i++) {
			count[field[i][0]]++; 
		}
		//(남북방향 동서방향 서로 바뀌어도 ㄱㅊ)어쨌든 count수가1인게 가로든 세로든 max값
		
		int cidx = -1; //남북방향 최대길이의 인덱스(동서)
		int ridx = -1; //동서방향 최대길이의 인덱스(남북)
		
		for(int i=0; i<6; i++) {
			if(count[1]==1 ) {//동 or 서 count 값이 1일때
				//count의 인덱스는 field[i][0]의 요소값이다.
				if(field[i][0]==1) {//요소값이 count의 인덱스값고 일치하는것 찾기
					ridx = i;//동, 서 (남북)중 count 값이 1인 것의 인덱스와  field[i][0]의 요소값이 일치하면, i가 의미하는 것은 동,서 (남북)중에 최대값의 인덱스임-> field[i][0]
					//fiedl[i][0] -> field[i][1]=동,서 중에(남북중에) 최대값.
				}
			}else if(count[2]==1) {//동 or 서 count 값이 1일때
				if(field[i][0]==2)
					ridx = i;
				
			}
			
			
			if(count[3]==1) {//남 or 북 count 값이 1일때
				if(field[i][0]==3)
					cidx = i;
				
			}else if(count[4]==1) {//남 or 북 count 값이 1일때
				if(field[i][0]==4)
					cidx = i;
				
			}
		}
		// 가로 길이 최대값의 인덱스에서 3번 더 가면 찾고자 하는 작은 사각형의 세로 길이
		// 세로 길이 최대값의 인덱스에서 3번 더 가면 찾고자 하는 작은 사각형의 가로 길이
		// 그런데 입력값들을 원순열처럼 빙글 돌면서 조회하기 위해 6으로 나눈 나머지 인덱스를 대입시킴.
		// 30	 60 	20  	100	 50  160
		// [0]	[1]	    [2] 	[3] [4]  [5]   
		//   	rmin    cmin        cidx ridx  일 때,
		// cidx의 인덱스 ==4 , 4+3=7, 7%6==1 ->1이 바로 rmin의 인덱스임!
		int rmin = (cidx+3)%6; //작은 사각형 가로 길이의 인덱스
		int cmin = (ridx+3)%6; //작은 사각형 세로 길이의 인덱스
		
		//결과값(result) : (큰 사각형 크기 - 작은 사각형 크기)*참외 수
		int result =( (field[ridx][1]*field[cidx][1]) - (field[rmin][1]*field[cmin][1])) * N;
			
			System.out.println(result);
		

	}

}