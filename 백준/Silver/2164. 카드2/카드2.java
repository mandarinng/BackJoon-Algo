
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}
		for (int i = 0; i < N - 1; i++) {
			queue.poll();
			queue.add(queue.poll());
		}
		for(int x: queue) {
			System.out.println(x);
		}
	}

}
