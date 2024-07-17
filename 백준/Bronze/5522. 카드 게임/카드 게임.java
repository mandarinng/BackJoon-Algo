//백준 5522 카드게임
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=0;
		for(int i=0; i<5; i++) {
			num += Integer.parseInt(br.readLine());
		}
		System.out.println(num);
		
	}

}