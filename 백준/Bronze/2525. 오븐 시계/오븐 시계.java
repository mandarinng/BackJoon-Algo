import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//시작 시각
		int h = sc.nextInt();
		int m = sc.nextInt();
		//필요한 시간
		int c = sc.nextInt();
		//h,m을 분으로 변환
		int min;
		
		min=h*60+m;
		min += c;
		
		
		h = (min/60)%24;
		
		m = min%60;
		
		
		System.out.println(h+" "+ m);
		
	}

}