import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i=0;

		while(true) {
			if(N <= 6*(i*(i+1)/2)+1)  {
				System.out.println(i+1);
				break;
			}
			i++;
		}

	}

}
