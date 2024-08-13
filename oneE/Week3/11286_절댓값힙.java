import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (o1,o2)->{
                if(Math.abs(o1)==Math.abs(o2)){
                    return o1>o2? 1: -1;
                }
                else{
                    return Math.abs(o1)-Math.abs(o2);
                }
            }
        );
        
        while(n-->0){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()){
                    System.out.println("0");
                }
                else{
                    System.out.println(pq.poll());
                }
            }
            else{
                pq.add(x);
            }
        }
    }
}