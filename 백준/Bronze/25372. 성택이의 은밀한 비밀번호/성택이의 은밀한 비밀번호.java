//백준 25372 성택이의 은밀한 비밀번호
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String pw = br.readLine();
			if(pw.length()>=6 && pw.length()<=9) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}