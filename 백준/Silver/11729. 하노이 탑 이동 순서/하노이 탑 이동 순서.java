import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

	public static StringBuilder sb = new StringBuilder();// sout하면 시간초과나서..

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());// 원판의 개수

		// 하노이탑의 공식: n개의 원판이 있을 때, 최소로 옮긴 횟수 : 2^k-1
		System.out.println((int)(Math.pow(2, N) - 1));
		hanoi(1, 3, N);
		if (N <= 20) {// N이 20이상일 경우는 출력할 필요 없다고 했으니까! 안 해주면 메모리 초과ㅠㅠ
			System.out.println(sb);
		}
	}
	public static void hanoi(int start, int end, int N) {
		// 기저파트
		
		if (N == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}
		// 재귀파트
		// n-1개의 원판을 시작 기둥에서 중간 기둥으로 옮긴다.
		// 세 기둥이 1,2,3이라고 했을때, 전체 합은 6이고, 중간 기둥은 6-start-end
		hanoi(start, 6 - start - end, N - 1);
		// n번 원판을 start기둥에서 end기둥으로 옮긴다.
		sb.append(start).append(" ").append(end).append("\n");
		// n-1개의 원판을 중간 기둥(6-start-end)에서 end기둥으로 옮긴다.
		hanoi(6 - start - end, end, N - 1);
	}

}