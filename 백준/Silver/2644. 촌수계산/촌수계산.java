import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] person;//관계를 입력받을 리스트 배열
	static int [] relationship;//사람 간의 촌수(깊이)를 기록할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		person = new ArrayList[N+1];//사람 번호가 1번부터니까
		for(int i=0; i<N+1; i++) {
			person[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int startPerson = Integer.parseInt(st.nextToken());// 이 사람이랑
		int targetPerson = Integer.parseInt(st.nextToken());// 이 사람이랑의 관계 깊이 출력할거임

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());// 입력받을 관계의 수

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			//a랑 b랑은 1촌 사이(간선 연결된 사이)
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//관계는 항상 쌍방향
			person[a].add(b);
			person[b].add(a);
		}//입력 끝
		
		//친척 관계가 없는 사람일 경우 촌수가 -1이므로 초기화 시켜줌.
		relationship = new int[N+1];
		for(int i=1; i<N+1; i++) {
			relationship[i] = -1;
		}
		
		bfs(startPerson,0);
		
		//출력할 답
		int result = 0;
		//타겟 사람 번호의 촌수(깊이)를 출력하기
		for(int i=1; i<N+1; i++) {
			if(i == targetPerson) {
				result = relationship[i];
			}
		}
		System.out.println(result);

	}
	//node가 사람, depth가 촌수(깊이)
	public static void bfs(int node, int depth) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		relationship[node] = depth++;//시작 사람과 시작 사람간의 촌수는 0
		while(!queue.isEmpty()) {
			int p = queue.poll();
			for(int x : person[p]) {
				if(relationship[x] == -1) {
					relationship[x] = relationship[p]+1;
					queue.add(x);
				}
			}
		}
		
	}
}