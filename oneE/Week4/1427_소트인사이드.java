import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();
        int[] arr = new int[N.length()];
        
        for(int i=0; i<N.length(); i++){
            arr[i]=N.charAt(i)-'0';
        }
        
        for(int i =0; i<N.length(); i++){
            int max = i;
            for(int j = i; j<N.length(); j++){
                if(arr[max]<arr[j]){
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max]=arr[i];
            arr[i]= temp;
        }
        
        for(int i=0; i<N.length(); i++){
            System.out.print(arr[i]);
        }
        
    }
}