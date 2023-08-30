import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String alpha = br.readLine();
		for(char c='a'; c<='z'; c++) {
			sb.append(alpha.indexOf(c)+" ");
			//indexOf(char c) 메소드는 문자열에서 문자 c의 인덱스번호를 반환하도록 한다.
			//그런데 문자열에서 찾는 알파벳이 없다면 -1을 반환하도록 해준다. 
		}
		System.out.println(sb);
		
	}

}