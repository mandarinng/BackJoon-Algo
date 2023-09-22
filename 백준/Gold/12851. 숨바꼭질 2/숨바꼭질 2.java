import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;//수빈이랑 동생이 서있는 길
	static long find=0;//가장 빠른 시간으로 찾는 방법이 몇 가지?
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 내 위치
		K = Integer.parseInt(st.nextToken());// 동생 위치

		arr = new int[100001];// 수빈이와 동생이 있는 길.(0<=N,K<=100000)
		Arrays.fill(arr, Integer.MAX_VALUE);//우선 길을 다 젤 큰 값으로 채워주기

		bfs(N, 0);
		
		for(int i=0; i<100001; i++) {
			if( i == K)
				System.out.println(arr[i]);
		}
		if(N == K) {//동생이랑 내가 똑같은 위치에 있을떄는 가지수가 1가니이므로 따로 처리해주기. 아니면 계속 0나옴
			System.out.println(1);
		}
		else
			System.out.println(find);
			

	}

	public static void bfs(int node, int depth) {
		
		arr[node] = depth++;//수빈이가 있는 위치는 0초만에 갈 수 있다.
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);//큐에 현재 초의 위치 넣기

		while (!queue.isEmpty()) {
			int x = queue.poll();
			// x-1
			if (x - 1 >= 0) {//범위 내에 들어오고
				if(arr[x-1]>=arr[x]+1) {// 값이 갱신될 때!! 근데 =을 붙여줘야 find를 올려줄 수 있음. 똑같은 값이 들어올때 find가 올라가는 거니까
					arr[x-1] = arr[x]+1;//미리 채워줬던 integer.maxvalue값 말고 처음 들어오는 젤 작은 값을 길에 넣어 최소 초를 길 배열(arr)에 넣어줌
					queue.add(x - 1);
					if(x-1 == K)
						find++;//동생이 있는 위치에 도달했을때 find값을 올려주기
				}
			}
			// x+1
			if (x + 1 <= 100000) {//범위 내에 들어오고
				if(arr[x+1]>=arr[x]+1) {// 값이 갱신될 때!! 
					arr[x+1] = arr[x]+1;
					queue.add(x+1);
					if(x+1 == K)
						find++;
				}
			}
			// 2*x
			if (x * 2 <= 100000) {//범위 내에 들어오고
				if(arr[x*2] >= arr[x]+1) {// 값이 갱신될 때!! 
					arr[x*2] = arr[x]+1;
					queue.add(x*2);
					if(x*2 == K)
						find++;
				}
				
			}

		}

	}
}