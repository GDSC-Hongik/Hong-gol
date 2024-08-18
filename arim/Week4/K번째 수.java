import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] a = new int[n];
        
        for(int i=0; i<n; i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        quickSort(a, 0, n-1, k-1);
        System.out.println(a[k-1]);
    }
    
    public static void quickSort(int[] a, int start, int end,  int k){
        if(start<end){
            int pivot=partition(a, start, end);
            if(pivot==k) return;
            else if(k<pivot) quickSort(a, start, pivot-1, k);
            else quickSort(a, pivot+1, end, k);
        }
    }
    
    public static int partition(int[] a, int start, int end){
        if(start+1==end){
            if(a[start]>a[end]) swap(a, start, end);
            return end;
        }
        int mid=(start+end)/2;
        swap(a, start, mid);
        int pivot=a[start], i=start+1, j=end;
        while(i<=j){
            while(j>=start+1 && pivot<a[j]) j--;
            while(i<=end && pivot>a[i]) i++;
            if(i<=j) swap(a, i++, j--);
        }
        a[start]=a[j];
        a[j]=pivot;
        return j;
    }
    
    public static void swap(int[] a, int i, int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}