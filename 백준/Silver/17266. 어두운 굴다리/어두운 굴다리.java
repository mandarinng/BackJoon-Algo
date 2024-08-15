//백준 19266 어두운 굴다리
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //굴다리 길이
		int M = Integer.parseInt(br.readLine()); //가로등 개수
		int [] location = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			location[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 1; //최소 높이
		int right = N;//최대 높이
		int result = N;//정답
		
		//이분탐색으로 최적의 높이 찾기
		while(left <= right) {
			int mid = (left+right)/2;
			
			if(canCover(mid, location, N)) {
				result = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		System.out.println(result);
	}
	public static boolean canCover(int height, int [] location, int N) {
		
		int lastCover = 0;//마지막으로 커버한 위치
		
		for(int x : location) {
			if(x-height > lastCover) { //이 전 마지막 커버 위치까지 도달하지 못함
				return false; //높이 더 높여서 다시 시도해야함.
			}
			//이 전 마지막 커버 위치까지 도달ok
			lastCover = x + height; //마지막 커버 위치 업데이트
		}
		
		if(lastCover >= N) {//굴다리 끝지점 까지 커버 했으면 true
			return true;
		}else {
			return false; //끝 지점까지 커버하지 못했으면 높이 높여서 다시 시도
		}
	}

}