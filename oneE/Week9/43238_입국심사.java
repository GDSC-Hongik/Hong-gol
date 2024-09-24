import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long left = times[0];
        long right = times[times.length-1]*(long)n;
    
        while(left<=right){
            long mid = (left+right)/2;
            long total = 0;
            
            for(int t : times){
                total += mid/t;
            }
            if(total>=n){
                answer = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
}