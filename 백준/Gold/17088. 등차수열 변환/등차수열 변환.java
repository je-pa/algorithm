import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int[] arr;
  static int[] ds = {-1, 0, 1};
  static int N;
  static int MAX = Integer.MAX_VALUE;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
  }

  static void pro() {
    if(arr.length < 3) {
      result = 0;
      return;
    }
    int[][] cal = new int[9][3];
    int n0 = arr[0];
    int n1 = arr[1];
    int idx = 0;
    for(int d0 : ds){
      int nn0 = n0 + d0;
      for(int d1 : ds){
        int nn1 = n1 + d1;
        cal[idx][0] = nn1 - nn0;
        cal[idx][1] = nn1;
        cal[idx][2] += Math.abs(d0) + Math.abs(d1);
        idx++;
      }
    }
    for(int i=2 ; i<N ; i++){
      int cur = arr[i];
      for(int calIdx = 0 ; calIdx < cal.length ; calIdx++){
        int[] c = cal[calIdx];
        int gap = c[0];
        if(gap == MAX) continue;
        boolean check = false;
        for(int d : ds){
          int next = cur + d;
          if(next - c[1] != gap) continue;
          check = true;
          c[1] = next;
          c[2] += Math.abs(d);
          break;
        }
        if(!check) c[0] = MAX;
      }
    }
    boolean check = false;
    result = MAX;
    for(int[] c : cal){
      if(c[0] == MAX) continue;
      result = Math.min(result, c[2]);
      check = true;
    }
    if(!check) result = -1;
  }
}
