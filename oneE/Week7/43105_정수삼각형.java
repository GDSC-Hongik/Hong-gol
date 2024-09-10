class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int dp[][] = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<i+1; j++){
                if(j == 0 ){
                    dp[i][j] = triangle[i][j]+dp[i-1][j];
                }
                else if(j==i){
                    dp[i][j] = triangle[i][j]+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = triangle[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        
        for(int max : dp[triangle.length-1]){
            if(max>answer)
                answer = max;
        }
        
        return answer;
    }
}