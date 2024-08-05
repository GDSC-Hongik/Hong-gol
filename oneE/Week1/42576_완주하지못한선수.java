import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> h = new HashMap<>();
        
        for (String player : participant) h.put(player, h.getOrDefault(player, 0) + 1);
        for (String player : completion) h.put(player, h.get(player) - 1);

        for (String key : h.keySet()) {
            if (h.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}