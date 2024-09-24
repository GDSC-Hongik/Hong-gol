import java.util.*;

class Solution {
    int[] dx={0,1,-1,0};
    int[] dy={1,0,0,-1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visit=new int[maps.length][maps[0].length];
        
        bfs(maps, visit);
        answer=visit[maps.length-1][maps[0].length-1];
        
        if(answer==0) answer=-1;
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visit){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0, 0});
        visit[0][0]=1;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            
            for(int i=0; i<4; i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx<0||ny<0||nx>maps.length-1||ny>maps[0].length-1) continue;
                if(visit[nx][ny]==0&&maps[nx][ny]==1){
                    visit[nx][ny]=visit[x][y]+1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}