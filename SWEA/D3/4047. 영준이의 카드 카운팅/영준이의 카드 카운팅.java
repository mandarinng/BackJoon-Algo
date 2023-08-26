import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		loop :for (int tc = 1; tc <= T; tc++) {
			String card = sc.next();

			int S = 0;
			int D = 0;
			int H = 0;
			int C = 0;

			ArrayList<String> list = new ArrayList<>();
			String c = "";
			for (int i = 0; i < card.length(); i += 3) {
				c = "";
				for (int j = i; j < i + 3; j++) {
					c += card.charAt(j);
					if (card.charAt(j) == 'S') {
						S++;
					} else if (card.charAt(j) == 'D') {
						D++;
					} else if (card.charAt(j) == 'H') {
						H++;
					} else if (card.charAt(j) == 'C') {
						C++;
					}
				}
				list.add(c);
			}

			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i).equals(list.get(j))) {
						System.out.println("#" + tc + " " + "ERROR");
						continue loop;
					}
				}
			}

			System.out.println("#" + tc + " " + (13 - S)+" "+ (13 - D)+" "+ (13 - H )+" " + (13 - C));
		}
	}

}