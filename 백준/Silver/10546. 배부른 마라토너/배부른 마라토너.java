//백준  10546번 배부른 마라토너
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			if(map.containsKey(name)) {
				map.put(name, map.get(name)+1);
			}else {
				map.put(name, 1);
			}
		}
		for(int i=0; i<N-1; i++) {
			String name = br.readLine();
			if(map.get(name) == 1) {
				map.remove(name);
			}else {
				map.put(name, map.get(name)-1);
			}
		}

		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				sb.append(entry.getKey());
			}
		}
		System.out.println(sb.toString());
	}
}