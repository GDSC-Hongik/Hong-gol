import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer=0, time=0, idx=0, cnt=0;
        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        
        while(cnt<jobs.length){
            while(idx<jobs.length&&jobs[idx][0]<=time) q.add(jobs[idx++]);
            if(q.isEmpty()) time=jobs[idx][0];
            else{
                int[] tmp=q.poll();
                answer+=tmp[1]+time-tmp[0];
                time+=tmp[1];
                cnt++;
            }
        }
        return (answer/jobs.length);
    }
}