//백준 1935 후위 표기식2
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		Map<Character, Double> map = new HashMap<>();
//		double [] nums = new double[n];
		for (int i = 0; i < n; i++) {
			double d = Double.parseDouble(br.readLine());
			char alpha = (char) ('A' + i);
			map.put(alpha, d);
		}
		Stack<Double> stack = new Stack<>();
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != '+' && c != '-' && c != '*' && c != '/') {
				stack.push(map.get(c));
				idx++;
			} else {
				double b = stack.pop();
				double a = stack.pop();
				if (c == '+') {
					stack.push(a + b);
				} else if (c == '-') {
					stack.push(a - b);
				} else if (c == '*') {
					stack.push(a * b);
				} else {
					stack.push(a / b);
				}
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}