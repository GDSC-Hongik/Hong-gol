import java.io.*;
import java.util.*;

public class Main{
    public static int[] a, tmp;
    public static long result;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        a=new int[n+1];
        tmp=new int[n+1];
        
        for(int i=1; i<=n; i++){
            a[i]=Integer.parseInt(br.readLine());
        }
        merge_sort(1,n);
        for(int i=1; i<=n; i++){
            bw.write(a[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
    
    private static void merge_sort(int start, int end){
        if(end-start<1) return;
        int mid=start+(end-start)/2;
        merge_sort(start, mid);
        merge_sort(mid+1, end);
        for(int i=start; i<=end; i++){
            tmp[i]=a[i];
        }
        int k=start, idx1=start, idx2=mid+1;
        while(idx1<=mid && idx2<=end){
            if(tmp[idx1]>tmp[idx2]){
                a[k]=tmp[idx2];
                k++;
                idx2++;
            }
            else{
                a[k]=tmp[idx1];
                k++;
                idx1++;
            }
        }
        while(idx1<=mid){
            a[k]=tmp[idx1];
            k++;
            idx1++;
        }
        while(idx2<=end){
            a[k]=tmp[idx2];
            k++;
            idx2++;
        }
    }
}