import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        int duplicate = -1;
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i]!=duplicate){
                answer.add(arr[i]);
                duplicate=arr[i];
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}