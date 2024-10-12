//백준 5086 배수와 약수
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==0 && b==0) break;
			if(a%b == 0) {
				sb.append("multiple").append("\n");
			}else if(b%a == 0) {
				sb.append("factor").append("\n");
			}else {
				sb.append("neither").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}