//백준 과제 안 내신 분..? 5597
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashSet<Integer> a = new HashSet<>();
		HashSet<Integer> b = new HashSet<>();
		
		for (int i = 1; i <= 30; i++) {
			a.add(i);
		}
		
		for (int i = 0; i < 28; i++) {
			int n = Integer.parseInt(br.readLine());
			b.add(n);
		}
		a.removeAll(b);
		
		ArrayList<Integer> result = new ArrayList<>(a);
		Collections.sort(result);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}
}