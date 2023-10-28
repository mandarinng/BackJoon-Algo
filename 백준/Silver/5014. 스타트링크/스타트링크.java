import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int f,s,g,u,d;
	static int visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		f = sc.nextInt();//최고층
		s = sc.nextInt();//강호 층
		g = sc.nextInt();//가야할 곳
		u = sc.nextInt();//업
		d = sc.nextInt();//다운
		visited = new int[f+1];

		bfs(f,s,g,u,d);
	}
	
	static void bfs(int f, int s, int g, int u, int d) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s]=1;//시작점 방문함(버튼 안눌렀지만 1로 표시)
		
		while(!q.isEmpty()) {
			int c = q.poll();//현재위치
			
			if(c==g) {//현재위치 = 가야할 곳
				System.out.println(visited[c]-1);//맨 처음 버튼 누른것처럼 한거 뺀다
			}
			
			if(c+u <= f && visited[c+u]==0) {//현재위치+업<= 최고층 && 방문 안했으면
				visited[c+u]=visited[c]+1;
				q.add(c+u);
			}
			
			if(c-d > 0 && visited[c-d]==0) {//현재위치-다운 > 0 && 방문 안했으면
				visited[c-d] = visited[c]+1;
				q.add(c-d);
			}
			
		}
		
		if(visited[g]==0)
			System.out.println("use the stairs");
		
	}
}