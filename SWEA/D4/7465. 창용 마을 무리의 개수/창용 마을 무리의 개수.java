import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int [] person;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // TC
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 1~n명의 사람
			
			// Make-Set 
			person = new int[N+1]; //사람 번호는1~n이니까 +1크기로 생성
			for(int i=0; i<N+1; i++) {
				person[i] = i;
			}
			
			int M = Integer.parseInt(st.nextToken()); // M개의 관계 수
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // 사람1
				int y = Integer.parseInt(st.nextToken()); // 사람2
				//두 노드 같은 집합으로 합치기
				UnionSet(x,y);
			}
			//리스트에 넣어서 같은 그룹끼리 같은 숫자로 표기한 person배열에서 다른 숫자의 개수 셀것.
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i=1; i<N+1; i++) {
				int num = FindSet(i);
				if(!list.contains(num)) {
					list.add(num);
				}
			}

			System.out.println("#"+tc+" "+list.size());
			 
		}

	}
	//Find-Set : 루트 노드를 찾는 연산
	static int FindSet (int x) {
		//배열의 인덱스값과 값이 다르다면 부모 노드의 번호를 전달하면서, 루트 노드를 찾을떄까지 재귀 호출 반복!
		if(x != person[x]) {
			return person[x] = FindSet(person[x]);
			
		}
		return x;
	}
	//Union-Set :  두 노드를 같은 집합으로 합치는 union 연산
	static void UnionSet(int x, int y) {
		x = FindSet(x);
		y = FindSet(y);
		
		//두 루트 노드가 같다면 같은 무리에 속한 사람들임
		if(x == y) return;
		//더 작은 값이 부모 노드가 되도록 해줌
		else if(x<y) person[y] = x;
		else person[x] = y;
	}
	// 두 사람이 같은 무리 내에 속해있는지 판별하는 연산
	static boolean inUnion(int x, int y) {
		//FindSet 함수를 통해 루트 노드를 비교해서 찾기
		x = FindSet(x);
		y = FindSet(y);
		
		if(x==y) return true;
		else return false;
	}

}