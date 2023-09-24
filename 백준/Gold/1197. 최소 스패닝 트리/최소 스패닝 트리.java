import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

   static int[] p; // 대표를 저장할 배열

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int V = sc.nextInt(); // 정점의 개수
      int E = sc.nextInt(); // 간선의 수
      int[][] edges = new int[E][3];

      for (int i = 0; i < E; i++) {
         edges[i][0] = sc.nextInt(); 
         edges[i][1] = sc.nextInt();
         edges[i][2] = sc.nextInt(); //0과 1을 연결하려했을때 가중치
      } // 입력끝

      // 크루스칼 1단계 : 간선을 정렬 가중치 기준으로 정렬한다(오름차순)
      Arrays.sort(edges, new Comparator<int[]>() {
         @Override
         public int compare(int[] o1, int[] o2) {
            return o1[2] - o2[2];
         }
      });

      //대표값 저장할 배열을 만들어줌 시작점이 1이기때문에 배열사이즈 +1
      p = new int[V+1];
      // 2-1. make-set 하자
      for (int i = 0; i < V+1; i++) {
         p[i] = i;
      }

      // 2-2. 검사하면서 뽑아
      int ans = 0; // 최소비용을 저장할 친구.
      int pick = 0; // 뽑은 간선의 수를 저장할 친구
      for (int i = 0; i < E; i++) {
         // i번째 간선 이용하여 두개의 정점을 가지고 처리하겠다.
         
         int px = findset(edges[i][0]);   //연결할 x의 대표값과
         int py = findset(edges[i][1]);   // 연결할 y의 대표값을뽑아봐
         if (px != py) {   // 대표값이 달라? 그럼 연결해야지
            union(px, py);   // 연결했다
            ans += edges[i][2];   //연결하면 그 가중치를 더해줘야지
            pick++;   // 연결했으니깐 연결한 수를 하나 더해줘
         }

         if (pick == V - 1)   // 만약 너가 정점 3개를 연결할거야 그러면 2번만 연결하면되니깐 V-1이야
            break;
      }
      System.out.println(ans);

   }
   
   //내가 여기서 유니온을 파인드셋 안한이유가 유니온 하기전에 대표값을 뽑고 대표값끼리 유니온하니깐 이렇게 적은거!!!
   static void union(int x, int y) {
      p[y] = x; 
   }

   static int findset(int x) {
      if (x != p[x])
         p[x] = findset(p[x]);
      return p[x];

   }

}