import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());//영수증에 적힌 총 금액
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//영수증에 적힌 물건의 종류
		
		int sum=0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());//물건의 가격
			int b = Integer.parseInt(st.nextToken());//물건의 개수
			
			sum += a*b;
		}
		
		if(sum == X) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
		
	}

}