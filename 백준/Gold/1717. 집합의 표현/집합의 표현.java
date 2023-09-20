import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // n개의 집합
		int m = Integer.parseInt(st.nextToken()); // m개의 연산

		// Make-Set
		p = new int[n + 1]; // 1부터 n까지의 집합
		for (int i = 0; i < n + 1; i++) {
			p[i] = i;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			// 0이 입력됐을때 두 원소(x,y)를 포함한 두 개의 집합을 합치기 -> unionset 함수 사용
			if (Integer.parseInt(st.nextToken()) == 0) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				unionset(x, y);

			}

			// 1일떄두 원소(x,y)를 포함한 두 개의 집합이 같은 집합인지 확인하기 -> inunion 함수 사용
			else {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				sb.append(inUnion(x, y)).append("\n");
			}
		} // for

		System.out.println(sb);
	}

	// findset : 루트 노드를 찾는 find연산.
	static int findset(int x) {
		// 배열의 인덱스값과 값이 다르다면 부모 노드의 번호를 전달하면서, 루트 노드를 찾을떄까지 재귀 호출 반복!
		if (x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];// 배열의 인덱스값과 값이 같다면 이것이 루트 노드!
	}

	// unionset : 두 노드를 같은 집합으로 합치는 union 연산
	static void unionset(int x, int y) {
		// findset 함수를 통해 루트 노드를 찾고
		x = findset(x);
		y = findset(y);

		// 두 루트 노드가 같다면 이미 연결되어 있던 것
		if (x == y)
			return;
		// 더 작은 값이 부모 노드가 될 수 있도록 해주기(내맘)
		else if (x < y)
			p[y] = x;
		else
			p[x] = y;
	}

	// 두 노드가 연결되어 있는지 판별하는 함수. -> 두 루트 노드가 동일하다면 한 집합에 있다는 뜻!
	static String inUnion(int x, int y) {
		// findset 함수를 통해 루트 노드를 찾기
		x = findset(x);
		y = findset(y);

		if (x == y)
			return "YES"; // 같은 집합 내에 있으면 1, 아니면 0반환
		else
			return "NO";
	}

}