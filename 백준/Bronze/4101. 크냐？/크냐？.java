import java.io.*;
import java.util.*;

//백준 4101 크냐?
public class Main {

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (a == 0 && b == 0) break;
            
            if (a > b) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
		}
		System.out.print(sb);
	}

}