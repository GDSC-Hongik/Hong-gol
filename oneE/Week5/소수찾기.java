import java.util.*;

class Solution {
    HashSet<Integer> numbersSet = new HashSet<>();
    public int solution(String numbers) {
        
        dfs("", numbers);

        int count = 0;
        Iterator<Integer> it = numbersSet.iterator();
        
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number))
                count++;
        }
        
        return count;
    }
    
    public boolean isPrime(int num) {
        if (num == 0 || num == 1)
            return false;

        for (int i = 2; i <= (int)Math.sqrt(num); i++)
            if (num % i == 0)
                return false;

        return true;
    }

    public void dfs(String str, String numbers) {
        if (!str.equals(""))
            numbersSet.add(Integer.valueOf(str));

        for (int i = 0; i < numbers.length(); i++)
            dfs(str + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1));

    }
}