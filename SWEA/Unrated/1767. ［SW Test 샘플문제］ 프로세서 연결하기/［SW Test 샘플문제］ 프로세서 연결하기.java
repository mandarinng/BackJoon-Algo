
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int[][] map;
    static int N;
    static boolean[] visited;
    static ArrayList<Point> Core;
    static int result;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine()); // NXN 멕시노트 입력됨
            map = new int[N][N];
            Core = new ArrayList<>();

            for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1) {
                        Core.add(new Point(i, j));
                    }
                }
            }
            result = Integer.MAX_VALUE;
            visited = new boolean[Core.size()];
            // 조합으로 전체 Core의 수~1개를 뽑는 경우의 수를 만들어서 dfs 돌리기
            for (int c = Core.size(); c >= 0; c--) {
                combination(0, 0, c);
                if (result != Integer.MAX_VALUE) { // 맨 첫번째로 갱신됐을때 값이 답
                    break;
                }
            }

            System.out.println("#" +tc+" "+ result);
        }
    }

    // 조합을 위햔 start, cnt는 현재까지 선택한 코일의 수, 매 조합 뽑아야 하는 코일의 수
    // Core개의 코일을 뽑았으면 이제 Core개의 코일 전원에 연결하기
    public static void combination(int start, int cnt, int Core) {
        if (cnt == Core) {
            connected(0, 0);
            return;
        }

        for (int i = start; i < visited.length ; i++) {
            visited[i] = true;
            combination(i + 1, cnt + 1, Core);
            visited[i] = false;
        }

    }

    // 조합에서 뽑힌 코일을 전원에 연결.
    // 뽑혔던 모든 코일을 다 연결시킬 수 있으면 최대값을 갱신하기위해 리턴하고,
    // 뽑혔던 모든 코일을 다 연결시킬 수 없으면 다음 조합으로 넘어가게 함.
    public static void connected(int curCore, int lineCnt) { // curCore:현재 처리중인 코어의 인덱스, lineCnt:현재까지 연결된 전선으 ㅣ길이

        // 모든 코어에 대한 처리가 완료되었으므로 전선 길이 lineCnt을 확인하고, 현재까지의 최소 전선 길이인 result를 업데이트
        if (curCore == Core.size()) {
            result = Math.min(result, lineCnt);
            return;
        }
        // 현재 코어가 조합에 포함되지 않았으므로, 다음 코어로 넘어감.
        if (!visited[curCore]) {
            connected(curCore + 1, lineCnt);// 재귀로 다음 조합 ㄱ
        }
        // 현재 코어의 위치 row, col에 저장
        int row = Core.get(curCore).x;
        
        int col = Core.get(curCore).y;

        // 원래 배열을 복사해두기
        // 백트래킹을 사용하여 모든 가능한 코어 연결 조합을 시도하는데, 각각의 조합을 시도하기 전에 copy 배열을 사용하여 현재 상태를 저장하고,
        // 시도가 끝난 후에 다시 이전 상태로 복구하는 역할
        int [][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
        // 델타로 현재 코어에서 한 쪽 방향으로 쭉 직진
        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];
            // 범위 내에 들어오고, 직진하는 방향으로 코일이 없는 빈칸일때까지 직전해서 최종 좌표 nr,nc에 저장
            while (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == 0) {
                nr += dr[d];
                nc += dc[d];
            }
            // 코일을 전원에 연결할 수 있는 경우 (가장자리에 도달 했을 떄)
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                nr -= dr[d];//nr,nc가 지금 범위를 한 칸 벗어난 상태니까 한 칸 땡겨서 범위 내로 들어오게 해주기
                nc -= dc[d];
                int distance = Math.abs(row - nr) + Math.abs(col - nc); //현재 코일의 위치와 도달한 가장자리의 위치 좌표 차이가 현재 코일에서의 가장자리까지 전선의 길이가 됨

                // 배열 채우기 : 전선 부분 2로 채우기
                while (nr != row || nc != col) {
                    map[nr][nc] = 2;
                    nr -= dr[d];
                    nc -= dc[d];
                }
                //다음 코일로 넘어가
                connected(curCore + 1, lineCnt + distance);
                // 배열 원상복구하기
                for (int i = 0; i < N; i++) {
    				for (int j = 0; j < N; j++) {
    					map[i][j] = copy[i][j];
    				}
    			}
            }

        }

    }

}