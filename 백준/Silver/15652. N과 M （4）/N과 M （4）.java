import java.util.Scanner;

public class Main {

	public static int N;
	public static int M;
	public static int [] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[M];
		
		combination(0,1);
		System.out.println(sb);
	}
	public static void combination(int depth, int start) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=N; i++) {
			arr[depth] = i;	
			combination(depth+1, i);// (1,1)도 허용하니까 i부터

		}
		
		
	}
}