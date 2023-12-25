import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		System.out.println(Fact(1, N));
	}
	public static BigInteger Fact(int one, int N) {
		
		BigInteger num = BigInteger.valueOf(one);
		
		if(one<N) {
			int a = (one+N)/2;
			num = Fact(one,a).multiply(Fact(a+1, N));
		}
		
		return num;
		
	}

}