import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int N;
    public static int cnt ;
    // 각 노드가 몇 번째로 탐색되는지 출력할 변수(cnt)를 넣을 배열. 
    // 노드는 1부터 N까지니까 N+1크기로 선언
    public static int [] visited;
    public static ArrayList<ArrayList<Integer>> graph;
    public static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();// 정점의 수
        int M = sc.nextInt();// 간선의 수
        int R = sc.nextInt();// 시작 정점
        cnt = 1;// 출력될 숫자 (방문 순서를 나타낼 것임)
        visited = new int[N+1];
        
        //서로 연결된 노드를 입력받아 간선을 나타낼 것 -> 크기:N+1 (노드의 개수지만, 인덱스1부터니까)근데, 이거 생각하기 귀찮아서 걍 리스트로 선언
//        ArrayList<Integer>[] graph = new ArrayList[N+1];//해도 됨
        //양방향 간선으로 입력받을 것
        //한 개의 노드에 여러개의 정점이 연결될 수 있으므로 (여러개의 간선 연결 가능)리스트안에 리스트로 선언 
        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }//근데 어차피 for문 돌려서 N+1 크기 만들어 줄거면 그냥 배열로 하는게 더 좋았을듯
        
        //간선 입력받기
        for(int i=0; i<M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();//서로 연결된 노드들. u,v를 이으면 간선이됨
            //리스트의 u인덱스에 v를 넣어서 간선을 표현하기
            //양방향 간선이니까 v인엑스에 u도 넣어주기
            graph.get(u).add(v);
            graph.get(v).add(u);
        
        }
        // 여러 개의 인접 노드가 있을 경우, 오름차순으로 방문하라고 했으므로 정렬 필수
        for(int i=1; i<graph.size(); i++) {//노드 0번은 없으니까 1부터
            Collections.sort(graph.get(i));
        }

        //dfs 함수 호출. 깊이 우선 탐색 시작!
        //시작 노드인 R부터 탐색 시작
        dfs(R);
        
//        for(int i=1; i<N+1; i++) {
//            System.out.println(visited[i]);
//        } //시간초과남 ㅠㅠ
        
          // 방문하지 않은 노드에 0을 추가
          // * 이 부분은 기본적으로 방분하지 않은 visited[i]에 0이 있으므로 추가해줄 필요는 없다.
//        for (int i = 1; i <= N; i++) {
//            if (visited[i] == 0) {
//                result.append("0");
//            }
//        }
        
        // * dfs 내부에서 스트링빌더에 cnt를 입력하면 순차대로 출력되고, 반복문에서 sysout을 쓰면 시간초과가 난다.(출력할 정점이 최대 10만개라서)
        // * 그렇다면 두 방법을 혼합하여 반복문 안에서 StringBuilder를 이용해보자.
        for(int i=1; i<N+1; i++) {
            result.append(visited[i]).append('\n');
        }
        
        System.out.println(result.toString());
        
    }
    public static void dfs(int node) {
        
        //우선 방문한 노드(visited)에 몇 번째로 방문했는지(cnt) 넣어주기
        visited[node] = cnt;
        
        // * 이렇게 하면 cnt가 무조건 순서대로 출력된다. 
        // * DFS에서 [노드의 순서]대로 출력해야 하는데 dfs 들어갈때마다 cnt가 증가하면서 StringBuilder에 바로 들어가기 때문에. 
//        result.append(cnt).append("\n");
        
        //for-each문을 사용해서 정렬되어 간선을 표현한 graph리스트의 인덱스(u)에 따라 연결된 노드(v)방문
        //visited 배열은 int배열이므로 초기값이 0인데, visited[x]==0이란 것은 아직 그 노드를 방문하지 않았다는 것.
        //->방문하지 않은 노드로 이동하기!
        for(int x : graph.get(node)) {    
            if(visited[x]==0) {
                cnt++; 
                dfs(x);
            }
        }
        return;
    }
}