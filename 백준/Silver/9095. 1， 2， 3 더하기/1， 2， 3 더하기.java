import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    int[] dp = new int[12];
    dp[1]= 1;
    dp[2]= 2;
    dp[3]= 4;
    for(int i=4;i<12;i++){
      dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<n;i++){
      sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
    }
    System.out.println(sb);
  }
}