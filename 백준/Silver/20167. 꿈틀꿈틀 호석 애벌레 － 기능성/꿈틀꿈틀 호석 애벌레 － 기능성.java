import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static long K;
  public static long[] arr;
  public static long[] dp;
  public static ArrayList<ArrayList<long[]>> deps = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(dp[N]);
  }
  public static void input(BufferedReader br) throws Exception{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new long[N];
    dp = new long[N+1];
    for(int i = 0 ; i<=N ; i++){
      deps.add(new ArrayList<>());
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0 ; i<N ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
  }

  public static void pro(){
    int j =0;
    long sum = 0;
    for(int i=0 ; i< N; i++){
      while(j < N && sum < K){
        sum += arr[j];
        j++;
      }
      if(sum >= K){
        deps.get(j).add(new long[]{i, sum-K});
      }
      sum -= arr[i];
    }

    for(int i=1 ; i<=N ; i++){
      long curMax = 0;
      for(long[] dep : deps.get(i)){
        if(dep[0]==0){
          curMax = Math.max(curMax, dep[1]);
        }else{
          curMax = Math.max(curMax, dp[(int)dep[0]]+dep[1]);
        }
      }
      dp[i] =  Math.max(dp[i-1], curMax);
    }

  }
}