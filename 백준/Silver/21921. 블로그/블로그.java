//백준 21921 블로그
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//블로그 한 일수
		int X = Integer.parseInt(st.nextToken());//알고싶은 기간
		int [] count = new int [N]; 
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		 // 첫 번째 X일 동안의 방문자 수를 계산
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += count[i];
        }

        int maxSum = sum;
        int maxCount = 1;
		// 슬라이딩 윈도우를 이용하여 나머지 구간의 합을 계산
        for (int i = X; i < N; i++) {
            sum = sum - count[i - X] + count[i];
            if (sum > maxSum) {
                maxSum = sum;
                maxCount = 1;
            } else if (sum == maxSum) {
                maxCount++;
            }
        }

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(maxCount);
        }
		
	}

}