import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.add(s);
        }
        
        while(pq.size()>1){
            if(pq.peek()<K){
                int small = pq.poll();
                pq.add(small+pq.poll()*2);
                answer++;
            }
            else{
                return answer;
            }
        }
        
        if(pq.peek()>=K){
            return answer;
        }
        else {
            return -1;
        }
        
    }
}