import java.io.*;
import java.math.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
 
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = br.readLine().split(" ");
        final BigInteger n = new BigInteger(input[0]);
        final BigInteger m = new BigInteger(input[1]);
        System.out.print(n.multiply(m));
    }
}