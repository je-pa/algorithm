import java.io.*;
import java.util.*;

public class Main {
    static int N, result;		// 플레이어 수, 정답
    static int[][] player;		// 플레이어 능력치
    static boolean[] visit;		// 부분집합을 구하기 위한 방문처리 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        player = new int[N][N];

        // 플레이어 능력치 저장
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
        result = Integer.MAX_VALUE;
        visit = new boolean[N];
        solve(0);
        System.out.println(result);
    }
	
    // 부분집합 찾는 함수
    static void solve(int cnt){
    	// 부분집합 뽑았을 때,
        if(cnt == N){
            int start = 0;
            int link = 0;
            // 같은 팀원들끼리 능력치 합산
            for(int i = 0; i<N; i++){
                for(int j = i+1; j<N; j++){
                    if(visit[i] != visit[j]) continue;
                    if (visit[i])
                        start += player[i][j] + player[j][i];
                    else
                        link += player[i][j] + player[j][i];
                }
            }
            // 두 팀의 능력치 차이
            int diff = Math.abs(start - link);
            if(diff < result) result = diff;

            return;
        }

        visit[cnt] = true;
        solve(cnt+1);
        visit[cnt] = false;
        solve(cnt+1);
    }
}