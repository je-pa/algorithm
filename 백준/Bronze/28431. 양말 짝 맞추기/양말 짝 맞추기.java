import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i=0; i<5 ;i++){
            int n = scan.nextInt();
            arr[n]++;
        }
        for(int i=0 ; i<10 ; i++){
            if(arr[i]%2 == 1){
                System.out.print(i);
            }
        }
    }
}