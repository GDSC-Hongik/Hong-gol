import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        
        Stack<Integer> st = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int num = 1;
        
        while(n-- > 0){
            
            int current = Integer.parseInt(br.readLine());
            
            if(current>=num){
                while(current>=num){
                    st.push(num++);
                    sb.append("+\n");
                }
            }
            else if(!st.isEmpty()&&st.peek()!= current){
                    System.out.println("NO");
				    return;	
            }
            
            st.pop();
            sb.append("-\n");
            
        }
        
        System.out.println(sb);
    }
}