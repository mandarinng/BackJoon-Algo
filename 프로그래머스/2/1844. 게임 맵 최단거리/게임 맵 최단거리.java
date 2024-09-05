import java.util.*;

class Point{
    int row;
    int col;
    Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    
    static int answer = 0;
    static boolean [][] visited;
    static Queue<Point> queue = new LinkedList<>(); 
    public int solution(int[][] maps) {
        
        visited = new boolean[maps.length][maps[0].length];
        
        bfs(maps, 0,0);
        return answer;
    }
    public static void bfs(int [][] maps, int row, int col){

        int [] dr = {0,1,0,-1};
        int [] dc = {1,0,-1,0};
        
        queue.add(new Point(row, col));
        visited[row][col] = true;
        answer++;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Point p = queue.poll();
            
            if(p.row == maps.length-1 && p.col == maps[0].length-1){
                return;
            }
            
            for(int d=0; d<4; d++){
                int nr = p.row+dr[d];
                int nc = p.col+dc[d];
                if(nr>=0 && nc>=0 && nr<maps.length && nc<maps[0].length){
                    if(maps[nr][nc] == 1 && !visited[nr][nc]){
                        queue.add(new Point(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
            }
            answer++;
        }
        
        if(!visited[maps.length-1][maps[0].length-1]){
            answer = -1;
        }
    }
}