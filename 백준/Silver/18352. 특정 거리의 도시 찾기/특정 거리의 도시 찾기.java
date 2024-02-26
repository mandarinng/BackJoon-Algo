import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
//백준 18352 : 다익스트라로 풀기
public class Main {

    static int N,M,K,X;
    static ArrayList<Integer>[] graph;
    static int [] dist;

    public static class Node implements Comparable<Node>{
        int num;//도시번호
        int cost;//가중치

        public Node(int num, int cost) {
            super();
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//도시의 개수
        M = Integer.parseInt(st.nextToken());//도로의 개수

        K = Integer.parseInt(st.nextToken());//거리 정보
        X = Integer.parseInt(st.nextToken());//출발 도시의 번호

        graph = new ArrayList[N+1];//도시 연결
        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
//            System.out.println("111111111111111");
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);

        }
//        System.out.println("22222222");
        dist = new int[N+1];//최단거리 저장할 배열
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(X);
//        System.out.println("33333333333");
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            if(dist[i] == K){
                sb.append(i).append("\n");
            }
        }
        if(sb.length() == 0){
            sb.append(-1);
        }
        System.out.println(sb);

    }
    public static void dijkstra(int startCity){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        dist[startCity] = 0;
        pq.add(new Node(startCity, 0));

        while(!pq.isEmpty()){
            Node n = pq.poll();

            for(int x : graph[n.num]){
                if(dist[x] > n.cost+1){
                    dist[x] = n.cost+1;
                    pq.add(new Node(x,n.cost+1));
                }
            }
        }


    }

}