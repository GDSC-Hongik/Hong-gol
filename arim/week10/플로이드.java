import java.io.*;
import java.util.*;

public class Main{
    static int[][] map;
    static final int INF=9900001;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        map=new int[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                else map[i][j]=INF;
            }
        }
        
        for(int i=0; i<m; i++){
            StringTokenizer st=new StringTokenizer(br.readLine(), " ");
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            map[s][e]=Math.min(w, map[s][e]);
        }
        
        floydWarshall(n);
        StringBuilder sb=new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j]==INF) sb.append("0 ");
                else sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    public static void floydWarshall(int n){
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(i==j||j==k) continue;
                    if(map[i][k]+map[k][j]<map[i][j]) map[i][j]=map[i][k]+map[k][j];
                }
            }
        }
    }
}