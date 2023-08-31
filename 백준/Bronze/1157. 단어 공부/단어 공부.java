import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int [] alpha = new int[26];//26개의 알파벳을 의미하는 배열
		for(int i=0; i<s.length(); i++) {
			//대분자부분
			// 대분자 A의 아스키코드 : 65
			if(s.charAt(i) >= 65 && s.charAt(i)<=90) {
				alpha[s.charAt(i)-65]++;
			}
			//소문자
			else {
				//소문자 a의 아스키코드 : 97
				alpha[s.charAt(i)-97]++;
			}
		}
		int max=0;
		char c = '0';
		for(int i=0; i<alpha.length; i++) {
			if(max<alpha[i]) {
				max = alpha[i];
				c = (char)(i+65);//대문자로 출력해야하니 다시 65 더해줌
			}
			else if(max == alpha[i]) {
				c = '?';
			}
		}
		
		System.out.println(c);
	}

}