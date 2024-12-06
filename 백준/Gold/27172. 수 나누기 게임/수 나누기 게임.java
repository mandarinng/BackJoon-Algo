//백준 27172 수 나누기 게임
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 플레이어 수
		int [] players = new int[n];
		int max = 0; // 카드 최대값
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			players[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, players[i]);
		}
		// 각 카드의 빈도수 체크
		int [] count = new int[max+1];
		for(int num : players) {
			count[num]++;
		}
		// 최종 출력할 점수 배열
		int [] score = new int [max+1];
		// 1부터 max까지 카드를 보면서, 등장한 카드 찾기
		// 등장한 카드의 배수들 찾기
		// 등장한 카드(현재 수)는 배수의 수 만큼 ++
		// 배수카드는 등장한 카드(현재 수) 수 만큼 --
		for(int i=1; i<=max; i++) { 
			if(count[i] > 0) { // i가 현재 카드 숫자
				for(int j=i*2; j<=max; j+=i) { // j는 i의 배수
					if(count[j] > 0) {
						score[i] += count[j];
						score[j] -= count[i];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int num : players) {
			sb.append(score[num]).append(" ");
		}
		System.out.println(sb.toString());
	}
}