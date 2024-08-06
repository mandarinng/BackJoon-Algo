//백준 1668 트로피 진열
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		int [] trophys = new int[N];
		for (int i = 0; i < trophys.length; i++) {
			trophys[i] = Integer.parseInt(br.readLine());
		}
		int answer = 1;
		
		int max=trophys[0];		
		for (int i = 1; i < N; i++) {
			
			if(max < trophys[i]) {
				max = trophys[i];
				answer ++;
			}
			
		}
		sb.append(answer).append("\n");
		
		answer = 1;
		max = trophys[N-1];
		for(int i=N-1; i>=0; i--) {
			
			if(max < trophys[i]) {
				max = trophys[i];
				answer ++;
			}
		}
		sb.append(answer).append("\n");
		
		System.out.println(sb.toString());
		

	}

}