import java.util.*;
import java.io.*;

public class Main {
	
	static int [] arr;
	static int K;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//수빈이 위치
		K = Integer.parseInt(st.nextToken());//동생 위치
		
		arr = new int[100001];//수빈이와 동생이 있는 길(0<=N,K<=100000)
		Arrays.fill(arr, Integer.MAX_VALUE);//우선 길을 젤 큰 값으로 채워두고, 최소 초로 바꿀 것
		
		bfs(N, 0); //수빈이의 현재 위치는 0초만에 갈 수 있음
		
		System.out.println(arr[K]);
//		for(int i=0; i<=10; i++) {
//			System.out.print(arr[i]+" ");
//		}
			
	}
	public static void bfs(int curr, int time) {
		
		arr[curr] = time++; //수빈이의 시작 위치 표시
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(curr);
		
		while(!queue.isEmpty()) {
			
			int node = queue.poll();
			
			if(node+1<=100000 && arr[node+1] > arr[node]+1) {
				arr[node+1] = arr[node]+1;
				queue.add(node+1);
			}
			if(node-1>=0 && arr[node-1] > arr[node]+1) {
				arr[node-1] = arr[node]+1;
				queue.add(node-1);
			}
			if(node*2 <=100000 && arr[node*2] > arr[node]) {
				arr[node*2] = arr[node];
				queue.add(node*2);
			}
			
//			if(arr[K] != Integer.MAX_VALUE) break;
		}
	}

}