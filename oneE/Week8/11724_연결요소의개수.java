import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{
    static int arr[][];
	static boolean node[];
    static int N;
    static int cnt = 0;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        node = new boolean[N+1];
        
        for(int i =0; i<M; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            
            arr[a][b] = arr[b][a] = 1;
        }
        
        for(int i=1; i<=N; i++){
            if(!node[i]){
                dfs(i);
                cnt++;
            }
        }
        
        System.out.println(cnt);
        
    }
    
    private static void dfs(int v){
        if(node[v]){
            return;
        }
        
        node[v] = true;
        for(int i=1; i<=N; i++){
            if(arr[v][i]==1 && !node[i]){
                dfs(i);
            }
        }
    }
}