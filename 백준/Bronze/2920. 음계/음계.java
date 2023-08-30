import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] c = new int [8];
		for(int i=0; i<8; i++) {
			c[i] = sc.nextInt();
		}
		String result = "";
		for(int i=0; i<7; i++) {
			if(c[i+1] == c[i]+1) {
				result ="ascending";
			}
			else if(c[i] == c[i+1]+1) {
				result ="descending";
			}
			else {
				result ="mixed";
				break;
			}
		}
		System.out.println(result);
	}

}