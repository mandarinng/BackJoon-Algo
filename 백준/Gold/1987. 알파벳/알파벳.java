import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static int [][] board;
	static boolean [] alpha;
	static int maxDepth = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());//보드의 세로 칸 수
		C = Integer.parseInt(st.nextToken());//보드의 가로 칸 수
		board = new int[R][C];//문제에서 주어지는 보드.( 입력받을 배열 )
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = ((int)input.charAt(j)-65); 
				//입력은 char형 알파벳이지만 int형 배열로 선언해서 대문자 A의 아스키코드 65를 빼줘서 char형을 int형으로 바꿨다.
			}
		}
		
		alpha = new boolean[26];//boolean배열로 방문을 표시할 배열이다. 알파벳이 처음 들어오면 true로 바꿔준다.
		
		backTracking(0,0,1);//행 ,열 좌표와 깊이를 파라미터로 넣어 백트레킹+깊이우선 탐색을 시작한다.시작 칸을 포함하니까 1부터.
		// 말은 백트레킹을 하며 움직일 수 있는한 최대로 움직이는데, 여기서 이동이 depth의 크기가 된다. 
		System.out.println(maxDepth);
	}
	public static void backTracking(int row, int col, int depth) {
		//출력할 수
		maxDepth = Math.max(maxDepth, depth);
		//방문 표시
		alpha[board[row][col]] = true;
	
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};

		for(int d=0; d<4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			if(nr<R && nc<C && nr>=0 && nc>=0 && alpha[board[nr][nc]] == false) {
				backTracking(nr,nc,depth+1);
				alpha[board[nr][nc]] = false;//방문표시 해제
			}
		}
	}

}