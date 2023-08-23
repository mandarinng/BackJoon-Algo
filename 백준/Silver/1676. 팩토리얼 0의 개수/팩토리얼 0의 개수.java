
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		
		cnt = num/5+num/25+num/125;
		System.out.println(cnt);
	}

}