import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1,o2)->o1[1]-o2[1]);
        
        int cam = Integer.MIN_VALUE;
        for(int i = 0; i<routes.length; i++){
            if(cam<routes[i][0]){
                answer++;
                cam = routes[i][1];
            }
        }
        
        return answer;
    }
}