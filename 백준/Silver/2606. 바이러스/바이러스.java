import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int cnt;
	static ArrayList<Integer>[] graph;
	static boolean [] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computer = Integer.parseInt(br.readLine());// 컴퓨터의 수
		int pair = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수
		
		cnt=-1;//출력할 숫자. 1번 컴퓨터와 연결된 컴퓨터의 수. 0부터 하면 자기 자신도 세니까 -1부터.
		visited = new boolean[computer+1]; // 이미 방문한 컴퓨터인지 표시하기 위한 배열
		
		//컴퓨터 쌍을 나타내는 리스트 배열. 컴퓨터는 1번부터니까 +1개의 배열 생성
		graph = new ArrayList[computer+1];
		for(int i=0; i<computer+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			
			graph[com1].add(com2);
			graph[com2].add(com1);
		}
		
		dfs(1);//1번 컴퓨터와 이어진 컴퓨터를 찾아야 하니까 1부터 시작
		
		System.out.println(cnt);
		
	}
	public static void dfs(int computerNum) {
		cnt++;
		visited[computerNum] = true;
		for(int x: graph[computerNum] ) {
			if(!visited[x]) {
			dfs(x);
			}
		}
	}

}