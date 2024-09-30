import java.io.*;
import java.util.*;

class Bus{
    int u, v, val;
    
    public Bus(int u, int v, int val){
        this.u=u;
        this.v=v;
        this.val=val;
    }
}

public class Main{
    static int n, m, INF=Integer.MAX_VALUE;
    static Bus[] e;
    static long[] dist;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        e=new Bus[m];
        dist=new long[n+1];
      
        for(int i=1; i<=n; i++) dist[i]=INF;
        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int val=Integer.parseInt(st.nextToken());
            e[i]=new Bus(u,v,val);
        }
        if(bellmanford(1)) System.out.println(-1);
        else{
            for(int i=2; i<=n; i++){
                if(dist[i]==INF) System.out.println("-1");
                else System.out.println(dist[i]);
            }
        }
    }
    
    static boolean bellmanford(int start){
        dist[start]=0;
        for(int i=1; i<=n; i++){
            for(int j=0; j<m; j++){
                int cur=e[j].u;
                int next=e[j].v;
                int cost=e[j].val;
                if(dist[cur]==INF) continue;
                if(dist[cur]+cost<dist[next]){
                    dist[next]=dist[cur]+cost;
                    if(i==n) return true;
                }
            }
        }
        return false;
    }
}