import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	
	static StringTokenizer st;
	static int N,M;
	static List<Point>[] adjList;
	static int [] dist;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		//인접 리스트
		adjList = new ArrayList[N+1];//도시 번호는 1~N
		for(int i=0; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		//도시들의 최단거리 기록할 배열
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());//시작 도시
			int B = Integer.parseInt(st.nextToken());//도착 도시
			int W = Integer.parseInt(st.nextToken());//버스비
			
			adjList[A].add(new Point(B,W));//단방향 버스
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());//최종 시작 도시
		int end = Integer.parseInt(st.nextToken());//최종 도착 도시
		
		dijkstra(start);
		
		System.out.println(dist[end]);
	}
	public static void dijkstra(int startCity) {
		boolean [] visited = new boolean[N+1];//방문 배열
		
		dist[startCity] = 0;
		
		for(int i=1; i<N+1; i++) {
			int idx = -1;
			int min = Integer.MAX_VALUE;
			
			for(int j=1; j<N+1; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			if(idx == -1) break;
			
			visited[idx] = true;
			
			for(Point curr : adjList[idx]) {
				if(!visited[curr.x] && dist[curr.x] > dist[idx] + curr.y) {
					dist[curr.x] = dist[idx] + curr.y;
				}
			}
		}
	}

}