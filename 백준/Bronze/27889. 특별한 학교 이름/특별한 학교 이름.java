import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if(s.equals("NLCS")){
            System.out.println("North London Collegiate School");
        }else if(s.equals("BHA")){
            System.out.println("Branksome Hall Asia");
        }else if(s.equals("KIS")){
            System.out.println("Korea International School");
        }else if(s.equals("SJA")){
            System.out.println("St. Johnsbury Academy");
        }
    }
}