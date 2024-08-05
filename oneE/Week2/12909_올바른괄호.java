import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == '(') {
                st.push(x);
            } else {
                if (st.isEmpty() || st.pop() != '(') {
                    answer = false;
                    break;
                }
            }
        }
        
        if(!st.isEmpty()){
            answer = false;
        }
    
        return answer;
    }
}