import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i =0 ; i<prices.length; i++){
            while(!st.isEmpty() && prices[i]<prices[st.peek()]){
                int index = st.pop();
                answer[index] = i - index;
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int index = st.pop();
            answer[index] = prices.length - (index + 1 );
        }
        
        
        return answer;
    }
}