import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NM = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());
        int[][] arr = new int[N][M];
        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<M ; j++){
                 arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int K = Integer.parseInt(br.readLine());
        int[][] arr2 = new int[K][4];
        for(int i=0 ; i<K ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<4 ; j++){
                 arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0 ; i<K ; i++){
            int sum = 0;
            for(int j=arr2[i][0]-1 ; j<arr2[i][2] ; j++){
                for(int z=arr2[i][1]-1 ; z<arr2[i][3] ; z++){
                    sum+=arr[j][z];
                }
            }
            System.out.println(sum);
        }
    }
}