import java.util.*;
import java.io.*;

public class Main {
	
	static int [] arr;
	static int [] parent;
	static int N,K;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//수빈이 위치
		K = Integer.parseInt(st.nextToken());//동생 위치
		
		arr = new int[100001];//수빈이와 동생이 서있는 길에 도달할 수 있는 최소 시간 기록한 배열
		parent = new int[100001];//각 위치에 도달할 때 거쳤던 부모 위치 기록한 배열
		
		Arrays.fill(arr, Integer.MAX_VALUE);
		bfs(N);//수빈이 위치에서 시작
		
		System.out.println(arr[K]);
		
		printStack(K);
		System.out.println(sb);
	}
	public static void bfs(int start) {
		
		arr[start] = 0; //수빈이가 있는 위치의 도착 시간은 0
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			//범위를 벗어나지 않고, arr 배열에 방문가능한 최소 초를 기록
			if(node+1<=100000 && arr[node+1] > arr[node]+1) {
				arr[node+1] = arr[node]+1;
				queue.add(node+1);
				parent[node+1] = node;//parent 배열에 이 전에 방문했던 부모를 표시함
			}
			if(node-1>=0 && arr[node-1] > arr[node]+1) {
				arr[node-1] = arr[node] + 1;
				queue.add(node-1);
				parent[node-1] = node;
			}
			if(node*2<=100000 && arr[node*2] > arr[node]+1) {
				arr[node*2] = arr[node] + 1;
				queue.add(node*2);
				parent[node*2] = node;
			}
		}
		
	}
	//parent배열에 적힌 부모를 통해 동생의 위치에서 언니의 위치로 거슬러 올라가며 스택에 쌓기 
	public static void printStack(int end) {
		Stack<Integer> stack = new Stack<>();
		int node = end;//node는 지금 동생의 위치
		
		//node 변수를 통해 parent에 적힌 부로를 계속 타고 올라감.동생에서부터 수빈이의 위치에 도달하면 끝
		while(node != N) {
			stack.push(node);
			node = parent[node];
		}
		stack.push(N);//마지막에 수빈이의 위치는 스택에 넣어주지 않았으므로 따로 처리
		
		//스택에서 하나씩 뽑아 지금까지 방문한 길들 위치 출력하기
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
	}

}