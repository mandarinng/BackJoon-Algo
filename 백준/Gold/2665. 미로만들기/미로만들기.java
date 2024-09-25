//백준 2665 미로만들기
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int row;
	int col;
	int cost;

	public Node(int row, int col, int cost) {
		this.row = row;
		this.col = col;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node other) {
		return this.cost - other.cost; //가중치 낮은것부터! 오름차순 정렬
	}
}
public class Main {
	
	static int n;
	static int [][] maze;
	static int [][] dist;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		maze = new int[n][n];//미로 저장 배열
		dist = new int[n][n];//최소 가중치 저장할 배열
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				maze[i][j] = s.charAt(j)-'0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dist[0][0] = 0; //시작점의 가중치는 0(바꿔야할 최소 비용=0)
		dijkstra();
		System.out.println(dist[n-1][n-1]);
	}
	public static void dijkstra() {
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0,0)); //시작점(0,0)의 가중치는 0 -> pq에 넣어서 가중치 작은것 부터 빼면서 다익스트라
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			for(int d=0; d<4; d++) {
				int nr = current.row+dr[d];
				int nc = current.col+dc[d];
				if(nr<n && nc<n && nr>=0 && nc>=0) {
					if(maze[nr][nc] == 0) {//검은색
						if(dist[nr][nc] > current.cost+1) {
							dist[nr][nc] = current.cost+1;
							pq.add(new Node(nr, nc, dist[nr][nc]));
						}
					}else {//흰색
						if(dist[nr][nc] > current.cost) {
							dist[nr][nc] = current.cost;
							pq.add(new Node(nr, nc, dist[nr][nc]));
						}
					}
				}
			}
		}
	}
}