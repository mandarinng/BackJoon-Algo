import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 개수 입력

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 숫자의 개수 N 입력
            int K = Integer.parseInt(st.nextToken()); // 크기 순서 K 입력
            String[] arr = br.readLine().split(""); // 16진수 숫자들을 문자열로 입력

            // TreeSet을 사용하여 내림차순으로 정렬할 준비
            TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());

            // 1. 숫자 배열을 회전시키며 가능한 모든 숫자를 생성하여 TreeSet에 저장
            for (int i = 0; i < N / 4; i++) {
                String tmp = arr[N - 1]; // 배열의 마지막 숫자 저장
                for (int j = N - 1; j > 0; j--) {
                    arr[j] = arr[j - 1]; // 배열을 한 칸씩 오른쪽으로 이동
                }
                arr[0] = tmp; // 회전을 수행

                // 각 회전 별로 가능한 숫자 조합을 만들어 TreeSet에 추가
                for (int j = 0; j < arr.length; j += N / 4) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = j; k < j + (N / 4); k++) {
                        sb.append(arr[k]); // 숫자 조합을 만듦
                    }
                    set.add(sb.toString()); // TreeSet에 숫자 조합 추가
                }
            }

            // 2. TreeSet을 배열로 변환하고 K번째로 큰 수를 출력
            String[] answer = set.toArray(new String[set.size()]);
            //answer[K - 1]은 TreeSet에 저장된 16진수 형태의 문자열 중에서 K번째로 큰 값을 가져옵니다. 그런 다음 Long.parseLong 함수를 사용하여 이 16진수 문자열을 10진수로 변환합니다.    
            //예를 들어, answer[K - 1]이 "1F7"인 경우, 이는 16진수로 해석하면 503이 됩니다. 이런 식으로 16진수 문자열을 10진수로 변환하여 결과를 출력합니다.
            System.out.println("#" + tc + " " + Long.parseLong(answer[K - 1], 16));
        }
    }
}