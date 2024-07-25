import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 5073 삼각형과 세 변
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			String s = br.readLine();
			if (s.equals("0 0 0"))
				break;

			st = new StringTokenizer(s);
			int[] arr = new int[3];
			for (int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			if (arr[0] + arr[1] <= arr[2]) {
				sb.append("Invalid").append("\n");
			}else if (arr[0] == arr[1] && arr[0] == arr[2]) {
				sb.append("Equilateral").append("\n");
			} else if (arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
				sb.append("Isosceles").append("\n");
			} else if (arr[0] != arr[1] && arr[0] != arr[2]) {
				sb.append("Scalene").append("\n");
			}

		}
		System.out.println(sb.toString());

	}

}