import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Main {
  static StringBuilder sb = new StringBuilder();
  static int[][] arr;
  static Map<Integer, Set<Integer>> cols;
  static Map<Integer, Set<Integer>> rows;
  static Map<Integer, Set<Integer>> secs;
  static boolean end = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  static void pro() {
    cols = new HashMap<Integer, Set<Integer>>();
    rows = new HashMap<Integer, Set<Integer>>();
    secs = new HashMap<Integer, Set<Integer>>();

    for(int i=0 ; i<9 ; i++){
      cols.put(i, new HashSet<Integer>());
      rows.put(i, new HashSet<Integer>());
      secs.put(i, new HashSet<Integer>());
      for(int j=1 ; j<=9 ; j++){
        cols.get(i).add(j);
        rows.get(i).add(j);
        secs.get(i).add(j);
      }
    }
    for(int i=0 ; i<9 ; i++){
      for(int j=0 ; j<9 ; j++){
        if(arr[i][j] == 0) continue;
        cols.get(j).remove(arr[i][j]);
        rows.get(i).remove(arr[i][j]);
        secs.get(i/3*3 + j / 3).remove(arr[i][j]);
      }
    }
    dfs(0);
    for(int i=0 ; i<9 ; i++){
      for(int j=0 ; j<9 ; j++){
        sb.append(arr[i][j]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
  static void dfs(int idx) {
    if(idx == 9*9){
      end = true;
      return;
    }
    int r = idx / 9 % 9;
    int c = idx % 9;
    int s = r / 3 * 3 + c / 3;

    if(arr[r][c] != 0){
      dfs(idx + 1);
      return;
    }
    for(int i=1 ; i<=9 ; i++){
      if(!cols.get(c).contains(i)) continue;
      if(!rows.get(r).contains(i)) continue;
      if(!secs.get(s).contains(i)) continue;
      arr[r][c] = i;
      cols.get(c).remove(i);
      rows.get(r).remove(i);
      secs.get(s).remove(i);
      dfs(idx + 1);
      if(end) return;
      arr[r][c] = 0;
      cols.get(c).add(i);
      rows.get(r).add(i);
      secs.get(s).add(i);
    }
  }
  private static void input(BufferedReader br) throws IOException {
    arr = new int[9][9];
    for(int i=0 ; i<9 ; i++) {
      String line = br.readLine();
      for(int j=0 ; j<9 ; j++) {
        arr[i][j] = line.charAt(j) - '0';
      }
    }
  }

}

