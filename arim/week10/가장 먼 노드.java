import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        boolean[] visit=new boolean[n+1];
        
        for(int[] i : edge){
            int u=i[0], v=i[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return bfs(graph, n, visit);
    }
    
    public static int bfs(ArrayList<ArrayList<Integer>> graph, int n, boolean[] visit){
        Queue<int[]> q=new LinkedList<>();
        int answer=0;
        
        q.add(new int[] {1,0});
        visit[1]=true;
        int max=0;
        
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int u=arr[0], depth=arr[1];
            
            if(depth==max) answer++;
            else if(depth>max){
                max=depth;
                answer=1;
            }
            
            for(int i=0; i<graph.get(u).size(); i++){
                int v=graph.get(u).get(i);
                if(!visit[v]){
                    q.add(new int[] {v, depth+1});
                    visit[v]=true;
                }
            }
        }
        return answer;
    }
}