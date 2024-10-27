import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = (int) (n*0.78);
		int b = (int) (n*0.8 + (n*0.2)*0.78);
		System.out.println(a);
		System.out.println(b);
	}
}