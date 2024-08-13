import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        
        for(int i=0; i<operations.length; i++){
            st = new StringTokenizer(operations[i]);
            char op = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            
            if(op=='I'){
                min.add(num);
                max.add(num);
            }
            else if(op=='D'){
                if(num==1){
                    min.remove(max.poll());
                }
                else{
                    max.remove(min.poll());
                }
            }
        }
        
        if(max.isEmpty()){
            return new int[] {0, 0};
        }else{
            return new int[] {max.peek(), min.peek()};
        }
        
    }
}