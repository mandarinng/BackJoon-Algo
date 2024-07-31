import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] kda = br.readLine().split("/");
		int [] arr = new int[3];
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(kda[i]);
		}
		
		if(arr[0]+arr[2] < arr[1] || arr[1]==0) System.out.println("hasu");
		else System.out.println("gosu");
	}

}