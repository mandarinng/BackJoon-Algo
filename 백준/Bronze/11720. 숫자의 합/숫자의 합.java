import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		int sum=0;
		int [] arr = new int[N];
		String s = sc.nextLine();
		for(int i=0; i<N; i++) {
			
			arr[i] = s.charAt(i)-'0';
			sum += arr[i];
		}
		System.out.println(sum);
	}

}
