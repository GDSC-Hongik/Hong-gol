import java.util.*;

public class Main{
    static int[] parent;
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        parent=new int[n+1];
        for(int i=0; i<=n; i++) parent[i]=i;
        
        int m=sc.nextInt();
        for(int i=0; i<m; i++){
            int op=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            int pa=find(a), pb=find(b);
            
            if(op==0 && pa!=pb) union(pa, pb);
            else if(op==1 && pa!=pb) System.out.println("NO");
            else if(op==1 && pa==pb) System.out.println("YES");
        }
    }
    
    public static void union(int a, int b){
        parent[b]=a;
    }
    
    public static int find(int a){
        if(parent[a]==a) return a;
        else return parent[a]=find(parent[a]);
    }
}