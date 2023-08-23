import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = sc.nextInt();
		int r=0;
		int c=0;
		int dir = 0;
		int [][]arr = new int[n][n];
		int cnt = n*n;
		arr[r][c] = cnt;
		
		//아래,오른쪽,위,왼쪽
		int [] dr = {1,0,-1,0};
		int [] dc = {0,1,0,-1};
		
		while(cnt>1) {
			dir = dir%4;

			if(r + dr[dir]>=0 && c + dc[dir]>=0 && r + dr[dir]<n && c + dc[dir]<n 
					&&arr[r + dr[dir]][c + dc[dir]] == 0) {
				r += dr[dir];
				c += dc[dir];
				arr[r][c] = --cnt;

			}
			else {
				++dir;

			}
		}
		int x=0;
		int y=0;
        StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(arr[i][j]+" ");
				if(arr[i][j]==result) {
					x=i;
					y=j;
				}
			}
			sb.append("\n");
		}
		sb.append((x+1)+" "+(y+1));
		System.out.println(sb);
	}

}
