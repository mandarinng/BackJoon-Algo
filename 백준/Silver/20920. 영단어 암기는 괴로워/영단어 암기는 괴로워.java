//백준 20920 영단어 암기는 괴로워
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//영단어 개수
		int M = Integer.parseInt(st.nextToken());//단어 최소 길이
		
		Map<String, Integer> map = new HashMap<>();//단어와 빈도수를 저장할 map
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String word = st.nextToken();
			
			if(word.length() >= M) {
				map.put(word, map.getOrDefault(word, 0)+1);
			}
		}
		
		List<String> words = new ArrayList<>(map.keySet());//map에 들어있는 영단어들만 뽑아옴
		
		words.sort(getWordComparator(map));
		
		StringBuilder sb = new StringBuilder();
		for(String w : words) {
			sb.append(w).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static Comparator<String> getWordComparator(Map<String, Integer> map){ 
		
		return(o1, o2)->{
			int freq1 = map.get(o1);//단어의 빈도수
			int freq2 = map.get(o2);
			
			//자주 나오는 단어일수록 앞에 배치한다.
			if(freq1 != freq2) {
				return Integer.compare(freq2,freq1);
			}
			
			//해당 단어의 길이가 길수록 앞에 배치한다.
			if(o1.length() != o2.length()) {
				return Integer.compare(o2.length(), o1.length());
			}
			//알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
			return o1.compareTo(o2);
		};
		
	}

}