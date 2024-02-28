import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());//조카의 수
        int N = Integer.parseInt(st.nextToken());//과자의 수

        int [] cookies = new int[N];//N개 과자의 길이 입력받을 배열

        int low=1;//최소값 : 0이면 런타임 에러남. 1부터.
        int high=-1;//최대값

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cookies[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cookies);//정렬해서 가장 길이가 긴 과자를 최대값으로 둠
        high = cookies[N-1];

        while(low <= high){

            int mid = (low+high)/2;//중간값
            int cnt = 0;//mid를 기준으로 과자를 잘랐을 때 mid이상의 과자의 수

            // 과자 배열을 순회하며 각 과자를 mid 길이로 잘라 얻을 수 있는 조각 수를 계산
            for(int cookie : cookies){
                cnt += cookie/mid;// 각 과자를 mid 길이로 나누어 얻을 수 있는 조각의 수를 cnt에 더함
            }

                //mid 보다 크거나 같은 과자의 수가 조카의 수보다 많거나 같으면 최소값=mid+1
                if(cnt >= M){
                    low = mid+1;
                }
                else{//과자의 수보다 조카의 수가 많으면 최대값=mid-1
                    high = mid-1;
                }
        }
        System.out.println(high);//나눠줄 수 있는 최대 과자의 길이
    }
}