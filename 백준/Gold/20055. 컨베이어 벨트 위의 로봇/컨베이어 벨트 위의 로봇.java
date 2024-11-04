//백준 20055 컨베이어 벨트 위의 로봇
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
//		Deque<Integer> deque = new LinkedList<>();
		int [] belt = new int[2*n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2*n; i++) {
//			deque.add(Integer.parseInt(st.nextToken()));
			belt[i] = Integer.parseInt(st.nextToken());
		}
		boolean [] robot = new boolean[n]; //1~n 위치의 벨트에만 로봇이 존재할 수 있음(로봇이 존재하는 곳  true)
		int level = 0;//정답이 될 단계
		int cnt = 0; //벡트에서 내구도가 0인 칸의 개수
		
		while(cnt < k) {
			level++;
			
			//컨베이어 벨트 한 칸씩 이동
			int tmp = belt[2*n-1];
			for(int i=2*n-1; i>0; i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = tmp;
			//컨베이어 벨트와 함께 로봇 회전
			for(int i=n-1; i>0; i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = false;
			//n번째 벨트에 로봇이 있으면 내리기
			if(robot[n-1]) robot[n-1] = false;
			//로봇들만 한 칸씩 이동
			for(int i=n-2; i>=0; i--) {
				//로봇이 있고, 내구성이 0보다 큰 경우
				if(robot[i] && belt[i+1]>0 && !robot[i+1]) {
					robot[i] = false;
					robot[i+1] = true;
					belt[i+1]--;
					if(belt[i+1] == 0) cnt++;
				}
			}
			//n번째 벨트에 로봇이 있으면 내리기
			if(robot[n-1]) robot[n-1] = false;
			//올리는 위치에 로봇 올려놓기
			if(belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
				if(belt[0] == 0) cnt++;
			}
		}
		System.out.println(level);
	}
}