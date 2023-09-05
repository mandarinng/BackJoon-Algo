import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int N;
	public static int M;
	public static int [] result;
	public static StringBuilder sb = new StringBuilder();
	public static int [] arr;
	public static boolean [] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		visit = new boolean[N];
		result = new int[M];
		
		combination(0);
		System.out.println(sb);
	}
	public static void combination(int depth) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
			result[depth] = arr[i];
			visit[i] = true;
			combination(depth+1);
			visit[i] = false;
			}
		}
	}
}