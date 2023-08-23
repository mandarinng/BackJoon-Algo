import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] dwarf = new int[9];
        for(int i=0; i<9; i++) {
            dwarf[i] = sc.nextInt();
        } //9난장이의 키 입력받기
        
         //9개의 입력 중 7개 뽑기x
         //9개의 입력 중 2개 빼서 나머지 합이 100인 것 찾기
        // 뺄 두 개의 값 고르기 위해 이중for문 사용
        Loop1 : for(int i=0; i<dwarf.length-1;i++) { // 오른쪽 방향으로 인덱스값 일일이 비교
            for(int j=i+1;j<dwarf.length;j++) {
                List<Integer> dwarfList = Arrays.stream(dwarf).boxed().collect(Collectors.toList());
                
                dwarfList.remove(j);
                dwarfList.remove(i);// i j 순서 중요
               
                int sum=0;
                for(int k=0; k<dwarf.length-2;k++) {
                    sum+=dwarfList.get(k);
                    
                }
                //나머지 7개의 값 오름차순으로 정렬
                //Arrays.sort로 정렬하기 위해 다시 배열로 변환
         
                //String dwarf2 [] = dwarfList.toArray(new String[dwarfList.size()]);
                if(sum==100) {
                	Collections.sort(dwarfList);
                	for(int m=0;m<dwarfList.size();m++) {
                		 System.out.println(dwarfList.get(m));
                	}
                	break Loop1;
                   
                }
                
            }//내부 for문 끝
        }//외부 for문 끝

    }

}