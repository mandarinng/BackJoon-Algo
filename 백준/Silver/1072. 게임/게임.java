//백준 1072 게임 
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());//게임 횟수
		int Y = Integer.parseInt(st.nextToken());//이긴 게임 횃수
		int Z = (int)Math.floor((double)Y*100 / (double)X); //현재 승률
		
		
		if(Z >= 99) { //승률이 절대 변하지 않는 경우
			System.out.println(-1);
		}else {
			// 이분 탐색
			int low = 1;
			int high = 1000000000;
			int newGame=0;
			
			while(low <= high) {
				int mid = (low+high)/2; //mid값
				
				if((int)Math.floor((double)(Y+mid)*100 / (double)(X+mid)) > Z) {
					newGame = mid;
					high = mid-1; //승률이 올라가면  high = mid-1
				}
				else {
					low = mid+1;//승률이 안 오르면 low = mid+1
				}
			}
			System.out.println(newGame);
		}
	}

}