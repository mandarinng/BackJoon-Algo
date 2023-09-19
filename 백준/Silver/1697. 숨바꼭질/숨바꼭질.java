import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		
		 
		int result = bfs(N);
		System.out.println(result);

	}
	public static int bfs(int start) {
		Queue <Integer> queue = new LinkedList<>();
		queue.add(start);
		
		int [] path = new int[100001];
	
		path[start] = 1;
		
		while(!queue.isEmpty()) {

			int x = queue.poll();
			
			if(x == K) {
				return path[x]-1;
			}
			if(x-1>=0 && path[x-1]==0) {
				path[x-1] = path[x]+1;
				queue.add(x-1);
			}
			if(x+1<=100000 && path[x+1]==0) {
				path[x+1] = path[x]+1;
				queue.add(x+1);
			}
			if(x*2<=100000 && path[x*2]==0) {
				path[x*2] = path[x]+1;
				queue.add(x*2);
			}
			
		}
		
		return 0;
	}

}