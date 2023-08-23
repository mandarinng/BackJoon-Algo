import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            
            String ds = "";
            StringBuilder sb1 = new StringBuilder(sc.next());
            StringBuilder sb2 = new StringBuilder(sc.next());
           
            for(int i=0; i<sb1.length(); i++) {
                if(sb1.charAt(i) == 'B') {
                    sb1.setCharAt(i, '2');
                }
                else if(sb1.charAt(i) == 'A'|| sb1.charAt(i) == 'D'||sb1.charAt(i) == 'O'||sb1.charAt(i) == 'P'||sb1.charAt(i) == 'Q'||sb1.charAt(i) == 'R') {
                    sb1.setCharAt(i, '1');
                }else {
                    sb1.setCharAt(i, '0');
                }
            }
   
            for(int i=0; i<sb2.length(); i++) {
                if(sb2.charAt(i) == 'B') {
                    sb2.setCharAt(i, '2');
                }
                else if(sb2.charAt(i) == 'A'|| sb2.charAt(i) == 'D'||sb2.charAt(i) == 'O'||sb2.charAt(i) == 'P'||sb2.charAt(i) == 'Q'||sb2.charAt(i) == 'R') {
                    sb2.setCharAt(i, '1');
                }else {
                    sb2.setCharAt(i, '0');
                }
            }
            
          
//            if (sb1.length() != sb2.length()) {
//                ds = "DIFF";
//            } else {
//                for(int i=0; i<sb1.length(); i++) {
//                    if(sb1.charAt(i) == sb2.charAt(i)) {
//                        ds = "SAME";
//                    }else {
//                        ds = "DIFF";
//                    }
//                }
            if(sb1.toString().equals(sb2.toString()))
            	ds="SAME";
            else ds="DIFF";
            

            System.out.println("#" + tc + " "+ds);
        }

    }

}