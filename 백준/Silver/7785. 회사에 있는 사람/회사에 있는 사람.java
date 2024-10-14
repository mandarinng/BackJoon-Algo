//백준 7785 회사에 있는 사람
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Set<String> names = new HashSet<>();
		for (int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String yn = st.nextToken();
			
			if(yn.equals("enter")) {
				names.add(name);
			}else {
				names.remove(name);
			}
		}
		List<String> names2 = new ArrayList<>(names);
		Collections.sort(names2, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(String name : names2) {
			sb.append(name).append("\n");
		}
		System.out.println(sb.toString());
	}
}