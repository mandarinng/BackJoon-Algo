//백준 1764 듣보잡
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> names = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			names.add(br.readLine());
		}
		
		List<String> result = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if(names.contains(s)) result.add(s);
		}
		
		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		for(String name : result) {
			sb.append(name).append("\n");
		}
		System.out.println(sb.toString());
	}
}