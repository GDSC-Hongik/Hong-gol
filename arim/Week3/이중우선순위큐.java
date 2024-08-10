import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reverse = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String s : operations) {
            StringTokenizer st = new StringTokenizer(s, " ");
            String operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            switch (operation) {
                case "I":
                    pq.add(num);
                    reverse.add(num);
                    break;
                case "D":
                    if (num==1) pq.remove(reverse.poll());
                    else reverse.remove(pq.poll());
            }
        }
        int[] answer = new int[2];
        if (!(pq.isEmpty()) && !(reverse.isEmpty())) {
            answer[0] = reverse.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}