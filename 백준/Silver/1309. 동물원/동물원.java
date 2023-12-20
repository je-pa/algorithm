import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2])%9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2])%9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1])%9901;
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum % 9901);
    }
}
