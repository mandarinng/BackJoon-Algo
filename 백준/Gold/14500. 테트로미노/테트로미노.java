import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int [][] paper; // 입력받은 숫자가 있는 종이
	static int N; //행
	static int M;//열
	static boolean [][] visited;//종이에 방문 표시하는 배열
	static int maxsum=0;//출력할 최고값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		
		 for(int i=0; i<N; i++) {
			 for(int j=0; j<M; j++) {
				 visited[i][j] = true; //현재 종이 방문 표시
				 dfs(i,j,1,paper[i][j]); //종이의  현재 인덱스로 dfs 들어감. 
				 //현재 정사각형 포함 4칸이 되면 반환해야 하니까 일단 cnt는 1, sum은 현재 위치의 값
				 visited[i][j] = false;//dfs함수 다 돌면 일단 그 위치에서의 도형은 다 확인 한거니까 방문 표시 해제
				 oh(i,j); //ㅏㅓㅗㅜ 모양은 다음번에 처리해줌
			 }
		 }
		 System.out.println(maxsum);
		
	}
	//ㅏㅓㅜㅗ모양을 제외한 다른 모양들만 일단 먼저 확인하기
	//cnt는 4칸인지 확인하는 파라미터, sum은 4칸의 합 더해주는 파라미터
	public static void dfs(int row, int col, int cnt, int sum) {
		// 정사각형 4칸을 확인했으면 지금까지의 sum값중에 최대값을 반환함
		if(cnt==4) {
			maxsum = Math.max(maxsum, sum); // 최대값 찾기
			return;
		}
		//델타로 탐색. 우하좌상
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		for(int d=0; d<4; d++) {
			int nr = row+dr[d];
			int nc = col+dc[d];
			if(nr>=0 && nr<N && nc>=0 && nc<M && visited[nr][nc]==false) {
				visited[nr][nc] = true;//방문 체크
				dfs(nr,nc,cnt+1,sum+paper[nr][nc]);//다음 정사각형으로 넘어가기dfs 돌기!!
				visited[nr][nc] = false;//방문 해제
			}
		}
		
	}
	//ㅏㅓㅜㅗ 모양 탐색하는 부분
	public static void oh(int row, int col) {
		// ㅏ 모양 테트로미노 확인. ㅏ모양은 col에서 오른쪽 부분만 범위 내에 들어오는지 확인하면 됨.
        if (row - 1 >= 0 && row + 1 < N && col + 1 < M) {
            int sum = paper[row][col] + paper[row - 1][col] + paper[row + 1][col] + paper[row][col + 1];
            maxsum = Math.max(maxsum, sum);
        }
        // ㅓ 모양 테트로미노 확인
        if (row - 1 >= 0 && row + 1 < N && col - 1 >= 0) {
            int sum = paper[row][col] + paper[row - 1][col] + paper[row + 1][col] + paper[row][col - 1];
            maxsum = Math.max(maxsum, sum);
        }
        // ㅗ 모양 테트로미노 확인
        if (row - 1 >= 0 && col - 1 >= 0 && col + 1 < M) {
            int sum = paper[row][col] + paper[row - 1][col] + paper[row][col - 1] + paper[row][col + 1];
            maxsum = Math.max(maxsum, sum);
        }
        // ㅜ 모양 테트로미노 확인
        if (row + 1 < N && col - 1 >= 0 && col + 1 < M) {
            int sum = paper[row][col] + paper[row + 1][col] + paper[row][col - 1] + paper[row][col + 1];
            maxsum = Math.max(maxsum, sum);
        }
	}

}