//백준 1541 잃어버린 괄호
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		List<Integer> list = new ArrayList<>();
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			if(s.contains("+")) {
				String [] nums = s.split("\\+");
				int sum=0;
				for(String n : nums) {
					sum += Integer.parseInt(n);
				}
				list.add(sum);
			}else {
				list.add(Integer.parseInt(s));
			}
			
		}
		int answer = list.get(0);
		for(int i=1; i<list.size(); i++) {
			answer -= list.get(i);
		}
		System.out.println(answer);
	}
}