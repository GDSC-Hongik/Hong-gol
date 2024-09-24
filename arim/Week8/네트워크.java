class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit=new boolean[computers.length];
        
        for(int i=0; i<computers.length; i++) visit[i]=false;
        for(int i=0; i<computers.length; i++){
            if(visit[i]==false){
                answer++;
                dfs(i, visit, computers);
            }
        }
        return answer;
    }
    
    public void dfs(int c, boolean[] visit, int[][] computers){
        visit[c]=true;
        for(int i=0; i<computers.length; i++){
            if(visit[i]==false&&computers[c][i]==1){
                dfs(i, visit, computers);
            }
        }
    }
}