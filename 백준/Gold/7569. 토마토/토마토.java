import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    public static class Point{
        private int h,r,c;
        
        public Point() {
            
        }
        public Point(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }
    
    static int [][][] tomato;
    static boolean [][][] visited;
    static int [][][] day;
    static Queue<Point> queue;
    static int m;
    static int n;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());//상자 가로
        n = Integer.parseInt(st.nextToken());//상자 세로
        h = Integer.parseInt(st.nextToken());//상자 높이
        
        tomato = new int[h][n][m];
        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        
        visited = new boolean[h][n][m];
        day = new int[h][n][m];
        
        queue = new LinkedList<>();
        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    if(tomato[i][j][k] == 1) {
                        queue.add(new Point(i,j,k));
                        visited[i][j][k] = true;
                        day[i][j][k] = 0;
                    }
                }
            }
        }
        bfs();
        
        int Maxday = 0;
        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    Maxday = Math.max(Maxday, day[i][j][k]);
                    if(tomato[i][j][k]== 0) {
                        System.out.println(-1);
                        return;
                    }
                    else {
                        continue;
                    }
                }
            }
        }
        
        System.out.println(Maxday);
        
    }
    public static void bfs() {
        //우하좌상 /높이로 하상
    	int [] dh = {0,0,0,0,1,-1};
        int [] dr = {0,1,0,-1,0,0};
        int [] dc = {1,0,-1,0,0,0};
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int d=0; d<6; d++) {
            	int nh = p.h + dh[d];
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
               
                if(nr<n && nc<m && nr>=0 && nc>=0 && nh>=0 && nh<h && visited[nh][nr][nc]==false && tomato[nh][nr][nc]==0) {
                    tomato[nh][nr][nc] = 1;
                    visited[nh][nr][nc] = true;
                    day[nh][nr][nc] = day[p.h][p.r][p.c]+1;
                    queue.add(new Point(nh,nr,nc));
                }
            }
        }
        
    }

}