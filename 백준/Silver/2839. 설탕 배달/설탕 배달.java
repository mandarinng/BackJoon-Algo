import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<=N/3; i++) {
			for(int j=0; j<=N/5; j++) {
				if(N == 3*i + 5*j) {
					System.out.println(i+j);
					return;
				}
					
			}
		}
		System.out.println("-1");
	
	
	}

}