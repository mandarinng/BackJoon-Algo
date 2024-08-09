//백준 4659 비밀번호 발음하기
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String password = br.readLine();
			String[] alpha = password.split("");
			
			if(password.equals("end")) break;

			String quality = "is acceptable.";
			
			boolean check = false;
			
			//모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
			for (int i = 0; i < alpha.length; i++) {
				if(alpha[i].equals("a") || alpha[i].equals("e") || alpha[i].equals("i") || alpha[i].equals("o") || alpha[i].equals("u")) {
					check = true;
					break;
				}
			}
			
			//모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
			int[] arr = new int[3];
			String vowels = "aeiou";
			for (int i = 0; i < password.length(); i++) {
				char c = password.charAt(i);
				
				arr[0] = arr[1];
				arr[1] = arr[2];
				
				//vowels에 c문자가 포함돼 있으면(모음이면)-1 아니면(자음이면) 1
				if(vowels.indexOf(c) >= 0)
					arr[2] = -1; //모음이 들어오면 -1 넣기
				else
					arr[2] = 1;
				
				int sum = arr[2]+arr[1]+arr[0];
				if(sum == -3 || sum == 3) {
					check = false;
					break;
				}
			}
			
			
			//같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
			for (int i = 1; i < alpha.length; i++) {
				if(!alpha[i].equals("e") && !alpha[i].equals("o") && alpha[i-1].equals(alpha[i])) {
					check = false;
					break;
				}
			}
			
			sb.append("<").append(password).append(">").append(" ");
			if(check)
				sb.append("is acceptable.").append("\n");
			else
				sb.append("is not acceptable.").append("\n");
		}
		System.out.println(sb.toString());

	}

}