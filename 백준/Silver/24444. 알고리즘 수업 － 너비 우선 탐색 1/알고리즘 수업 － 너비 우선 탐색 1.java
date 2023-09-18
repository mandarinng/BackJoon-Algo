import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] result;
    static int cnt=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }
        bfs(R);

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void bfs(int node) {
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        result[node] = cnt++;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int neighbor : graph[currNode]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    result[neighbor] = cnt++;
                }
            }
        }
    }
}