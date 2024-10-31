import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int K;
  public static int result = 0;
  public static int[] foods;
  public static int[] arr;
  public static int[] countArr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }
  public static void input(BufferedReader br) throws Exception{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    foods = new int[N];
    arr = new int[N];
    countArr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++){
      int k = Integer.parseInt(st.nextToken());
      foods[i] = k;
    }
  }

  public static void pro(){
    int i=0;
    int j=0;
    int sum = 0;
    int lastJ = -1;
    int lastSum = 0;
    while(i < N && j <= N){
      if(sum < K){
        if(j == N) break;
        sum += foods[j];
        j++;
      }else{
        if(i<=lastJ && lastJ < j){
          if(sum > lastSum){
            result += (sum-K);
            result -= (lastSum-K);
            lastJ = j-1;
            lastSum = sum;
          }
        }else{
          result += sum -K;
          lastJ = j-1;
          lastSum = sum;
        }
        sum -= foods[i];
        i++;
      }
    }
  }
}