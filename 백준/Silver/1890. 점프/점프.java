import java.util.*;
import java.io.*;

class Main{
    static int[][] arr;
    static long[][] check;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        check = new long[N][N];
        for(int i=0 ; i<N; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        re();
        System.out.print(check[N-1][N-1]);
    }
    public static void re(){
        check[0][0]=1;
        for(int i=0; i<N ; i++){
            for(int j=0; j<N ; j++){
                int next= arr[i][j];
                if(next==0) continue;               
                if(next+j<N)check[i][j+next]+= check[i][j];
                if(next+i<N)check[i+next][j]+= check[i][j];
            }
        }
    }
}