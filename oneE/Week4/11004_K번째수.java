import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        quicksort(arr,0,N-1,K-1);
        System.out.println(arr[K-1]);
    }
        
        public static void quicksort(int[] arr, int s, int e, int K){
            if(s<e){
                int pivot = partition(arr,s,e);
                if(pivot == K) return;
                else if(pivot < K){
                    quicksort(arr, pivot+1,e,K);
                }
                else if(pivot > K){
                    quicksort(arr,s,pivot-1,K);
                }
            }
        }
        
        public static int partition(int[] arr, int s, int e){
            //데이터가 2개일 때
            if(s+1==e){
                if(arr[s]>arr[e])swap(arr,s,e);
                return e;
            }
            
            int m = (s+e)/2;
            swap(arr, s, m);
            
            int pivot = arr[s];
            int i = s+1; 
            int j = e;
            while(i<=j){
                while(i<=e && arr[i]<pivot){
                    i++;
                }
                while(j>=s+1 && arr[j]>pivot){
                    j--;
                }
                if(i<=j){
                    swap(arr,i++,j--);
                }
            }
            arr[s]=arr[j];
            arr[j]=pivot;
            return j;
        }
        
        public static void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
    
}