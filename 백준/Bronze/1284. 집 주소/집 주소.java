import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String cnt = br.readLine();
			int num = Integer.parseInt(cnt);
			if (num == 0)
				break;

			int answer = 2 + cnt.length()-1;// 양 옆 여백 + 사이 간격으로 시작

			String[] a = cnt.split("");
			for (int j = 0; j < a.length; j++) {
				if (Integer.parseInt(a[j]) == 1)
					answer += 2;
				else if (Integer.parseInt(a[j]) == 0)
					answer += 4;
				else
					answer += 3;
			}
			System.out.println(answer);
		}

	}

}