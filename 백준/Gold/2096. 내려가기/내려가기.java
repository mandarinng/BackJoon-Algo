//백준 2096 내려가기
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] minPre = new int[3];
        int[] maxPre = new int[3];
        int[] minCurr = new int[3];
        int[] maxCurr = new int[3];
        
		for (int i = 0; i < 3; i++) {
			minPre[i] = arr[0][i];
			maxPre[i] = arr[0][i];
		}
		// 만약 N이 1이면 바로 결과 출력
        if (N == 1) {
            int answerMin = Math.min(minPre[0], Math.min(minPre[1], minPre[2]));
            int answerMax = Math.max(maxPre[0], Math.max(maxPre[1], maxPre[2]));
            
            System.out.println(answerMax + " " + answerMin);
            return;
        }
        
		for (int i = 1; i < N; i++) {
			minCurr[0] = arr[i][0] + Math.min(minPre[0], minPre[1]);
			minCurr[1] = arr[i][1] + Math.min(minPre[0], Math.min(minPre[1], minPre[2]));
			minCurr[2] = arr[i][2] + Math.min(minPre[2], minPre[1]);
			
			maxCurr[0] = arr[i][0] + Math.max(maxPre[0], maxPre[1]);
			maxCurr[1] = arr[i][1] + Math.max(maxPre[0], Math.max(maxPre[1], maxPre[2]));
			maxCurr[2] = arr[i][2] + Math.max(maxPre[2], maxPre[1]);
			
			for (int j = 0; j < 3; j++) {
				minPre[j] = minCurr[j];
				maxPre[j] = maxCurr[j];
			}
			
		}

		int answerMin = Math.min(minCurr[0], Math.min(minCurr[1], minCurr[2]));
		int answerMax = Math.max(maxCurr[0], Math.max(maxCurr[1], maxCurr[2]));
		
		StringBuilder sb = new StringBuilder();
		sb.append(answerMax).append(" ").append(answerMin);
		System.out.println(sb.toString());
	}
}