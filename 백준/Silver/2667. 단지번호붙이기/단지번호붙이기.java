import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int number;//단지의 번호
	static int [][] map;//지도
	static int N;// 지도의 크기 NXN
	static int cnt; // 각 단지별 속하는 집의 수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		map = new int[N][N];
		// 집이 있는 곳은 1로 바꿔주기.
		for(int i=0; i<N; i++) {
			String input = br.readLine();// 띄어쓰기 없이 string형태로 받고 
			for(int j=0; j<N; j++) {
				map[i][j] = input.charAt(j)-'0';//'0'빼줘서 int형으로 변환
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		number=1;//단지의 번호
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					number++;
					dfs(i,j);
					list.add(cnt);
					cnt=0;
				}
			}
		}
		Collections.sort(list);
		
		 // 단지 번호를 1부터 시작하니까 재귀를 못 빠져나와서( 지도에서 1일때 재귀호출하니까) 단지 번호를 2부터 시작했음 -> 1 빼줘야 단지 수 나옴
		System.out.println(number - 1);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

	public static void dfs(int row, int col) {
		cnt++;
		map[row][col] = number;
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		for(int d=0; d<4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc] == 1) {
				dfs(nr,nc);
			}
		}
	}

}