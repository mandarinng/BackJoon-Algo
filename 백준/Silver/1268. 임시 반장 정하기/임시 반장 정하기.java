//백준 1268 임시 반장 정하기
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int[n][5];//5학년까지
		int [] cnt = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			boolean[] visited = new boolean[n]; 
			for(int j=0; j<5; j++) {
				for(int k=0; k<n; k++) {
					if(i!=k && arr[i][j] == arr[k][j] && !visited[k]) {
						cnt[i]++;
						visited[k] = true;
					}
				}
			}
		}
		int maxCount = -1;
        int leader = -1;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > maxCount) {
                maxCount = cnt[i];
                leader = i;
            }
        }
		System.out.println(leader+1);
		
	}

}