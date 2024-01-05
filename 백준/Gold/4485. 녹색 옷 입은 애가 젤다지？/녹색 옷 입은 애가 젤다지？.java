import java.util.*;
import java.io.*;

public class Main {

	static int N;//동굴의 크기
	static int tc = 1;
	static int[][] cave;//동굴의 가중치 정보
	static int[][] distance;//[0][0]에서부터 최단거리 기록 배열

	public static class Node implements Comparable<Node> {

		int row; // 노드의 행 좌표
		int col; // 노드의 열 좌표
		int cost; // 가중치

		// 우선순위 큐에서 최소 값을 얻기 위해 Comparable 인터페이스의 compareTo 메서드 구현
		public Node(int row, int col, int cost) {
			super();
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			if (N == 0) //을 입력받으면 프로그램 종료
				break;

			cave = new int[N][N]; // 입력받은 동굴
			distance = new int[N][N]; // 최단거리 기록용 배열

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					distance[i][j] = Integer.MAX_VALUE;// 최단 거리를 업데이트 해야하니까 일단 최대값으로 초기화
				}
			}

			dijkstra(0, 0);//  시작위치에서부터 다익스트라 시작(항상 (0,0)에서 시작)

			System.out.println("Problem " + tc++ + ": " + distance[N - 1][N - 1]);
		}

	}

	private static void dijkstra(int row, int col) {
		boolean visited[][] = new boolean[N][N];
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[row][col] = cave[row][col];// [0][0]의 최단 거리는 시작지점의 가중치
		pq.add(new Node(row, col, distance[row][col])); // pq에 시작 위치의 좌표값과 최소거리 넣기(가중치 말고 최단거리)

		//다익스트라 알고리즘 우선순위 큐를 활용한 풀이
		while (!pq.isEmpty()) {
			Node n = pq.poll(); //우선순위 큐에서 최단거리가 가장 짧은 노드를 꺼내기

			//4방 탐색
			for (int d = 0; d < 4; d++) {
				//범위를 벗어나지 않고, 아직 방문하지 않은 부분만 방문
				int nr = n.row + dr[d];
				int nc = n.col + dc[d];
				if( nr >= 0 && nc >=0 && nr <N && nc <N && !visited[nr][nc]) {
					
					int newCost = n.cost + cave[nr][nc]; //새로운 최단 거리 계산
					
					//새로운 최단 거리가 기존의 거리보다 작으면 업데이트하고 큐에 추가
					if(newCost < distance[nr][nc]) {
						distance[nr][nc] = newCost;
						pq.add(new Node(nr, nc, newCost));
					}
				}
			}

		}

	}

}