import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int [] arr;
  
    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       StringBuilder sb = new StringBuilder();
       
       n = Integer.parseInt(st.nextToken());
       arr = new int[n];
       st = new StringTokenizer(br.readLine());
       for(int i=0; i<n; i++) {
    	   arr[i] = Integer.parseInt(st.nextToken());
       }
       Arrays.sort(arr);
       
       int m = Integer.parseInt(br.readLine());
       st = new StringTokenizer(br.readLine());
       for(int i=0; i<m; i++) {
    	   int target = Integer.parseInt(st.nextToken());
    	   
    	   int low_idx = low(target);
    	   int upper_idx = upper(target);
    	   sb.append(upper_idx - low_idx).append(" ");
       }
       System.out.println(sb.toString());  
    }
    public static int low(int target) {
    	int start = 0;
    	int end = n;
    	int mid = 0;
    	while(start < end){
    		mid = (start+end)/2;
    		
    		if(target <= arr[mid]) {
    			end = mid;
    		}else {
    			start = mid+1;
    		}
    	}
    	
    	return start;
    }
    public static int upper(int target) {
    	int start = 0;
    	int end = n;
    	int mid = 0;
    	while(start < end) {
    		mid = (start+end)/2;
    		
    		if(target < arr[mid]) {
    			end = mid;
    		}else {
    			start = mid+1;
    		}
    	}
    	return start;
    }
}