import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

class Main{
    static int V;
    static int E;
    static int K;
    static List<Node>[] list;
    static int[] dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        dist = new int[V+1];
        
        for(int i=1; i<=V; i++){
            list[i]= new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
    
        for(int i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }
  
        dijkstra(K);
        
        StringBuilder sb = new StringBuilder();        
        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        
        System.out.print(sb);
    }
    
    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] checked = new boolean[V+1];
        pq.add(new Node(start,0));
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;
            
            if(checked[cur]) continue;
            checked[cur] = true;
            
            for(Node n : list[cur]){
                if(dist[n.end]> dist[cur]+n.weight){
                    dist[n.end] = dist[cur]+n.weight;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }
    }
    
}