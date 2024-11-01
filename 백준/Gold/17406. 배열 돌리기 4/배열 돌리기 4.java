//백준 17406 배열 돌리기4
import java.io.*;
import java.util.*;

public class Main {
	static int k, answer, n, m;
	static int[][] map;
	static int[][] rotation;
	static boolean[] visited;
	static int [] order; // rotation에 저장된 k개의 연산의 순서 저장한 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken()); // 회전 연산 개수

		map = new int[n][m];
		answer = Integer.MAX_VALUE; // 정답 : 최소값

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotation = new int[k][3]; // 회전연산을 저장한 배열
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			rotation[i][0] = Integer.parseInt(st.nextToken());
			rotation[i][1] = Integer.parseInt(st.nextToken());
			rotation[i][2] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[k];
		order = new int[k];
		// 순열로 회전 연산 순서 결정
		backtracking(0);
		
		System.out.println(answer);

	}
	//order 배열에 연산 순서 지정해서 calculate함수 시작
	public static void backtracking(int depth) {

		if (depth == k) {
			calculate(order);
			return;
		}
		for (int i = 0; i < k; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[depth] = i;
				backtracking(depth + 1);
				visited[i] = false;
			}
		}
	}
	// 회전 연산 시작
	public static void calculate(int [] order) {
		int [][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = map[i][j];
			}
		}

		//order에 들어있는 순서대로!! 회전 시작!!
		for(int t=0; t<k; t++) {
			
			int turnR = rotation[order[t]][0] - 1;//중심행
			int turnC = rotation[order[t]][1] - 1;//중심열
			int turnS = rotation[order[t]][2]; //반경
			
			//돌아야 하는 층 개수 : 안쪽에서 바깥쪽으로 회전 범위 넓혀나감
			for(int s=1; s<=turnS; s++) {
				int topLeft = copy[turnR - s][turnC - s]; //가장 왼쪽 위
				
				//왼쪽 열 위로 이동
				for(int i=turnR - s; i<turnR +s; i++) {
					copy[i][turnC - s] = copy[i+1][turnC - s];
				}
				//아래쪽 행 왼쪽으로 이동
				for(int i=turnC - s; i<turnC + s; i++) {
					copy[turnR + s][i] = copy[turnR + s][i+1];
				}
				//오른쪽 열 아래로 이동
				for(int i=turnR + s; i > turnR - s; i--) {
					copy[i][turnC + s] = copy[i-1][turnC + s];
				}
				//위쪽 행 오른쪽으로 이동
				for(int i=turnC + s; i > turnC-s + 1; i--) {
					copy[turnR - s][i] = copy[turnR - s][i-1];
				}
				copy[turnR - s][turnC - s + 1] = topLeft;
			}
			
		} // 회전 끝
		int minSum = Integer.MAX_VALUE; //이번 회전에서 최소값
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=0; j<m; j++) {
				sum += copy[i][j];
			}
			minSum = Math.min(minSum, sum);
		}
		
		answer = Math.min(answer, minSum);
	}
}