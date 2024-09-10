import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    static int[][] dp;
	static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
    
        LCS(str1, str2);
        LCSstring(str1, str1.length(), str2.length());
        
        System.out.println(sb.toString());
    }
    
    static void LCS(String str1, String str2){
        dp = new int[str1.length()+1][str2.length()+1];
        
        for(int i = 1; i<=str1.length(); i++){
            for(int j = 1; j<=str2.length(); j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        sb.append(dp[str1.length()][str2.length()] + "\n");
    }
    
    static void LCSstring(String str1, int i, int j){
        Stack<Character> st = new Stack<>();
        
        while(i>0 && j>0){
            if(i == 0 || j ==0)break;
            
            if(dp[i][j] == dp[i-1][j]){
                i--;
            }
            else if(dp[i][j] == dp[i][j-1]){
                j--;
            }
            else{
                st.push(str1.charAt(i-1));
                i--;j--;
            }
        }
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
    }
}