import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int result = s.length();

		if (s.contains("dz=")) {
			s = s.replaceAll("dz=", "0");

			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					cnt++;
				}
			}
			for (int i = 0; i < cnt; i++) {
				result--;
				result--;
			}
		}
		if (s.contains("c=")) {
			s = s.replaceAll("c=", "1");

			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					cnt++;
				}
			}
			for (int i = 0; i < cnt; i++) {
				result--;
			}
		}
		if (s.contains("c-")) {
			s = s.replaceAll("c-", "2");
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '2') {
					cnt++;
				}
			}
			for (int i = 0; i < cnt; i++) {
				result--;
			}
		}
		if (s.contains("d-")) {
			s = s.replaceAll("d-", "3");
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '3') {
					cnt++;
				}
			}
			for (int i = 0; i < cnt; i++) {
				result--;
			}
		}
		if (s.contains("lj")) {
			s = s.replaceAll("lj", "4");
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '4') {
					cnt++;
				}
			}
			for (int i = 0; i < cnt; i++) {
				result--;
			}
		}
		if (s.contains("nj")) {
			s = s.replaceAll("nj", "5");
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '5') {
					cnt++;
				}
			}
			for (int i = 0; i < cnt; i++) {
				result--;
			}
		}
		if (s.contains("s=")) {
			s = s.replaceAll("s=", "6");
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '6') {
					cnt++;
				}
			}
			for (int i = 0; i < cnt; i++) {
				result--;
			}
		}
		if (s.contains("z=")) {
			s = s.replaceAll("z=", "7");
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '7') {
					cnt++;
				}
			}
			for (int i = 0; i < cnt; i++) {
				result--;
			}
		}

		System.out.println(result);
	}

}
