import java.util.*;

public class Main{
    public static int[][] graph=new int[1001][1001];
    public static boolean[] visit= new boolean[1001];
    public static Queue<Integer> queue;
    public static int n, m, v;
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        v=sc.nextInt();
        for(int i=0; i<m; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph[a][b]=1;
            graph[b][a]=1;
        }
        dfs(v);
        System.out.println();
        Arrays.fill(visit, false);
        bfs(v);
    }
    
    public static void dfs(int start){
        visit[start]=true;
        System.out.print(start+" ");
        for(int i=1; i<=n; i++){
            if(graph[start][i]==1&&visit[i]==false) dfs(i);
        }
    }
    
    public static void bfs(int start){
        queue=new LinkedList<Integer>();
        queue.add(start);
        visit[start]=true;
        System.out.print(start+" ");
        
        while(!queue.isEmpty()){
            int temp=queue.poll();
            for(int i=1; i<=n; i++){
                if(graph[temp][i]==1&&visit[i]==false){
                    queue.add(i);
                    visit[i]=true;
                    System.out.print(i+" ");
                }
            }
        }
    }
}