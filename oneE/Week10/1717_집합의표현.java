import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{
    static int N;
    static int M;
    static int[] parent;
    
    public static int find(int a){
        if(parent[a]==a){
            return a;
        }else{
            return parent[a]=find(parent[a]);
        }
    }
    
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if(a<b){
                parent[b]=a;
            }
            else{
                parent[a]=b;
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        
        for(int i=1; i<=N; i++){
            parent[i]=i;
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(op==0){
                union(a,b);       
            }
            else{
                if(find(a)==find(b)){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}
