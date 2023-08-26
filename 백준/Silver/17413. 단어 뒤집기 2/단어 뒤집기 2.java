import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine()," <>",true);
		

		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			if(s.equals("<")) {
				while(!(s.equals(">"))) {
					System.out.print(s);
					s = st.nextToken();
				}
				System.out.print(s);
			}
			else {
				for(int i=s.length()-1; i>=0; i--) {
					System.out.print(s.charAt(i));
				}
			}
		}		
	}

}