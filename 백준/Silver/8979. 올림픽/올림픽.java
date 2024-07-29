//백준 8979 올림픽
import java.util.*;
import java.io.*;

public class Main {
	
	static class Country {
		int id;
		int gold;
		int silver;
		int bronze;
		
		public Country(int id, int gold, int silver, int bronze) {
			this.id = id;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		
	}
	//첫 인자 > 두 번째 인자 : 오름차순
	//첫 인자 < 두 번째 인자 : 내림차순
	//람다 표현식으로 Comparator 인터페이스 구현
	static Comparator<Country> medalComparator = (c1, c2) -> { 
		if(c1.gold != c2.gold) {
			return c2.gold - c1.gold; //금메달 내림차순 
		}else if(c1.silver != c2.silver) {
			return c2.silver - c1.silver;
		}else {
			return c2.bronze - c1.bronze;
		}
	};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int country = Integer.parseInt(st.nextToken());//국가의 수
		int grade = Integer.parseInt(st.nextToken());//등수를 알고 싶은 국가
		
		ArrayList<Country> list = new ArrayList<>();
		for(int i=0; i<country; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, medalComparator);//국가들의 리스트 정렬
		
		int rank=1;
		for(int i=0; i<country; i++) {
			//현재 국가와 바로 이전 국가 비교 
			//두 객체 같으면 0 반환
			//!= 는 결국 두 국가의 메달수가 다르다는 것을 의미 -> 순위(rank) 업데이트
			if(i>0 && medalComparator.compare(list.get(i), list.get(i-1))!= 0) {
				rank = i+1;//순위는 0이 아닌 1부터 시작하니까 +1
			}
			// 등수를 알고 싶은 국가 찾으면 break
			if(list.get(i).id == grade) {
				System.out.println(rank);
				break;
			}
		}
			
	}

}