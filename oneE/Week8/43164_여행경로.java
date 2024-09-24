import java.util.ArrayList;
import java.util.Collections;

class Solution {
    ArrayList<String> route; 
    boolean [] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        route = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, cnt);
        
        Collections.sort(route);
        
        return route.get(0).split(" ");
    }
    
    private void dfs(String s, String r, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            route.add(r);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(s.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], r+" "+tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }
        }
    }
}