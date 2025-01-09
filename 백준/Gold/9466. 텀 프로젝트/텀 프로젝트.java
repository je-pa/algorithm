import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[] arr;
  static boolean[] done;
  static boolean[] visit;
  static int count;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      input(br);
      pro();
    }
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    count = 0;
    arr = new int[N+1];
    done = new boolean[N+1];
    visit = new boolean[N+1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
  }
  static void pro() {
    int result = N;
    for(int i=1 ; i<=N ; i++){
      count =0;
      if(!done[i]) dfs(i);
      result -= count;
    }
    System.out.println(result);
  }
  public static void dfs(int n){
    // 이미 방문 했을 때!
    if(visit[n]){
      done[n] = true;    // 팀 편성 완료했다고 처리
      count++;    // 팀 편성 완료 인원 증가
    }else{
      // 방문하지 않았을 때 -> 방문 처리!
      visit[n] = true;
    }

    // 다음 학생이 팀 결성을 아직 못했을 경우
    if(!done[arr[n]]){
      dfs(arr[n]);
    }

    visit[n] = false;
    done[n] = true;
  }
}
