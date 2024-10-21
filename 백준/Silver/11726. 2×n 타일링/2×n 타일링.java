import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    int[] dp = new int[1001];
    dp[1]= 1;
    dp[2]= 2;
    for(int i=3;i<1001;i++){
      dp[i] = (dp[i-1]+dp[i-2])%10007;
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.println(dp[n]);
  }
}