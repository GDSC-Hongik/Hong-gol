import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Data implements Comparable<Data> {
    int num; 
    int idx; 
 
    Data(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
 
    @Override
    public int compareTo(Data o) {
        return num - o.num;
    }
 
}

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Data[] arr = new Data[N];
        
        for(int i =0; i<N; i++){
            arr[i] = new Data(Integer.parseInt(br.readLine()),i);
        }
        
        Arrays.sort(arr);
        int max = 0;
        for(int i = 0; i<N; i++){
            if(max<arr[i].idx - i){
                max = arr[i].idx - i;
            }
        }
        
        System.out.println(max+1);
    }
}
