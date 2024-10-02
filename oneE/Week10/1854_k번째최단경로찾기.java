import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;

class Main{
    static int N,M,K;
    static List<Node>[] list;
    static Queue<Integer>[] pq;
    
    static class Node implements Comparable<Node>{
        int v;
        int w;
        
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        pq = new PriorityQueue[N+1];
        
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();  
            pq[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
        }
       
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            list[a].add(new Node(b,c));
        }
        
        dijkstra();
        
        for(int i=1; i<=N; i++){
            if(pq[i].size() != K ) System.out.println(-1);
            else System.out.println(pq[i].peek());
        }
    }
    
    static void dijkstra(){
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));
        pq[1].add(0);
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            int curv = cur.v;
            int curw = cur.w;
            
            for(Node n: list[curv]){
                if(pq[n.v].size()<K){
                    pq[n.v].add((curw + n.w));
                    q.add(new Node(n.v, curw + n.w));
                }
                else if(pq[n.v].peek() > curw+n.w){
                    pq[n.v].poll();
                    pq[n.v].add(curw + n.w);
                    q.add(new Node(n.v, curw + n.w));
                }
            }
        }
    }
}