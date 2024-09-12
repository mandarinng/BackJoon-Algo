//백준 5430 AC
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); 
        for (int tc = 0; tc < T; tc++) {
            String method = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            // 입력된 문자열을 쉼표로 분리하여 Deque에 저장
            Deque<Integer> deque = new ArrayDeque<>();
            String[] elements = input.substring(1, input.length() - 1).split(",");
            for (String element : elements) {
                if (!element.isEmpty()) {
                    deque.add(Integer.parseInt(element));
                }
            }

            boolean isReversed = false; // 뒤집힌 상태인지 표시
            boolean isError = false; // 에러가 발생했는지 표시

            for (char c : method.toCharArray()) {
                if (c == 'R') {
                    isReversed = !isReversed; // 뒤집기는 플래그만 변경
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        isError = true; // 빈 배열에서 삭제 시도 시 에러
                        break;
                    }
                    if (isReversed) {
                        deque.removeLast(); // 뒤집힌 상태에서는 끝 요소 제거
                    } else {
                        deque.removeFirst(); // 아니면 처음 요소 제거
                    }
                }
            }

            if (isError) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}