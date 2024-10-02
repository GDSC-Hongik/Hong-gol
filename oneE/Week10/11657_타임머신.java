import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Bus{
    int depart, arrive, time;
    public Bus(int depart, int arrive, int time){
        this.depart = depart;
        this.arrive = arrive;
        this.time = time;
    }
}

class Main{
    static int N, M;
    static Bus[] b;
    static long[] times;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        b = new Bus[M];
        times = new long[N+1];
                                                 
        Arrays.fill(times,Long.MAX_VALUE);       
                                            
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());   
            
            b[i] = new Bus(A, B, C); 
        }                    
                                           
        if(bellmanford()){
            System.out.println(-1);
        }else{
            for(int i=2; i<=N; i++) {
				if(times[i] == Long.MAX_VALUE) {
					System.out.println("-1");
				}
				else {
					System.out.println(times[i]);
				}
			}
        }                                         
    }
    
    static boolean bellmanford(){
        times[1] = 0;
        
        for(int i=1; i<=N; i++){
            for(int j=0; j<M; j++){
                int curDepart = b[j].depart;
                int curArrive = b[j].arrive;
                int cost = b[j].time;
                
                if(times[curDepart]==Long.MAX_VALUE) continue;
                if(times[curArrive]> times[curDepart] + cost){
                    times[curArrive] = times[curDepart] + cost;
                    if (i == N) return true;				
                }
            }
        }
        return false;
    }
}