import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int T, Y = 0, M = 0;
        for (int i = 0; i < N; i++)
        {
            T = Integer.parseInt(s[i]);
            Y += (T / 30 + 1) * 10;
            M += (T / 60 + 1) * 15;
        }

        if (Y == M)
            System.out.println("Y M " + Y);
        else if (Y > M)
            System.out.println("M " + M);
        else
            System.out.println("Y " + Y);
    }
}