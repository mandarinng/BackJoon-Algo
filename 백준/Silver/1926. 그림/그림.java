import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int M;
	public static int [][] picture;
	public static int size;//그림의 사이즈
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//세로
		M = Integer.parseInt(st.nextToken());//가로
		picture = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				picture[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max=0;//가장 큰 그림의 크기
		int cnt=0;//그림의 개수
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				size=0;
				if(picture[i][j] == 1) {
					dfs(i,j);
					cnt++;
					if(max<size) max=size;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
		
		
	}
	public static void dfs(int row, int col) {
		size++;//dfs함수로 온건 일단 그림(1)이 있는 부분이니까 사이즈+1 해주기
		picture[row][col]=2;//방문 이미 한 곳이라고 표시.
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		for(int d=0; d<4; d++) {
			int nextrow = row+dr[d];
			int nextcol = col+dc[d];
			if(nextrow>= 0&& nextrow<N && nextcol>=0 && nextcol<M && picture[nextrow][nextcol]==1) {
				dfs(nextrow,nextcol);
			}
		}
	}

}