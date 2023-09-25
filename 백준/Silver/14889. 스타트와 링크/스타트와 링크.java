import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] ability; // 각 선수들의 능력치를 저장할 배열
    static boolean[] selected; // 조합을 만들기 위한 선택 여부를 나타내는 배열
    static int minDifference = Integer.MAX_VALUE; // 능력치 차이의 최소값을 저장할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 선수의 수 입력
        ability = new int[N][N]; // 능력치 배열 초기화
        selected = new boolean[N]; // 선택 여부 배열 초기화

        // 각 선수의 능력치 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0); // 조합 생성 함수 호출
        System.out.println(minDifference); // 결과 출력
    }

    // 백트래킹을 이용한 조합 생성 함수
    static void combination(int start, int count) {
        if (count == N / 2) { // 조합이 완성된 경우
            calculateDifference(); // 두 팀의 능력치 차이 계산
            return;
        }

        for (int i = start; i < N; i++) {
            if (!selected[i]) { // 아직 선택되지 않은 선수인 경우
                selected[i] = true; // 선택 처리
                combination(i + 1, count + 1); // 다음 선수 선택
                selected[i] = false; // 선택 해제 (백트래킹)
            }
        }
    }

    // 두 팀의 능력치 차이 계산 함수
    static void calculateDifference() {
        int teamStart = 0; // 스타트 팀의 능력치 합계
        int teamLink = 0;  // 링크 팀의 능력치 합계

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (selected[i] && selected[j]) {
                    // 스타트 팀의 경우 선택된 선수들의 능력치 합산
                    teamStart += ability[i][j];
                } else if (!selected[i] && !selected[j]) {
                    // 링크 팀의 경우 선택되지 않은 선수들의 능력치 합산
                    teamLink += ability[i][j];
                }
            }
        }

        int difference = Math.abs(teamStart - teamLink); // 두 팀의 능력치 차이 계산
        minDifference = Math.min(minDifference, difference); // 최소값 업데이트
    }
}