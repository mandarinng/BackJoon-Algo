import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static  int [][] farm;
	static int M;
	static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
        	int cnt=0;// 출력해야하는 애벌레의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());//가로길이
            N = Integer.parseInt(st.nextToken());//세로길이
            int K = Integer.parseInt(st.nextToken());//배추의 개수 -> 밑에 배추의 좌표 X,Y가 주어질 것
            farm = new int[N][M];
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
         
                farm[y][x] = 1;
            }
            
           for(int i=0; i<N; i++) {
        	   for(int j=0; j<M; j++) {
        		   if(farm[i][j] == 1) {
        			   dfs(i, j);
        			   cnt++;
        		   }
        	   }
           }
           System.out.println(cnt);
        }//tc

    }//main
    public static void dfs(int row, int col) {
    	farm[row][col] = 2;
    	int [] dr = {0,1,0,-1};
    	int [] dc = {1,0,-1,0};
    	for(int d=0; d<4; d++) {
    		int nr = row+dr[d];
    		int nc = col+dc[d];
    		if(nr>=0 && nr<N && nc>=0 && nc<M && farm[nr][nc]==1) {
    			dfs(nr,nc);
    		}
    	}
    }

}