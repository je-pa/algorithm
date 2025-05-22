import java.io.*;
import java.util.*;

public class Main {
  public static int L, C;
  public static char[] arr;
  public static boolean[] check;
  public static StringBuilder sb = new StringBuilder();
  public static Set<Character> set = new HashSet<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void pro()  {
    Arrays.sort(arr);
    for(int i= 0; i<arr.length; i++) {
      if(set.contains(arr[i])) check[i] = true;
    }
    dfs(arr, 0, "", 0, 0);
    System.out.println(sb);
  }
  static void dfs(char[] arr, int idx, String str, int m, int z) {
    if(str.length() == L){
      if(m >= 1 && z >= 2) sb.append(str).append("\n");
      return;
    }
    if(L - str.length() > C - idx){
      return;
    }
    for(int i = idx; i < C; i++) {
      dfs(arr, i+1, str + arr[i], check[i] ? m+1 : m, check[i] ? z : z+1);
    }
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');

    arr = new char[C];
    check = new boolean[C];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < C; i++) {
      arr[i] = st.nextToken().charAt(0);
    }
  }

}
