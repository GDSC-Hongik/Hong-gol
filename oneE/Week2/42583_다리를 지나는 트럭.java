import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> wait = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int truck : truck_weights){
            wait.add(truck);
        }
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int w = 0;
        
        while(!bridge.isEmpty()){
            w-= bridge.poll();
            answer++;
            
            if(!wait.isEmpty()){
                if(w + wait.peek()<=weight){
                    bridge.add(wait.peek());
                    w += wait.poll();
                }
                else{
                    bridge.add(0);
                }
            }
            
        }
        
        return answer;
    }
}