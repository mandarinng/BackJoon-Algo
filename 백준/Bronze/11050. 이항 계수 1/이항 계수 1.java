import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();        // 자연수 N
        int k = scan.nextInt();        // 정수 K

        int result = factorial(n) / (factorial(n - k) * factorial(k));    // 이항 계수 (NK)
        System.out.println(result);
    }

    // 팩토리얼
    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        else
            return factorial(n - 1) * n;
    }
}