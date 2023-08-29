import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		while(true) {
			String s = sc.nextLine();
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'|| s.charAt(i) == 'o'|| s.charAt(i) == 'u'||s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'|| s.charAt(i) == 'O'|| s.charAt(i) == 'U') {
					cnt++;
				}
			}
			if(s.equals("#")) break;
			else System.out.println(cnt);
			cnt=0;
		}
		
	}

}