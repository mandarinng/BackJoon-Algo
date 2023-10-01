import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] city;// 입력받을 도시 정보
	static boolean[] visited;// 치킨집을 조합으로 고를 때 이용할 boolean 배열.이 배열로 치킨집이 chickens 리스트에서 몇 번째 치킨집인지를 나타내는 인덱스로 알 수 있다.
	static ArrayList<Point> chickens;// 입력받을 때 치킨집(2)의 좌표를 넣을 리스트(좌표를 저장해야 하니까 point형)
	static ArrayList<Point> homes;// 입력받을 때 집(1)의 좌표를 넣을 리스트
	static int result = Integer.MAX_VALUE;//츌력할 최단거리 합

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// NXN크기의 도시
		M = Integer.parseInt(st.nextToken());// M개의 치킨집 고를 것
		chickens = new ArrayList<>();
		homes = new ArrayList<>();

		city = new int[N][N];
		
		//입력받으면서 치킨집 좌표와 집 좌표를 chickens리스트와 homes리스트에 넣기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1) {
					homes.add(new Point(i, j));
				} else if (city[i][j] == 2) {
					chickens.add(new Point(i, j));
				}
			}
		}
		//visited 선언 위치는 여기! chickens 크기가 다 정해지고 난 뒤에 선언해야 하므로.
		visited = new boolean[chickens.size()];// 입력받은 여러개의 치킨집들(2)중 M개의 치킨집을 뽑을때 사용함.

		combination(0, 0);//한 개는 선택된 치킨집의 수, 한 개는 조합할때 사용할 start 파라미터
		System.out.println(result);

	}

	// 조합을 사용해 M개의 치킨집 뽑기
	public static void combination(int chicken, int start) {
		//M개의 치킨집을 뽑았으면 
		if (chicken == M) {
			// calculate함수를 활용해 선택된 치킨집에서 각각의 집까지의 최단거리를 구하고, result에는 최소값만 남기기
			result = Math.min(result, calculate());
			return;
		}
		//조합을 활용한 M개의 치킨집 선택
		for (int i = start; i < chickens.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(chicken + 1, i + 1);
				visited[i] = false;
			}
		}
	}
	// homes리스트에서 꺼낸 하나의 집(home)을 기준으로 뽑힌 M개의 치킨집들까지의 거리를 구하고, 가장 가까운 치킨집과의 거리를 minDistance변수에 넣기
	public static int calculate() {

		int sum = 0;
		//하나의 집을 기준으로 M개의 치킨집들 중  최단 거리 구하기 
		for (Point home : homes) {
			int minDistance = Integer.MAX_VALUE; // 각 집에서 치킨집들까지의 거리 중 최단 거리
			for (Point chicken : chickens) {
				//위의 combination함수에서 뽑힌 M개의 치킨집 중 하나인지 검사하는 if문. 뽑힌 치킨집은 visited에서 true로 바꿔줬었음.
				if (visited[chickens.indexOf(chicken)]) {
					int distance = Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
					minDistance = Math.min(distance, minDistance);//집마다  M개의 치킨집까지의 거리 계산해서 가장 작은 값 minDistance에 넣음
				}

			}
			sum += minDistance;//각 집마다 M개의 치킨집들 중 최단거리에 있는 치킨집과의 거리를 sum에 넣어서 더해주기
		}
		return sum;//집들과 뽑혔던 치킨집들 사이의 모든 최단거리 합을 리턴. (답의 후보임)

	}

}