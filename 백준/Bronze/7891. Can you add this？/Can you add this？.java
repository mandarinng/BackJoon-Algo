import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())).append("\n");
		}
		
		System.out.println(sb);
		
	}

}