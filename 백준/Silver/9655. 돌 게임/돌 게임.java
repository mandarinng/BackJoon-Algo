//백준 9655 돌 게임
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String answer = (N%2 == 1 ? "SK":"CY");
		System.out.println(answer);
			
	}

}