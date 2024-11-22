//백준 1261 알고스팟
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int row;
		int col;
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
		@Override
		public int compareTo(Node other) {
			return Integer.compare(maze[this.row][this.col], maze[other.row][other.col]);
		}
	}
	static int n,m;
	static int [][] maze;
	static int [][] dist;
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		maze = new int[n][m];
		dist = new int[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				maze[i][j] = s.charAt(j) - '0';
			}
		}
		Node start = new Node(0,0);
		dijkstra(start);
		System.out.println(answer);
	}
	public static void dijkstra(Node start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start.row, start.col));
		dist[start.row][start.col] = 0;
		
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(dist[curr.row][curr.col] < maze[curr.row][curr.col]) continue;
			for(int d=0; d<4; d++) {
				int nr = dr[d] + curr.row;
				int nc = dc[d] + curr.col;
				if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
				
				if(dist[nr][nc] > maze[nr][nc] + dist[curr.row][curr.col]) {
					dist[nr][nc] = maze[nr][nc] + dist[curr.row][curr.col];
					pq.add(new Node(nr, nc));
//					System.out.println(nr+" "+nc+" "+dist[nr][nc]);
				}
			}
			if(curr.row == n-1 && curr.col==m-1) {
				answer = dist[curr.row][curr.col];
			}
		}
	}
}