import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Number[] arr = new Number[n];
        
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i]=new Number(num, i);
        }
        Arrays.sort(arr);
        int result=0;
        for(int i=0; i<n; i++){
            result=Math.max(result, arr[i].index-i);
        }
        sb.append(result+1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    public static class Number implements Comparable<Number>{
        int num, index;
        public Number(int num, int index){
            this.num=num;
            this.index=index;
        }
        @Override
        public int compareTo(Number o){
            return this.num-o.num;
        }
    }
}