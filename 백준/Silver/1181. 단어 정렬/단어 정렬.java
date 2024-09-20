//백준 1181 단어 정렬
import java.io.*;
import java.util.*;

class Word implements Comparable<Word> {
	int len;
	String word;

	public Word(int len, String word) {
		this.len = len;
		this.word = word;
	}

	@Override
	public int compareTo(Word o) {
		if (this.len == o.len) {
			return this.word.compareTo(o.word);
		}
		return this.len - o.len;
	}
}
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Set<String> wordset = new HashSet<>();

		for (int i = 0; i < n; i++) {
			wordset.add(br.readLine());
		}
		
		List<Word> wordList = new ArrayList<>();
		for(String s : wordset) {
			wordList.add(new Word(s.length(), s));
		}
		
		Collections.sort(wordList);
		
		StringBuilder sb = new StringBuilder();
		for(Word w : wordList) {
			sb.append(w.word).append("\n");
		}
		System.out.println(sb.toString());
	}
}