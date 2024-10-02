import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;

class Main{
    static int sum;
    static List<Node>[] list;
	static boolean[] visited;
    
    static class Node implements Comparable<Node>{
		int to;
		int weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
        
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[V+1];
        visited = new boolean[V+1];
        
        for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
		}
        
        for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list[A].add(new Node(B,C));
			list[B].add(new Node(A,C));
		}
        
        prim();
        System.out.println(sum);
    }
    
    static void prim(){
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            int weight = cur.weight;
            
            if(visited[node]) continue;
            visited[node] = true;
            sum += weight;
            
            for(Node n : list[node]){
                if(!visited[n.to]){
                    pq.add(n);
                }
            }
        }
        
    }
}