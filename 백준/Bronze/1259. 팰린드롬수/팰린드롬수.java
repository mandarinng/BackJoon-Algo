import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		a:while (true) {
			String nums = br.readLine();
			if (nums.equals("0"))
				break;
			int N = nums.length();
			for (int i = 0; i < N / 2; i++) {
				if (nums.charAt(i) == nums.charAt(N - i - 1)) {
					continue;
				} else {
					System.out.println("no");
					continue a;
				}

			}
			System.out.println("yes");

		}
	}

}