//백준 9290 틱택토 이기기
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(st.nextToken());
		String[][] arr = new String[3][3];
		int num = 1;

		for (int t = 0; t < tc; t++) {

			for (int i = 0; i < 3; i++) {
				String s = br.readLine();
				arr[i] = s.split("");
			}
			
			String ng = br.readLine();
			
			int[][] ngarr = new int[2][2];
			for (int i = 0; i < ngarr.length; i++) {
			    Arrays.fill(ngarr[i], -1); // 각 행을 -1로 채움
			}
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (arr[i][j].equals(ng)) {
						if(ngarr[0][0] == -1) {
							ngarr[0][0] = i;
							ngarr[0][1] = j;
						}else {
							ngarr[1][0] = i;
							ngarr[1][1] = j;
						}
					}
				}
			}
			
			//행이 일치하는 경우
			if(ngarr[0][0] == ngarr[1][0]) {
				for(int i=0; i<3; i++) {
					arr[ngarr[0][0]][i] = ng;
				}
				sb.append("Case").append(" ").append(num).append(":").append("\n");
				num++;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						sb.append(arr[i][j]);
					}
					sb.append("\n");
				}
				
			}
			//열이 일치하는 경우
			else if(ngarr[0][1] == ngarr[1][1]) {
				for(int i=0; i<3; i++) {
					arr[i][ngarr[0][1]] = ng;
				}
				sb.append("Case").append(" ").append(num).append(":").append("\n");
				num++;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						sb.append(arr[i][j]);
					}
					sb.append("\n");
				}
			}
			//오른쪽 대각선인 경우
			else if(ngarr[0][1] < ngarr[1][1]) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if(i==j) {
							arr[i][j] = ng;
						}
					}
				}
				
				sb.append("Case").append(" ").append(num).append(":").append("\n");
				num++;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						sb.append(arr[i][j]);
					}
					sb.append("\n");
				}
			}
			//왼쪽 대각선인 경우
			else if(ngarr[0][1] > ngarr[1][1]) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if(i+j == 2) {
							arr[i][j] = ng;
						}
					}
				}
				sb.append("Case").append(" ").append(num).append(":").append("\n");
				num++;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						sb.append(arr[i][j]);
					}
					sb.append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}