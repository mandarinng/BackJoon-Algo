import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			set.add(st.nextToken());
		}
		
		if(game.equals("Y"))
			System.out.println(set.size());
		else if(game.equals("F"))
			System.out.println(set.size()/2);
		else
			System.out.println(set.size()/3);
	}
}