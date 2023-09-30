import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

   static int[] p; // 대표를 저장할 배열

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      int M = sc.nextInt();

      p = new int[N + 1];
      for (int i = 0; i < N + 1; i++) {
         p[i] = i;
      }

      for (int i = 1; i <= N; i++) {
         for (int j = 1; j <= N; j++) {
            int a = sc.nextInt();
            if (i != j && a == 1) {
               int nx = findset(i);
               int ny = findset(j);
               if (nx != ny) {
                  union(nx, ny);
               }
            }
         }
      }
      
      
      // 이게 핵심임!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      //대표값을 한번 싹다 다시 찾아줘야함 왜냐하면 연결되어있더라도 대표값은 다를수있음!!!!!!
      // 1-3-5 연결되어있는데 3의 대표값은 1 5의 대표값은 3이기 떄문에 대표값을 다시 찾아준다면 3과5의 대표값이 1로 갱신이된다!!!!
      for (int i = 1; i <= N; i++) {
         p[i] = findset(p[i]);
      }
      //해쉬셋에 대표값을 다 넣었는데 사이즈가 1이다? 그럼 모든 배열의 대표값이 하나로 통일되었단 뜻이므로 YES!!!
      HashSet<Integer> hash = new HashSet<>();
      for (int i = 1; i <= M; i++) {
         hash.add(p[sc.nextInt()]);
      }

      if (hash.size() == 1) {
         System.out.println("YES");
      } else
         System.out.println("NO");

   }

   static void union(int x, int y) {
         p[y] = x;
   }

   static int findset(int x) {
      if (x != p[x])
         p[x] = findset(p[x]);
      return p[x];

   }

}