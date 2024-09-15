//백준 1822 차집합
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int aCnt = Integer.parseInt(st.nextToken());
		int bCnt = Integer.parseInt(st.nextToken());

		HashSet<Integer> A = new HashSet<>();
		HashSet<Integer> B = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < aCnt; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < bCnt; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		A.removeAll(B);
		
		StringBuilder sb = new StringBuilder();
		sb.append(A.size()).append("\n");
		
		List<Integer> list = new ArrayList<>(A);
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}