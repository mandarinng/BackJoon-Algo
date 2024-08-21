//백준 5568번 카드 놓기
import java.util.*;
import java.io.*;

public class Main {

	static int N, k;
	static int [] cards;
	static boolean [] visited;
	static Set<String> set;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}
		
		visited = new boolean[N];
		set = new HashSet<>();
		
		combination(0, "");

		System.out.println(set.size());
	}
	public static void combination(int cnt, String s) {
		if(cnt == k) {
			set.add(s);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(cnt+1, s+cards[i]);
				visited[i] = false;
			}
		}
	}
}