class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp_first=new int[money.length];
        int[] dp_last=new int[money.length];
        
        dp_first[0]=money[0];
        dp_first[1]=money[0];
        
        dp_last[0]=0;
        dp_last[1]=money[1];
        
        for(int i=2; i<money.length; i++){
            dp_first[i]=Math.max(dp_first[i-1], money[i]+dp_first[i-2]);
            dp_last[i]=Math.max(dp_last[i-1], money[i]+dp_last[i-2]);
        }
        return Math.max(dp_first[money.length-2], dp_last[money.length-1]);
    }
}