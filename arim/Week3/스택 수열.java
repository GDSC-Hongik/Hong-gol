import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n=sc.nextInt(), start=0;
        
        for(int i=0; i<n; i++){
            int value = sc.nextInt();
            if(value>start){
                for(int j=start+1; j<=value; j++){
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start=value;
            }
            else if(stack.peek()!=value){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}