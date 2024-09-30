import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static List<List<Integer>> l=new ArrayList<>();
    static int[] time, parent, answer;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        time=new int[n+1];
        parent=new int[n+1];
        answer=new int[n+1];
        for(int i=0; i<=n; i++) l.add(new ArrayList<>());
        for(int i=1; i<=n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            time[i]=Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int num=Integer.parseInt(st.nextToken());
                if(num==-1) break;
                l.get(num).add(i);
                parent[i]++;
            }
        }
        topologicalSort();
        for(int i=1; i<=n; i++) System.out.println(answer[i]);
    }
    
    static void topologicalSort(){
        Queue<Integer> q=new LinkedList<>();
        for(int i=1; i<=n; i++)
            if(parent[i]==0) q.offer(i);
        while(!q.isEmpty()){
            int v=q.poll();
            answer[v]+=time[v];
            for(int i=0; i<l.get(v).size(); i++){
                int nextV=l.get(v).get(i);
                parent[nextV]--;
                if(parent[nextV]==0) q.offer(nextV);
                answer[nextV]=Math.max(answer[nextV], answer[v]);
            }
        }
    }
}