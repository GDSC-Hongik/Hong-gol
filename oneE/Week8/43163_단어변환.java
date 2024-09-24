import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        if (!isInWords(target, words)) {
            return 0;
        }
        
        return bfs(begin, target, words);
    }
    
    private boolean isInWords(String target, String[] words) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }
    
    private int bfs(String begin, String target, String[] words) {
        int cnt = 0;
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        
        q.add(begin);
        visited.add(begin);
        
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                
                if (str.equals(target)) {
                    return cnt - 1;  // 현재 레벨에서 목표를 찾았으므로 cnt - 1을 반환
                }

                
                for (String word : words) {
                    if (!visited.contains(word) && canTrans(str, word)) {
                        q.add(word);
                        visited.add(word);
                    }
                }   
            }
        }
        
        return 0;
    }
    
    private boolean canTrans(String str, String word) {
        int diff = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != word.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 1;
    }
}