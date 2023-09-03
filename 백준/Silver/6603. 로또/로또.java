import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int k;
	public static int [] S ;
	public static boolean [] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			S = new int[k];
			visit = new boolean[k];
			for(int i=0; i<k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			lotto(0,0);
            System.out.println();
			
		}
	}

	public static void lotto(int start, int depth) {
		//재귀함수 종료조건
		if(depth == 6) {
			for(int i=0; i<k; i++) {
				if(visit[i]) {
					System.out.print(S[i]+" ");
				}
			}
			System.out.println();
		}
		
		for(int i=start; i<k; i++) {
			visit[i]=true;
			lotto(i+1, depth+1);
			visit[i]=false;
		}
		
	}
	
}