import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static int N;
	public static int M;
	public static int[] result;
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr;
	public static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		result = new int[M];

		combination(0,0);
		System.out.println(sb);

	}

	public static void combination(int depth,int start) {
		//tmp라는 새로운 스트링빌더에 일단 넣기
		StringBuilder tmp = new StringBuilder();
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				tmp.append(result[i] + " ");
			}
			// 출력해야하는 숫자가 한 자릿수가 아닐 수 있으므로 string형 사용
			String str = tmp.toString();
			//hashset을 이용하면contains 를 사용해 이미 그 값이 들어있었는지 확인할 수 있음
			//-> hashset은 중복 허용x
			if(!set.contains(str)) {
				set.add(str);//중복되지 않은 값이면 set에 넣기
				//중복되지 않은 값인게 확인된 수만 출력할 스트링빌더sb에 넣어주기
				sb.append(tmp).append("\n");
			}
			return;
		}
		for (int i = start; i < N; i++) {
				result[depth] = arr[i];
				combination(depth + 1, i);

			}
	}
}