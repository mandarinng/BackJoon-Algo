import java.util.Scanner;

public class Main {
	public static int N;
	public static int M;
	public static int[] result;
	public static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 1~N까지의 자연수 중에
		M = sc.nextInt();// M개를 중복없이 고른다.depth의 크기가 M인것.
		result = new int[M];// M개의 개수를 골라서 골라진 애들만 뽑으면 되니까 M크기의 배열 생성
		visit = new boolean[N + 1];//1부터 N까지의 수가 들어가는지 안 들어가는지 확인해야하니까 N+1크기

		combination(0);

	}

	// 깊이가 M인 M개의 수를 뽑았을 때 재귀 끝남.
	// 뽑히기 시작하는 수 start
	public static void combination(int depth) {
		// 기저파트
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		// 재귀파트
		//1부터 N까지의 수 중에 출력할 수 선택하기
		for (int i = 1; i <= N; i++) {
			//만약 해당 수를 선택하지 않았다면, 선택하기(1,1)(2,2)와 같이 겹치지 않게!!
			if (!visit[i]) {
				result[depth] = i;
				visit[i] = true;
				combination(depth+ 1);
				visit[i] = false;
			}
		}
	}
}