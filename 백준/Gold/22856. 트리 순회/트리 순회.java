import java.io.*;
import java.util.*;

public class Main {
	static int right_cnt = 0;
	static int [][] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
      
        tree = new int[n+1][2];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int node = Integer.parseInt(st.nextToken());
        	tree[node][0] = Integer.parseInt(st.nextToken()); //왼쪽 자식
        	tree[node][1] = Integer.parseInt(st.nextToken()); // =오른쪽 자식
        }
        //루트노드~가장 오른쪽 리프노드까지의 경로 개수 : right_cnt
        countRightPath(1);
        
        System.out.println(2*(n-1) - right_cnt);
    }
    //오른쪽 자식을 따라 탐색하며 경로 개수 계산
    public static void countRightPath(int curr) {
    	while(tree[curr][1] != -1) {
    		right_cnt++;
    		curr = tree[curr][1];
    	}
    }
}