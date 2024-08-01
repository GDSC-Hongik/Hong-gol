import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        
        for(String num : phone_book){
            set.add(num);
        }
        
        for(String num : phone_book){
            for(int j = 1; j < num.length(); j++){
                if(set.contains(num.substring(0, j))){
                    return false;
                }
            }
        }
        return true;
    }
}