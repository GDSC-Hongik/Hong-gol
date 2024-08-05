import java.util.ArrayList;
import java.util.List;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        List<Integer> pq = new ArrayList<>();
        List<Integer> sq = new ArrayList<>();
        
        for(int i = 0; i< progresses.length; i++){
            pq.add(progresses[i]);
            sq.add(speeds[i]);
        }
        
        while(!pq.isEmpty()){
            while(pq.get(0)<100){
                for(int i = 0; i<pq.size(); i++){
                    pq.set(i, pq.get(i) + sq.get(i));
                }
            }
            int function = 0;
            while(!pq.isEmpty() && pq.get(0)>=100){
                pq.remove(0);
                sq.remove(0);
                function++;
            }
            
            if (function > 0) {
                answer.add(function);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}

/*
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<Integer>();
        int day = 0 ;
        
        for(int i = 0; i< progresses.length; i++){
            if((100-progresses[i])%speeds[i]==0){
                day = (100-progresses[i])/speeds[i];
            }
            else{
                day = (100-progresses[i])/speeds[i] + 1;
            }
            
            q.add(day);
        }
        
        int functions = 0;
        day = q.peek();
        
        while(!q.isEmpty()){
            
            if(q.peek()<=day){
                functions++;
                q.poll();
            }
            else {
				answer.add(functions);
				functions = 1;
				day = q.poll(); 
			}
        }
        answer.add(functions);
        return answer.stream().mapToInt(i->i).toArray();
    }
}
*/