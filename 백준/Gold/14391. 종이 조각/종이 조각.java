import java.io.*;
import java.util.*;
public class Main {

    public static int MAX = -1;
    public static int N;
    public static int M;
    public static int[][] numArr;
    public static boolean[][] sliceArr;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0이면 가로, 1이면 세로
        String line = br.readLine();
        String[] split = line.split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        numArr = new int[N][M];
        sliceArr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            char[] charArray = line1.toCharArray();
            for (int j = 0; j < M; j++) {
                numArr[i][j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
        }

        dfs(0, 0);

        bw.write(MAX + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    // 종이를 조각내는 경우의 수를 구하는 함수
    public static void dfs(int x, int y) {
        if (x == N) {
            // 모든 종이를 다 조각냈을 때
            sum();
            return;
        }
        if (y == M) {
            // 다음 행으로 이동
            dfs(x + 1, 0);
            return;
        }
        // 가로로 잘랐을 때
        sliceArr[x][y] = true;
        dfs(x, y + 1);
        // 세로로 잘랐을 때
        sliceArr[x][y] = false;
        dfs(x, y + 1);
    }

    // 조각난 종이의 합 구하는 함수
    public static void sum() {
        int result = 0;
        int temp;
        // 가로로 자른 종이들 합 구하기
        for (int i = 0; i < N; i++) {
            temp = 0;
            for (int j = 0; j < M; j++) {
                // 가로로 자른 종이일 때
                if (sliceArr[i][j]) {
                    temp *= 10;
                    temp += numArr[i][j];
                }
                // 가로로 자른 종이가 아닐때
                else {
                    // 전에 구한 가로로 자른 종이의 합을 최종 합 더해줌
                    result += temp;
                    // 다시 가로 종이의 합을 0으로 초기화
                    temp = 0;
                }
            }
            result += temp;
        }
        // 세로로 자른 종이들 합 구하기
        for (int i = 0; i < M; i++) {
            temp = 0;
            for (int j = 0; j < N; j++) {
                // 세로로 자른 종이일 때
                if (!sliceArr[j][i]) {
                    temp *= 10;
                    temp += numArr[j][i];
                }
                // 세로로 자른 종이가 아닐때
                else {
                    // 전에 구한 세로로 자른 종이의 합을 최종 합 더해줌
                    result += temp;
                    // 다시 세로 종이의 합을 0으로 초기화
                    temp = 0;
                }
            }
            result += temp;
        }
        MAX = Math.max(MAX, result);
    }
}