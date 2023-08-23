
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			//원본 암호문의 길이
			int N = sc.nextInt();
			//원본 암호문 넣을 리스트
			LinkedList<String> pwlist = new LinkedList<>();
			//원본 암호문 입력받기
			//리스트에 넣기
			for(int i=0; i<N; i++) {
				pwlist.add(sc.next());
			}
			//I의 개수
			int Icnt = sc.nextInt();
			//I의 개수 만큼 돌기
			for(int i=0; i<Icnt; i++) {
				//처음으로 입력 받는게 I인지 확인
				String s = sc.next();
				if(s.equals("I")) {
					//I가 입력된게 맞으면 x랑 y를 입력받기
					int x = sc.nextInt();
					int y = sc.nextInt();
					//pwlist의 [x]에  y개만큼의 숫자를 넣기
					for(int j=0; j<y; j++) {
						pwlist.add(x,sc.next());
						x++; //계속 x번째 인덱스에 넣는게 아니고 이어서 넣어야 하므로 x+1해주기
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			
			for(int i=0; i<10; i++) {//맨 앞에 10개만 출력
				System.out.print(pwlist.get(i)+" ");
			}
			System.out.println();
			
		}

	}

}
