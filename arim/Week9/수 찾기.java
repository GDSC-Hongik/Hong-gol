import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0; i<n; i++) a[i]=sc.nextInt();
        int m=sc.nextInt();
        
        Arrays.sort(a);
        for(int i=0; i<m; i++){
            if(binarySearch(a, sc.nextInt())==1) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
    
    public static int binarySearch(int[] a, int target){
        int left=0, right=a.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(a[mid]==target) return 1;
            else if(a[mid]>target) right=mid-1;
            else left=mid+1;
        }
        return 0;
    }
}