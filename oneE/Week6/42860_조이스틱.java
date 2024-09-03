class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = name.length();

        
        for(int i = 0; i<len; i++){
            if(name.charAt(i)<'N'){
                answer+= name.charAt(i)-'A';
            }else{
                answer += 'Z'-name.charAt(i) +1;
            }
            
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }
         
            move = Math.min(move, i + len - next + Math.min(i, len - next));
        }
        return answer+ move;
    }
}