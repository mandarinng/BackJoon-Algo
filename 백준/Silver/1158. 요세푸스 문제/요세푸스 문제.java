
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}
		System.out.print("<");
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < num - 1; j++) {
				queue.add(queue.poll());

			}
			System.out.print(queue.poll() + ", ");

		}
		System.out.println(queue.poll()+">");
	}

}
