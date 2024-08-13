import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        // jobs를 요청 시간 기준으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int time = 0;  // 현재 시간
        int index = 0; // jobs 배열에서 현재 처리 중인 작업의 인덱스
        int totalDuration = 0; // 모든 작업의 총 대기 시간
        
        while (index < jobs.length || !pq.isEmpty()) {
            // 현재 시간까지 도착한 모든 작업을 우선순위 큐에 추가
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.add(jobs[index]);
                index++;
            }
            
            if (!pq.isEmpty()) {
                int[] currentJob = pq.poll();
                time += currentJob[1]; // 현재 작업을 수행하는 데 걸리는 시간만큼 현재 시간 증가
                totalDuration += time - currentJob[0]; // 현재 작업의 총 대기 시간 누적
            } else {
                // 만약 큐가 비어있고 더 처리할 작업이 남아 있다면, 시간을 다음 작업의 도착 시간으로 설정
                time = jobs[index][0];
            }
        }
        
        return totalDuration / jobs.length; // 평균 대기 시간 반환
    }
}