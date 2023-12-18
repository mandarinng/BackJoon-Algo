import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int [] arr;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N];
		visited = new boolean[N+1];
		
		dfs(0);
		
		System.out.println(sb);
	}
	public static void dfs(int cnt) {
		
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				arr[cnt] = i;
				visited[i] = true;
				dfs(cnt+1);
				visited[i] = false;
			}
		}
		
	}

}