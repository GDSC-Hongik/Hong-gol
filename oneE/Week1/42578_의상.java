import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String[] row : clothes) {
            hm.put(row[1], hm.getOrDefault(row[1], 1) + 1); // 안 입는 경우를 위해 1로 초기화
        }
        
        for(String key:hm.keySet()){
            answer *= hm.get(key);
        }
        
        return answer-1; //모든 옷을 안 입는 경우 제외
    }
}