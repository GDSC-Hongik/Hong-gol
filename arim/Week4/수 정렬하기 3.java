import java.io.*;
import java.util.*;

public class Main{
    public static int[] a;
    public static long result;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        a=new int[n];
        
        for(int i=0; i<n; i++){
            a[i]=Integer.parseInt(br.readLine());
        }
        br.close();
        Radix_sort(a, 5);
        for(int i=0; i<n; i++){
            bw.write(a[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
    
    public static void Radix_sort(int[] a, int max){
        int[] output = new int[a.length];
        int jarisu=1, cnt=0;
        
        while(cnt!=max){
            int[] bucket=new int[10];
            for(int i=0; i<a.length; i++) bucket[(a[i]/jarisu)%10]++;
            for(int i=1; i<10; i++) bucket[i]+=bucket[i-1];
            for(int i=a.length-1; i>=0; i--){
                output[bucket[(a[i]/jarisu%10)]-1]=a[i];
                bucket[(a[i]/jarisu)%10]--;
            }
            for(int i=0; i<a.length; i++) a[i]=output[i];
            jarisu=jarisu*10;
            cnt++;
        }
    }
}