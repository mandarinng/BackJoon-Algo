import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 위상정렬 문제

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 학생 수
		int M = Integer.parseInt(st.nextToken());// 키 비교 횟수

		ArrayList<Integer>[] graph = new ArrayList[N + 1]; // 키 비교할때 사용할 리스트 배열. 학생은 1번부터 시작이니까+1개해서 만들기
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] degree = new int[N + 1]; // 위상정렬을 할 떄는 진입차수를 알아야 하는데, degree배열에 각 학생별 진입차수를 저장할 것임
		// 비교할 키 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());// a는 b보다 항상 앞에 서야 한다.
			int b = Integer.parseInt(st.nextToken());
			// 유방향이니까 a번째 노드에 b 넣어주기
			graph[a].add(b);
			// 진입차수니까 a->b방향이므로 b의 진입차수만 늘려주기
			degree[b]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		// 진입차수가 0인 학생들만 일단 큐에 넣어주기
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0)
				queue.add(i);
		}

		StringBuilder sb = new StringBuilder();
		// 큐가 빌때까지 반복
		while (!queue.isEmpty()) {
			int student = queue.poll();// 앞에 설 학생(출력할 학생)
			sb.append(student).append(" ");
			// 출력한 학생(student == 앞에 서야 하는 학생이 아무도 없는 학생)과 연결된 모든 학생을 찾아서 연결끊기(degree 줄여서 진입차수 줄이기) 
			for (int i = 0; i < graph[student].size(); i++) {
				int x = graph[student].get(i);
				degree[x]--;
				if (degree[x] == 0) {//진입 차수를 줄이다가 0이되면(앞에 서야 하는 학생이 아무도 안 남으면 )큐에 넣기 -> 계속 반복!!
					queue.add(x);

				}

			}
		}

		System.out.println(sb);

	}

}