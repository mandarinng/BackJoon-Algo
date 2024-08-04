import java.io.*;
import java.util.*;
//백준 14235 크리스마스 선물

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//아이들과 거점지를 방문한 횟수
		
		List<Integer> list = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			if(a == 0) {
				if(list.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(list.get(0)).append("\n");
					list.remove(0);
				}
			}else {
				while(st.hasMoreTokens()) {
					list.add(Integer.parseInt(st.nextToken()));
				}
				Collections.sort(list, Collections.reverseOrder());
			}
			
		}
		System.out.println(sb.toString());

	}

}