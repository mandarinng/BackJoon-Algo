//백준 16967 배열 복원하기
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int [][] b = new int[h+x][w+y];
		int [][] a = new int[h][w];
		
		for (int i = 0; i < b.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < b[0].length; j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=x; i<x+h; i++) {
			for(int j=y; j<y+w; j++) {
				b[i][j] -= b[i-x][j-y];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				sb.append(b[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}