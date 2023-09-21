import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] friends; //친구 관계를 표시할 리스트 배열
	static int [] visited;//i번째 사람의 친구 관계의 깊이(케빈 베이컨)를 기록할 배열 
	static int N;//N명의 유저

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
		
		friends = new ArrayList[N+1];//사람의 번호는 1부터니까N+1
		for(int i=0; i<N+1; i++) {
			friends[i] = new ArrayList<>();
		}
		//M개의 관계 수 입력받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//친구관계는 쌍방이니까
			friends[a].add(b);
			friends[b].add(a);
		}
		//1~N명의 사람의 케빈베이컨 수를 기록할 배열
		int [] kevin = new int[N+1];
		for(int i=1; i<N+1; i++) {
			int sum=0;//새로운 사람 bfs돌리기 전에 케빈베이컨 초기화
			bfs(i,0);//i번째 사람 bfs 돌리기(1~N번의 사람 만큼), 0은 방문순서를 나타냄.i번째 사람과 i와의 관계는 0.
			for(int j=1; j<N+1; j++) {
				sum += visited[j];//i번째 사람의 케빈베이컨을 계산함
			}
			kevin[i] = sum;//i번째 사람의 케빈베이컨을 kevin배열의 i번째 인덱스에 저장
		}
		
		int result=Integer.MAX_VALUE;//케빈베이컨 수가 최소인 사람을 찾아야하므로 일단 젤 큰수로 설정
		for(int i=1; i<N+1; i++) {
			result = Math.min(result, kevin[i]);// N명 사람의 케빈베이컨중 최소값 찾기
		}
		//최소 케빈베이컨을 가진 사람이 여러명일 떄 번호가 작은 사람이 출력되니까 찾자마자 return해서 함수 종료
		for(int i=1; i<N+1; i++) {
			if(kevin[i] == result) {
				System.out.println(i);
				return;
			}
		}

	}
	//user는 i번째 사람의 i를 의미. cnt는 깊이를 의미함. 깊이들의 합이 케빈 베이컨임.
	public static void bfs(int user,int cnt) {
		visited = new int[N+1]; //방문 순서를 넣을 배열 bfs새로 할 때 마다 초기화
//		for(int i=0; i<N+1; i++) {
//			visited[i] = -1;
//		}
		Queue <Integer> queue = new LinkedList<>();
		queue.add(user);
		visited[user] = cnt++;
		while(!queue.isEmpty()) {
			int p = queue.poll();
			for(int x : friends[p]) {
				if(visited[x] == 0) {
					visited[x] = visited[p]+1;
					queue.add(x);
				}
			}
		}
		
	}

}