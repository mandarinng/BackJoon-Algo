import java.io.*;
import java.util.*;

//백준 25497 기술 연계 마스터 임스

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		
		int answer = 0;
		
		Stack<Character> lr = new Stack<>();
		Stack<Character> sk = new Stack<>();

		for(int i=0; i<n; i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) { //숫자일 때
				answer++;
			}else if(c=='L') {
				lr.add(c);
			}else if(c=='S') {
				sk.add(c);
			}else if(c=='R') {
				if(!lr.isEmpty()) {
					lr.pop();
					answer++;
				}else {
					break;
				}
			}else if(c=='K') {
				if(!sk.isEmpty()) {
					sk.pop();
					answer++;
				}else {
					break;
				}
			}
		}
		System.out.println(answer);
	}
}