import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000000000 + 5;
    static final int MAX_N = 1000000 + 5;
    static int[] Happy = new int[MAX_N];
    static int[] Unhappy = new int[MAX_N];
    static int[] Min_Happy_Young = new int[MAX_N];
    static int[] Max_Happy_Old = new int[MAX_N];
    static int[] Max_Unhappy_Young = new int[MAX_N];
    static int[] Min_Unhappy_Old = new int[MAX_N];
    static int N;

    public static int Find_ans(int L, int R) {
        int ret = -1;
        for (int i = R; i >= 0; i--) {
            boolean chk1 = false;
            boolean chk2 = false;
            if (Min_Happy_Young[i] > Max_Happy_Old[i + 1])
                chk1 = true;

            if (Max_Unhappy_Young[i] < Min_Unhappy_Old[i + 1])
                chk2 = true;

            if (chk1 && chk2) {
                ret = Math.max(ret, i);
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int ans = -1;
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            Happy[i] = a;
            Unhappy[i] = b;
        }

        int Min = INF;
        int Max = -1;
        for (int i = 1; i <= N; i++) {
            if (Happy[i] != 0 && Happy[i] < Min) {
                Min = Happy[i];
            }
            if (Unhappy[i] != 0 && Unhappy[i] > Max) {
                Max = Unhappy[i];
            }
            Min_Happy_Young[i] = Min;
            Max_Unhappy_Young[i] = Max;
        }

        Min = INF;
        Max = -1;
        for (int i = N; i >= 0; i--) {
            if (Unhappy[i] != 0 && Min > Unhappy[i])
                Min = Unhappy[i];
            if (Happy[i] != 0 && Max < Happy[i])
                Max = Happy[i];
            Min_Unhappy_Old[i] = Min;
            Max_Happy_Old[i] = Max;
        }

        System.out.println(Find_ans(1, N - 1));
    }
}
