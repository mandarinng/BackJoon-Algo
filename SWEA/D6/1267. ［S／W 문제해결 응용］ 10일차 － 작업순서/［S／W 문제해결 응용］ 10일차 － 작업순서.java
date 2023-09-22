import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수

			// 인접 행렬
			int[][] adjArr = new int[V + 1][V + 1];
			int[] degree = new int[V + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				adjArr[start][end] = 1;
				degree[end]++;
			}
			
			Queue<Integer> queue = new LinkedList<>();
			for(int i=1; i<V+1; i++) {
				if(degree[i] == 0) {
					queue.add(i);

				}
			}
			StringBuilder sb = new StringBuilder();
			while(!queue.isEmpty()) {
				int vNode = queue.poll();
				sb.append(vNode).append(" ");
				for(int i=1; i<V+1; i++) {
					if(adjArr[vNode][i]==1) {
						adjArr[vNode][i]=0;
						degree[i]--;
						if(degree[i] == 0) {
							queue.add(i);
						}
					}
				}

			}

			System.out.println("#" + tc + " "+sb);
		}

	}

}