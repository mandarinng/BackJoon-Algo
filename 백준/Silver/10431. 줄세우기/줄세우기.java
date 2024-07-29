//백준 10431 줄 세우기
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int [] arr = new int[20]; // 새로운 반 시작
			int num = 0;
			st = new StringTokenizer(br.readLine());
			
			sb.append(Integer.parseInt(st.nextToken())).append(" ");//TC 값은 출력에 넣기 
			
			arr[0] = Integer.parseInt(st.nextToken());//가장 첫 번째 학생은 일단 세우기
			
			for(int j=1; j<20; j++) {
				int x = Integer.parseInt(st.nextToken());
				arr[j] = x;// 새로운 학생을 하나씩 넣음

				for(int k=j-1; k>=0; k--) {//뒷 번호에서부터 키 비교
					if(arr[k] > x) { //새로 들어온 아이보다 큰 애들이 앞에 있을 때
						arr[k+1] = arr[k];//자리 바꾸기
						arr[k] = x;
						num++;
					}
				}
			}
			
			sb.append(num).append("\n");
		}
		System.out.println(sb.toString());
	}

}