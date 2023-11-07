import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] operator;
	static int[] numbers;
	static int[] selectOper;
	static int min;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N개의 숫자(숫자가 적힌 게임판에 +-*/ 연산자 넣어서 최대,최소 값 찾기)

			operator = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken()); // [0]~[3] 순서대로 + - * / 연산자의 개수
			}

			numbers = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken()); // 연산에 사용할 N개의 숫자
			}

			selectOper = new int[N - 1]; // N-1개의 연산자를 골라야 N개의 숫자 연산 가능
			
			//min이랑 max값 매 tc마다 초기화 해주기
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			backTracking(0);//N-1개의 연산자를 골라서 seletOper에 넣고, 연산하기( calculator() )
			
			//최댓값과 최솟값의 차이 출력
			System.out.println("#" + tc + " " + (max-min));
		}

	}
	//N-1개의 연산자를 고르는 백트래킹
	public static void backTracking(int idx) {
		if (idx == N - 1) { //N-1개 다 골랐으면 계산하기
			calculate();
			return;
		}
		//
		for (int i = 0; i < 4; i++) {
			//operator의 i번째 연산자를 이미 다 골라서 안 남았으면(0이면) operator의 다음 인덱스의 연산자 고르기
			if (operator[i] == 0)
				continue;
			
			operator[i]--;//해당 연산자 고르기:[0]~[3] 순서대로 + - * / 연산자를 의마함
			selectOper[idx] = i;//고른 순서대로 연산자 기록해두기
			backTracking(idx + 1);//다음 연산자 고르기(N-1개를 고를때까지!)
			operator[i]++;//다음 조합 위해 되돌리기
		}
	}
	//고정된 순서의 숫자들(number[])을 골라진 연산자의 순서대로 연산하기
	public static void calculate() {
		int result = numbers[0];// 해당 조합의 연산 결과.일단 제일 첫 번째 숫자로 시작
		for (int i = 0; i < N - 1; i++) {
			if(selectOper[i] == 0) {//+일때
				result += numbers[i+1];
			}
			else if(selectOper[i] == 1) {//-일때
				result -= numbers[i+1];
			}
			else if(selectOper[i] == 2) {//*일때
				result *= numbers[i+1];
			}
			else {//  /일때
				result /= numbers[i+1];
			}
		}
		
		if(result > max)//연산 결과가 max값보다 크면 max값 갱신
			max = result;
		
		if(result < min)//연산 결과가 min값보다 작으면 min값 갱신
			min = result;
	}

}
