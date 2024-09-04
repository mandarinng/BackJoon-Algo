//백준 1759 암호 만들기
import java.io.*;
import java.util.*;

public class Main {
	
	static List<Character> aeiou = Arrays.asList('a', 'e', 'i', 'o', 'u');
	static int L,C;
	static char [] alpha;
	static char [] temp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		temp = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);
		
		backtracking(0,0);
		
		System.out.println(sb.toString());
		
	}
	public static void backtracking(int depth, int cnt) {
		if(cnt == L) {
			if(isValid()) {
				for(char c : temp) {
					sb.append(c);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		for(int i=depth; i< C; i++) {
			temp[cnt] = alpha[i];
			backtracking(i+1, cnt+1);
		}
	}
	//모음을 최소 1개, 자음을 최소 2개 포함했는지 확인
	public static boolean isValid() {
		
		int voCnt = 0;//모음 개수
		int conCnt = 0;//자음 개수
		
		for (int i = 0; i < temp.length; i++) {
			if(aeiou.contains(temp[i])) {
				voCnt++;
			}else {
				conCnt++;
			}
		}
		
		if(voCnt >= 1 && conCnt >= 2) {
			return true;
		}else {
			return false;
		}
		
	}
}