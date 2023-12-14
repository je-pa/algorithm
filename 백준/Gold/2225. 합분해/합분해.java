import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());
        int k = Integer.parseInt(scan.next());
        int[][] arr = new int[n+1][k+1];
        for(int i=0 ; i<k+1 ; i++){
            arr[0][i] = 1;
        }
        for(int i=0 ; i<n+1 ; i++){
            arr[i][1] = 1;
        }
        for(int i=1 ; i<n+1; i++){
            for(int j=2 ; j<k+1 ; j++){
                arr[i][j] = (arr[i][j-1] + arr[i-1][j])%1_000_000_000;
            }
        }
        System.out.println(arr[n][k]);
    }
}
