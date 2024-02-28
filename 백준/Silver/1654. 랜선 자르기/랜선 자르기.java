import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());//이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken());//필요한 랜선의 개수

        int [] line = new int[K];//K개의 랜선 길이
        for(int i=0; i<K; i++){
            line[i] = Integer.parseInt(br.readLine());
        }

        long low=1;//최소값
        long high=-1;//최대값
        Arrays.sort(line);
        high = line[K-1];

        while(low <= high){
            long mid = (low+high)/2;
            int cnt=0;

            for(int cut : line){
                cnt += cut/mid;
            }

            if(cnt >= N){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        System.out.println(high);

    }
}