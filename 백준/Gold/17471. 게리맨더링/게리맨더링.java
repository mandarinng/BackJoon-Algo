import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N, population[], result[], minChai = Integer.MAX_VALUE, groups[];
    static List<Integer> graph[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(input.readLine());
        population = new int[N + 1];
        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer tokens = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(tokens.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            tokens = new StringTokenizer(input.readLine());
            tokens.nextToken();
            while (tokens.hasMoreTokens()) {
                graph[i].add(Integer.parseInt(tokens.nextToken()));
            }
        }
        // 입력 완료

        result = new int[N + 1]; // 조합 결과를 담을 배열.
        for (int i = 1; i <= N / 2; i++) {
            grouping(1, 0, i);
        }
        if (minChai == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minChai);
        }
    }

    private static void grouping(int start, int cnt, int R) { // 1이면 1팀 0이면 0팀
        if (cnt == R) {
            checkLink(); // 연결되어 있는지 확인.
            return;
        }
        for (int i = start; i <= N; i++) {
            result[i] = 1;
            grouping(i + 1, cnt + 1, R);
            result[i] = 0;
        }
    }

    private static void checkLink() {
        groups = new int[2];
        boolean isConnected = true; // 연결상태가 정상인지 확인하는 변수

        // bfs를 2번 돌아 1팀과 0팀이 각각 연결된 상태인지 확인한다.
        for (int i = 1; i <= N; i++) {
            if (result[i] == 1) {
                if (!bfs(i, 1)) {
                    isConnected = false;
                }
                break;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (result[i] == 0) {
                if (!bfs(i, 0)) {
                    isConnected = false;
                }
                break;
            }
        }
        if (isConnected) {
            if (minChai > Math.abs(groups[0] - groups[1])) {
                minChai = Math.abs(groups[0] - groups[1]);
            }
        }
    }

    private static boolean bfs(int start, int party) {
        boolean isVisited[] = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start] = true;
        int sum = 0;
        while (!queue.isEmpty()) {
            Integer front = queue.poll();
            sum += population[front];
            List<Integer> childs = graph[front];
            for (int i = 0; i < childs.size(); i++) {
                Integer child = childs.get(i);
                if (!isVisited[child] && result[child] == party) { // 연결된 구역이 뽑은 구역인지 확인
                    isVisited[child] = true;
                    queue.offer(child);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (result[i] == party && !isVisited[i]) { // 연결 실패
                return false;
            }
        }
        groups[party] = sum;
        return true;
    }
}