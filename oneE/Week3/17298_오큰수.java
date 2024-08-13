import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i<N; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i = 1; i<N; i++){
            while(!stack.isEmpty()&& A[stack.peek()]<A[i]){
                    ans[stack.pop()]=A[i];
                }
            stack.push(i);
            
        }
        while(!stack.isEmpty()){
            ans[stack.pop()]=-1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            sb.append(ans[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}