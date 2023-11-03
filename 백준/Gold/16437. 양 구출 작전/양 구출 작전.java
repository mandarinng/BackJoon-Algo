import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] graph;
	static long [] animal;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //섬의 개수
		
		graph = new ArrayList[N+1]; //인접 리스트
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		animal = new long[N+1];// 각 섬에 있는 양이나 늑대의 수 
		
		for(int i=2; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			//양이면 +값으로 입력 받기
			char sw = st.nextToken().charAt(0);
			if(sw == 'S') {
				animal[i] = Integer.parseInt(st.nextToken());
			}
			else {//늑대면 -값으로 입력 받기
				animal[i] = - Integer.parseInt(st.nextToken());
			}
			
			int v = Integer.parseInt(st.nextToken());//현재 섬과 연결돼있는 섬
//			graph[i].add(v);
			graph[v].add(i);
			
		}
		
		dfs(1,-1); //1번 섬부터 시작. 1번 섬의 이전 노드는 없기 때문에 -1로 초기화해둠.

		System.out.println(animal[1]); //루트 노드는 최종적으로 양의 수를 갖게 된다.
		
	}
	public static void dfs(int now, int before) { //now는 현재 섬, before은 이전 섬
		//now와 연결된 다음 섬(next)으로 이동(리프노드까지)
		for(int next : graph[now]) {
				dfs(next, now);
		}
		if(before != -1) { //이전 섬이 존재하는 경우
			if(animal[now] > 0) {// 섬에 양이 있는 경우 
				animal[before] += animal[now];//리프 노드에서부터 바텀업 방식으로 양의 수 더해주기
			}
		}
	}

}