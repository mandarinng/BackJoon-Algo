import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int [][] normalGrid; // 일반 사람이 보는 그림
    static int [][] blindGrid; // 적록색약이 보는 그림
    static int N;// NXN 그리드의 N

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        normalGrid = new int[N][N];
        blindGrid = new int[N][N];
        
        //정상인은 RGB 모두 다른 색(1,2,3)으로 인식
        //적록색약인은 R,G는 같은 색(1) B는 다른 색(2)로 인식
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++) {
                if(input.charAt(j)=='R') {
                    normalGrid[i][j] = 1;
                    blindGrid[i][j] = 1;
                }
                else if(input.charAt(j)=='B') {
                    normalGrid[i][j] = 2;
                    blindGrid[i][j] = 2;
                }
                else if(input.charAt(j)=='G'){
                    normalGrid[i][j] = 3;
                    blindGrid[i][j] = 1;
                }
            }
        }
        
        int normalcnt=0;// 일반  사람이 봤을 때 구역의 수
        int blindcnt=0;// 적록색약이 봤을 때 구역의 수
        
        //dfs 함수에서 현재 보고 있는 그리드를 모두 1로 바꿀 에정 -> 같은 색이 이어질때 dfs함수를 계속 돌다가 다른 색을 만나면 돌아옴
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(normalGrid[i][j] != 0) {//0으로 바뀌지 않은 부분부터 (색깔이 다른 지점을 만나면 )
                	dfs(i,j,normalGrid, normalGrid[i][j]);//다시 깊이우선탐색 시작
                	normalcnt++;//탐색 빠져 나오면 한 색깔 끝난 거니까 일반인 색+1
                }
                if(blindGrid[i][j] != 0) {
                	dfs(i,j,blindGrid, blindGrid[i][j]);
                	blindcnt++;//탐색 빠져 나오면 한 색깔 끝난 거니까 적록색약인 색+1
                }
            }
        }
        System.out.println(normalcnt+" "+blindcnt);
    }
    
    public static void dfs(int row, int col, int [][] grid, int color) {
    	
    	//현재 보고 있는 그림의 그리드를 0으로 바꿔서 이미 본 부분이란걸 표시함
        grid[row][col] = 0;
        //델타로 상하좌우에 같은 색이 있는지 파악
        int [] dr = {0,1,0,-1};
        int [] dc = {1,0,-1,0};
        for(int d=0; d<4; d++) {
            int nr = row+dr[d];
            int nc = col+dc[d];
            //범위를 벗어나지 않으며, 현재의 색과 다음 위치의 색이 같다면 계속 탐색하기
            if(nr>=0 && nr<N && nc>=0 && nc<N && grid[nr][nc] == color) {
                dfs(nr,nc,grid, grid[nr][nc]);
            }
            
        }
       
    }

}