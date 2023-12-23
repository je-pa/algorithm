import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][10];

        for(int i=0 ; i<10 ; i++){
            arr[1][i] = 1;
        }
        for(int i=1 ; i<n+1 ; i++){
            arr[i][0] = 1;
        }
        for(int i=2 ; i<n+1 ; i++){
            for(int j=1; j<10 ; j++){
                arr[i][j] = (arr[i-1][j] + arr[i][j-1])%10_007;
            }
        }
        int sum = 1;
        for(int i=1; i<10 ; i++){
            sum += arr[n][i];
            sum %= 10_007;
        }
        System.out.println(sum);
    }
}