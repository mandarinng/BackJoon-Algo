import java.util.*;
import java.io.*;

public class Main {
  
    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       StringBuilder sb = new StringBuilder();
       
       int n = Integer.parseInt(st.nextToken());
       int [] arr = new int[n];
       st = new StringTokenizer(br.readLine());
       for(int i=0; i<n; i++) {
    	   arr[i] = Integer.parseInt(st.nextToken());
       }
       Arrays.sort(arr);
       
       int m = Integer.parseInt(br.readLine());
       st = new StringTokenizer(br.readLine());
       for(int i=0; i<m; i++) {
    	   int flag = 0;
    	   int target = Integer.parseInt(st.nextToken());
    	   
    	   int sta = 0;
    	   int en = n-1;
    	   
    	   while(sta <= en) {
    		   int mid = (sta+en)/2;
    		   
    		   if(arr[mid] > target) {
    			   en = mid-1;
    		   }else if(arr[mid] < target) {
    			   sta = mid+1;
    		   }else {
    			   flag = 1;
    			   break;
    		   }
    	   }
    	   sb.append(flag == 1? 1 : 0).append("\n");   
       }
       System.out.println(sb.toString());
    }
}