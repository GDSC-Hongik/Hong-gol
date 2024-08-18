import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] a = new int[str.length()];
        
        for(int i=0; i<str.length(); i++){
            a[i] = Integer.parseInt(str.substring(i, i+1));
        }
        for(int i=0; i<str.length(); i++){
            int max = i;
            for(int j=i+1; j<str.length(); j++){
                if(a[j]>a[max]) max=j;
            }
            if(a[i]<a[max]){
                int tmp=a[i];
                a[i]=a[max];
                a[max]=tmp;
            }
        }
        for(int i=0; i<str.length(); i++){
            System.out.print(a[i]);
        }
    }
}