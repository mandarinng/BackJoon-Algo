import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()); //tc
		
		for(int i=0; i<T; i++) {
			 st = new StringTokenizer(br.readLine());
			 
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 
			 int answer = 1;
			 int base = a % 10; //1의 자리만 남김
			 
			 for(int j=0; j<b; j++) {//b번 제곱
				 answer = (answer * base) % 10; //매번  1의 자리만 남게하기
			 }
			 
			 if(answer == 0) answer = 10;//10번은 10 출력되게하기
			 
			System.out.println(answer);
		}
		

	}

}