import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // HashSet을 사용하여 빠른 조회와 삭제를 지원
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();
        
        for (int r : reserve) {
            reserveSet.add(r);
        }
        
        for (int l : lost) {
            if (reserveSet.contains(l)) {
                // 여벌의 체육복이 있는 학생이 도난당한 경우
                reserveSet.remove(l);
            } else {
                lostSet.add(l);
            }
        }
        
        // 체육복을 빌릴 수 있는 학생들을 처리
        for (int l : lostSet) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
                answer++;
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
                answer++;
            }
        }
        
        // 전체 학생 수에서 최종적으로 체육복을 입은 학생 수
        answer = n - lostSet.size() + answer;
        
        return answer;
    }
}