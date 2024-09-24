import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            
            if (binarySearch(A, num)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
 
        }
        
        System.out.println(sb);
        
    }
    
    private static boolean binarySearch(int[] A, int target){
        int left = 0;
        int right = A.length-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(A[mid]>target){
                right = mid - 1;
            }
            else if(A[mid]<target){
                left = mid + 1;
            }
            else{
                return true;
            }
        }
        return false; 
    }
}