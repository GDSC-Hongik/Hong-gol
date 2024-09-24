import java.util.*;

public class Main{
    static int[][] graph=new int[1001][1001];
    static int v, e;
    static boolean[] visit=new boolean[1001];
    
    public static void dfs(int idx){
        if(visit[idx]) return;
        else{
            visit[idx]=true;
            for(int i=1; i<=v; i++){
                if(graph[idx][i]==1) dfs(i);
            }
        }
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        e=sc.nextInt();
        int a, b, cnt=0;
        
        for(int i=0; i<e; i++){
            a=sc.nextInt();
            b=sc.nextInt();
            graph[a][b]=1;
            graph[b][a]=1;
        }
        for(int i=1; i<=v; i++){
            if(!visit[i]){
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}