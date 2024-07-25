//백준 11723 집합
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	
		StringBuilder sb= new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = st.countTokens();

			if(n == 1) {
				if(st.nextToken().equals("all")) {
					list.clear();
					for(int j=1; j<=20; j++) {
						list.add(j);
					}
				}else {
					list.clear();
				}
			}else {
				String s = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				if(s.equals("add") && !list.contains(x)) list.add(x);
				else if(s.equals("remove") && list.contains(x)) list.remove(Integer.valueOf(x));
				else if(s.equals("check")) {
					if(list.contains(x)) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					
				}
				else if(s.equals("toggle")) {
					if(list.contains(x)) list.remove(Integer.valueOf(x));
					else list.add(x);
				}
			}
		}
		System.out.println(sb.toString());

	}

}