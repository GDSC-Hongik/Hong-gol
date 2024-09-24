import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visit;
    static int N, M, V;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1][N+1];
        visit = new boolean[N+1];
        
        for(int i=0; i<M; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(str.nextToken());
            int B = Integer.parseInt(str.nextToken());
            arr[A][B] = arr[B][A] = 1;
        }
        
        dfs(V); 
        sb.append("\n");
        
        visit = new boolean[N+1];
        bfs(V);
        
        System.out.println(sb);
    }
    
    private static void dfs(int V){
        visit[V] = true;
        sb.append(V+" ");
        
        for(int i=1; i<=N; i++){
            if(!visit[i] && arr[V][i]==1){
                dfs(i);
            }
        }
    }
    
    private static void bfs(int V){
        visit[V] = true;
        q.add(V);
        
        while(!q.isEmpty()){
            int node = q.poll();
            sb.append(node+ " ");
            
            for(int i=1; i<=N; i++){
                if(!visit[i] && arr[node][i]==1){
                    q.add(i);
                    visit[i] = true;
                }
            }  
        }
    }
}