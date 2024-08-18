import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        int[] a=new int[n], s=new int[n];
        
        for(int i=0; i<n; i++){
            a[i]=sc.nextInt();
        }
        for(int i=1; i<n; i++){
            int point=i, value=a[i];
            for(int j=i-1; j>=0; j--){
                if(a[j]<a[i]){
                    point=j+1;
                    break;
                }
                if(j==0) point=0;
            }
            for(int j=i; j>point; j--){
                a[j]=a[j-1];
            }
            a[point]=value;
        }
        s[0]=a[0];
        for(int i=1; i<n; i++){
            s[i]=s[i-1]+a[i];
        }
        for(int i=0; i<n; i++){
            sum+=s[i];
        }
        System.out.println(sum);
    }
}