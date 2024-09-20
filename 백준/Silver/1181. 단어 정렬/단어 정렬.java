//백준 1181 단어 정렬
import java.io.*;
import java.util.*;

class Word implements Comparable<Word>{
	int len;
	String w;
	
	public Word(int len, String w) {
		this.len = len;
		this.w = w;
	}

	@Override
	public int compareTo(Word o) {
		if(this.len == o.len) {
			return this.w.compareTo(o.w);
		}
		return this.len - o.len;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Set<String> words = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			words.add(br.readLine());
		}
		
		List<Word> wordList = new ArrayList<>();
		
		for(String w : words) {
			wordList.add(new Word(w.length(), w));
		}
		Collections.sort(wordList);
		
		StringBuilder sb = new StringBuilder();
		for(Word w : wordList) {
			sb.append(w.w).append("\n");
		}
		System.out.println(sb.toString());
	}
}