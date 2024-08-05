import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> seq = new LinkedList<>();
        List<Integer> sorted = new ArrayList<>();
        
        // 큐와 리스트 초기화
        for (int i = 0; i < priorities.length; i++) {
            q.add(priorities[i]);
            seq.add(i);
            sorted.add(priorities[i]);
        }
        
        // 우선순위 리스트를 내림차순으로 정렬
        Collections.sort(sorted, Collections.reverseOrder());
        
        while (!q.isEmpty()) {
            int priority = q.poll();
            int maxPriority = sorted.get(0); // 가장 높은 우선순위
            
            if (priority < maxPriority) {
                // 현재 우선순위가 최대 우선순위보다 낮은 경우
                q.add(priority);
                seq.add(seq.poll()); // seq 큐에서 인덱스도 업데이트
            } else {
                // 현재 우선순위가 최대 우선순위와 같은 경우
                answer++;
                sorted.remove(0); // 처리한 우선순위를 sorted 리스트에서 제거
                
                if (seq.poll() == location) {
                    return answer; // 인덱스가 목표 위치와 일치하면 결과 반환
                }
            }
        }
        
        return answer; // 기본적으로 반환 값 추가
    }
}