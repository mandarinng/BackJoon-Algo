//백준 1004 어린왕자

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			
			for(int i=0; i<n; i++) {
				int cnt=0;
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				if((sx-x)*(sx-x) + (sy-y)*(sy-y) <= r*r) {
					answer ++;//시작점 포함하는지
					cnt++;
				}
				if((ex-x)*(ex-x) + (ey-y)*(ey-y) <= r*r) {
					answer ++;//도착점 포함하는지
					cnt++;
				}
				if(cnt == 2) {
					answer -= 2;//둘 다 포함하면 다시 제외하기
				}
			}
			System.out.println(answer);
		}
		
	}

}