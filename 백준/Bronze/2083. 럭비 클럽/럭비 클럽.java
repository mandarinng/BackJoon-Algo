//백준 2083 럭비 콜럽
import java.io.*;
import java.util.*;

public class Main {
	
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			if(name.equals("#") && age==0 && weight==0) break;
			
			sb.append(name).append(" ");
			
			if(age > 17 || weight >= 80) {
				sb.append("Senior").append("\n");
			}else {
				sb.append("Junior").append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}