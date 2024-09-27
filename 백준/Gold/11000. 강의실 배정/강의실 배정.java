//백준 11000 강의실 배정
import java.io.*;
import java.util.*;

class Time implements Comparable<Time> {
	int start;
	int end;

	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Time o) {
		return this.start - o.start;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		Time[] classes = new Time[n];
		PriorityQueue<Integer> endTimes = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			classes[i] = new Time(start, end);
		}

		Arrays.sort(classes);// 시작 시간으로 오름차순 정렬
		endTimes.add(classes[0].end); // 가장 이른 시간 타임 넣기
		boolean flag = false;
		for (int i = 1; i < n; i++) {
			int startTime = classes[i].start;
			int endTime = classes[i].end;
			if (startTime >= endTimes.peek()) {
				endTimes.poll();
			}
				endTimes.add(endTime);
		}
		System.out.println(endTimes.size());
	}
}