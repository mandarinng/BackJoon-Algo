//백준 10845 큐
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new LinkedList<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.countTokens() != 1) {
				String s = st.nextToken();
				deque.add(Integer.parseInt(st.nextToken()));
			} else {
				String method = st.nextToken();
//				System.out.println(method);
				if (method.equals("front")) {
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(deque.getFirst()).append("\n");
					}
				} else if (method.equals("back")) {
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(deque.getLast()).append("\n");
					}
				} else if (method.equals("size")) {
					sb.append(deque.size()).append("\n");
				} else if (method.equals("empty")) {
					if (deque.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
				} else if (method.equals("pop")) {
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(deque.pollFirst()).append("\n");
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}