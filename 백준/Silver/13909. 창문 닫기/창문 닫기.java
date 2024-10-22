//백준 13909 창문 닫기
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int i=1;
		while(i*i <=n) {
			i++;
		}
		System.out.println(i-1);
	}
}