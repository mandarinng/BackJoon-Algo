import java.io.*;
import java.util.*;

//백준2512번
//이분탐색
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//지방의 수
        st = new StringTokenizer(br.readLine());
        int [] city = new int[N];//각 지방의 예산을 입력받을 배열
        int cnt=0;
        for(int i=0; i<N; i++){
            city[i] = Integer.parseInt(st.nextToken());
            cnt += city[i];
        }

        int total = Integer.parseInt(br.readLine());//국가 총 예산
        Arrays.sort(city);
        //N개의 국가들의 예산이 국가 총 예산액 이하일 떄 가장 큰 금액을 요청한 국가의 예산 요청액 출력
        if(cnt <= total){
            System.out.println(city[N-1]);
        }
        //총 예산액을 초과한 예산액을 제시한 경우
        else {
            int low=0; //최소 요청액
            int high=city[N-1];//최대 요청액 : 각 국가들이 제사한 금액 중 최고값

            while(low <= high){
                int mid = (low+high)/2; //중간값
                int budget = 0; //N개의 국가들의 요청액 합

                for(int i=0; i<N; i++){//각 국가별로
                    if(mid < city[i]){//제시한 예산액이 중간값보다 크면
                        budget += mid;//중간값을 더하기
                    }
                    else{
                        budget += city[i];//그렇지 않으면 제사한 예산액 더하기
                    }
                }
                //N개 국가의 합산 예산액이 총 국가 예산액보다 작거나 같을 떄
                if(budget <= total){
                    low = mid+1; //최소 요청액은 중간값+1
                }
                else{//큰 경우
                    high = mid-1;//최대 요청액은 중간값-1
                }


            }
            System.out.println(high);//최종적으로 결정된 최대값 출력
        }

    }
}