//백준 6840 Who is int the middle?
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<3; i++) {
			int n = Integer.parseInt(br.readLine());
			list.add(n);
		}
		Collections.sort(list);
		System.out.println(list.get(1));
	}
}