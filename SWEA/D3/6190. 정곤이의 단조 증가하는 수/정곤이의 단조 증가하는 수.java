import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] input = new int[N];// 입력받은 숫자들 배열에 저장
            for (int i = 0; i < N; i++) {
                input[i] = sc.nextInt();
            }
 
            // 각 배열을 두개씩 뽑아 곱한 값들 중 단조증가하는 수만 리스트에 저장
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < input.length - 1; i++) {
                //a break: 단조증가 수가 아닐 경우, 다음 곱의 수를 검사하기 위해 j++로 돌아옴
                a: for (int j = i + 1; j < input.length; j++) {
                    //input[i] * input[j]해준 수를 문자 하나씩 num배열에 넣어줌
                    //input[i] * input[j]==123이었으면 1 2 3하나씩
                    char[] num = Integer.toString(input[i] * input[j]).toCharArray();
                    //단조증가 검사 부분. 앞 수가 뒤의 수보다 크면 단조증가에 위배됨
                    for (int k = 0; k < num.length - 1; k++) {
                        if (num[k] > num[k + 1]) {
                            continue a; //다른 수를 곱해서 다음 검사하기
                        }
                    }
                    list.add(input[i] * input[j]);//단조증가를 만족하면 리스트에 넣기
 
                }
            }
 
            Collections.sort(list);//리스트에 최대값을 출력하기 위해 정렬
            // 단조 증가하는 수가 없다면 -1을 출력
            if (list.isEmpty()) {
                System.out.println("#" + tc + " " + "-1");
            } else
                System.out.println("#" + tc + " " + list.get(list.size() - 1));
        }
 
    }
 
}