//백준 7682 틱택토
import java.io.*;
import java.util.*;

public class Main {
	static char [][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if(s.equals("end"))break;
			
			map = new char[3][3];
			int dotCnt = 0;
			int xCnt = 0;
			int oCnt = 0;
			
			int k=0;
			for(int i=0; i<s.length(); i++) {
				 switch(i%3) {
				 case 0:
					 map[k][i%3] = s.charAt(i);
					 if(map[k][i%3] == 'O') {
						 oCnt++;
					 }else if(map[k][i%3] == 'X') {
						 xCnt++;
					 }else {
						 dotCnt++;
					 }
					 break;
				 case 1:
					 map[k][i%3] = s.charAt(i);
					 if(map[k][i%3] == 'O') {
						 oCnt++;
					 }else if(map[k][i%3] == 'X') {
						 xCnt++;
					 }else {
						 dotCnt++;
					 }
					 break;
				 case 2:
					 map[k][i%3] = s.charAt(i);
					 if(map[k][i%3] == 'O') {
						 oCnt++;
					 }else if(map[k][i%3] == 'X') {
						 xCnt++;
					 }else {
						 dotCnt++;
					 }
					 k++;
					 break;
				 }
			}
			//x개수 - o개수 == 1 || 0 아니면 invalid
			if(!(xCnt - oCnt == 1 || xCnt - oCnt == 0)) {
				sb.append("invalid").append("\n");
				continue;
			}
			//dotCnt > 0 인 경우에는 최종 상태여야 함
			if(dotCnt > 0) {
				//dotCnt가 짝수인 경우 X의 승리여야 함
				if(dotCnt % 2 == 0) {
					String c = check();
					if(!c.equals("XO")) {
						sb.append("invalid").append("\n");
						continue;
					}
				}
				//dotCnt가 홀수인 경우 O의 승리여야 함
				else {
					String c = check();
					if(!c.equals("OX")) {
						sb.append("invalid").append("\n");
						continue;
					}
				}
			}
			//dotCnt == 0 : 꽉 채워진 경우 : 승부 안났거나 X의 승리여야 함
			else {
				String c = check();
				if(!(c.equals("XX") || c.equals("XO"))) {
					sb.append("invalid").append("\n");
					continue;
				}
			}
			sb.append("valid").append("\n");	
		}
		System.out.println(sb.toString());
	}
	//빙고 검사하기 : 빙고된 문자 return
	public static String check() {
		StringBuilder ss = new StringBuilder();
		boolean x = false;
		boolean o = false;
		for(int i=0; i<3; i++) {
			//행 같은지 검사
			if(map[i][0] == map[i][1] && map[i][0] == map[i][2]) {
//				ss.append(map[i][0]);
//				return map[i][0]; 
				if(map[i][0] == 'O') o = true;
				if(map[i][0] == 'X') x = true;
				
			}
			//열 같은지 검사
			if(map[0][i] == map[1][i] && map[0][i] == map[2][i]) {
//				ss.append(map[0][i]);
//				return map[0][i];
				if(map[0][i] == 'O') o = true;
				if(map[0][i] == 'X') x = true;
			}
		}
		//대각선 같은지 검사
		if((map[0][0] == map[1][1] && map[0][0] == map[2][2]) || (map[0][2] == map[1][1] && map[1][1] == map[2][0])) {
//			return map[1][1];
//			ss.append( map[1][1]);
			if(map[1][1] == 'O') o = true;
			if(map[1][1] == 'X') x = true;
		}
		if(o && x) {
			ss.append("OX");
		}else if(o && !x) {
			ss.append("OX");
		}else if(!o && x) {
			ss.append("XO");
		}else {
			ss.append("XX");
		}
		
//		String s = ss.toString();
//		System.out.println(s);
		return ss.toString();
	}
}