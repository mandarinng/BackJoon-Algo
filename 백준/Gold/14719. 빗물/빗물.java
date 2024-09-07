//백준 14719 빗물
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int [][] blocks = new int[W][H];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int x = Integer.parseInt(st.nextToken());
			for (int j = 0; j < x; j++) {
				blocks[i][j] = 1;
			}
		}

		int answer = 0;
		
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if(blocks[i][j] == 1) {
//					System.out.println( i + " " + j);
					int z = i+1;
					int cnt=0;
					while(z < W && blocks[z][j] == 0) {
						cnt++;
						z++;
						if(z == W) break;
					}
					if(z < W && blocks[z][j] == 1) {
						answer += cnt;
					}
//					System.out.println(answer);
				}
			}
		}
		System.out.println(answer);
	}

}