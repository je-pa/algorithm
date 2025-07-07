import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
  static int N, M;
  static int[] a, b;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  private static void pro() {
    Queue<Integer> word = new ArrayDeque<>();

    int ia = 0;
    int ib = 0;
    while( ia<N && ib<M ) {
      int result = -1;
      for(int i=ia ; i<N ;i++){
        for(int j=ib ; j<M ;j++){
          if(a[i]==b[j]) result = Math.max(result, a[i]);
        }
      }
      if(result == -1) break;
      word.add(result);
      while(a[ia++]!=result) continue;
      while(b[ib++]!=result) continue;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(word.size()).append("\n");
    while(!word.isEmpty()) {
      sb.append(word.poll()).append(" ");
    }
    System.out.println(sb);
  }

  private static void input(BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());
    a = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    M = Integer.parseInt(br.readLine());
    b = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }
  }
}

