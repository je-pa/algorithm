import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int[][] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N][2];
    for(int i=0 ; i<N ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[i][0] = a;
      arr[i][1] = b;
    }
  }

  static void pro() {
    dfs(0);
  }

  static void dfs(int idx){
    while(idx < N && arr[idx][0] <= 0) idx++;
    
    for(int i=0 ; i<N ; i++){
      if(idx == N) {
        break;
      }
      if(idx == i) continue;
      if(arr[i][0] <= 0) continue;
      arr[idx][0] -= arr[i][1];
      arr[i][0] -= arr[idx][1];
      dfs(idx+1);
      arr[idx][0] += arr[i][1];
      arr[i][0] += arr[idx][1];
    }
    int count =0;
    for(int i=0 ; i<N ; i++){
      if(arr[i][0] <= 0){
        count++;
      }
    }
    result = Math.max(result, count);
  }


}