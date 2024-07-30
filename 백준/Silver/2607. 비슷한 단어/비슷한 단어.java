import java.io.*;
import java.util.*;

//백준 2607번 비슷한 단어

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());//단어의 수
		String first = br.readLine();//첫 번째 단어
		String [] origin = first.split("");//한 글자씩 배열에 넣음
		int originCnt = origin.length;

		int answer = 0;
		
		for(int i=0; i<n-1; i++) {
			String word = br.readLine();//다음 단어
			String [] arr2 = word.split("");
			ArrayList <String> nWord = new ArrayList<>(); //단어 한 글자씩 list로 만듦
			for(int j=0; j<arr2.length; j++) {
				nWord.add(arr2[j]);
			}
			int wordCnt = nWord.size();
			
			if(wordCnt >= originCnt) {
				for(int j=0; j<origin.length; j++) {
					if(nWord.contains(origin[j])) {
						nWord.remove(origin[j]);
					}
				}
				
				int remainCnt = nWord.size();
				
				if(Math.abs(originCnt - wordCnt) <= 1 && remainCnt <= 1) answer ++;
				
			}else {
				for(int j=0; j<origin.length; j++) {
					if(nWord.contains(origin[j])) {
						nWord.remove(origin[j]);
					}
				}
				
				int remainCnt = nWord.size();
				
				if(Math.abs(originCnt - wordCnt) <= 1 && remainCnt == 0) answer++;
			}
			
		}
		System.out.println(answer);
		

	}

}