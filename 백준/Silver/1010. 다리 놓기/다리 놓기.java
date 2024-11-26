// 백준 1010 다리 놓기
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 다리를 놓을 사이트의 개수 (왼쪽)
            int m = Integer.parseInt(st.nextToken()); // 다리를 놓을 사이트의 개수 (오른쪽)

            // nCr 계산 (mCn)
            long result = 1;
            for (int j = 0; j < n; j++) {
                result *= (m - j);  // 분자
                result /= (j + 1);  // 분모
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}