import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

	public static String S;
	public static int cnt; //재귀 함수(recursion)를 몇 번 호출하는지 횟수를 셈

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			S = br.readLine();
			cnt=0;// 각 문자열 별로 재귀함수 호출 횟수를 세줘야 하므로 초기화 해줘야함
			System.out.print(isPalindrome(S) +" ");// 팰린드롬인지 확인하기
			System.out.println(cnt);
		}
	}
	// 펠린드롬인지 확인하기위해 recursion 함수를 호출하기 위해 사용
	// 팰린드롬 검사의 첫 시작은 맨 처음 문자와 맨 끝 문자 비교
	public static int isPalindrome(String S) {
		return recursion(S, 0, S.length() - 1);
	}
	// 팰린드롬인지 확인하는 부분
	public static int recursion(String S, int start, int last) {
		cnt++;// 함수가 호출될때마다 카운트 세줌
		// 맞닿아있는 가장 센터 문자들까지 모두 확인했는데, 모두 일치했을 경우 펠린드롬 문자열임
		if (start >= last)
			return 1;
		// 양 방향의 문자를 비교해서 한 번이라도 다른 문자가 나왔다면 팰린드롬 문자열이 아님
		else if (S.charAt(start) != S.charAt(last))
			return 0;
		// 양 끝에서 시작해서 점점 중간으로 옮겨가며 양 방향의 문자가 똑같은지 비교하는 부분
		else {
			return recursion(S, start + 1, last - 1);
		}

	}
}