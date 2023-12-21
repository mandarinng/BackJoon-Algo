import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		//높이가 1~H인 종유석과 석순의 개수 나타내는 배열
		int [] up = new int[H+1];//석순
		int [] down = new int[H+1];//종유석
		
		//석순부터 종유석과 번갈아가며 높이 정보 입력
		for(int i=0; i<N/2; i++) {
			up[Integer.parseInt(br.readLine())]++;
			down[Integer.parseInt(br.readLine())]++;
		}
		
		//H-1부터(석순과 종유석의 최대 길이는 H-1) 1까지 각 높이 이상의 종유석이나 석순의 개수 누적 합 
		for(int i=H-1; i>=1; i--) {
			up[i] += up[i+1];
			down[i] += down[i+1];
		}
		
		//동굴에서 각 높이 별 종유석+석순 의 개수 합
		int [] total = new int[H+1];
		for(int i=1; i<=H; i++) {
			total[i] = up[i] + down[H-i+1];//석순은 높이 그대로, 종유석은 반대로
		}
		
		//피해야하는 장애물 최소 값과 구간의 수 구하기 위해 정렬
		Arrays.sort(total);
		int min = total[1]; //높이는 1부터고, 정렬했으니까 total[1]이 피해야하는 장애물의 최소값
		int cnt=0; //장애물 최소 개수 구간의 수
		for(int i=1; i<H+1; i++) {
			if(total[i] == total[1]) cnt++;
		}
		
		System.out.println(min+" "+cnt);
		
		
	}

}