
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [][] room = new int[2][7];//12개의 방. (학년은1부터 시작하니까 7개로 만듦)
		for(int i=0; i<N; i++) {
			StringTokenizer student = new StringTokenizer(sc.nextLine());
			int s = Integer.parseInt(student.nextToken());//성별
			int y = Integer.parseInt(student.nextToken());//학년
			room[s][y]++;
		}
		int cnt=0;
		for(int i=0; i<2; i++) {
			for(int j=0; j<7; j++) {
				if(room[i][j] != 0) {
					if(room[i][j]>K) {
						cnt += room[i][j]/K + room[i][j]%K;
					}else {
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);

	}

}
