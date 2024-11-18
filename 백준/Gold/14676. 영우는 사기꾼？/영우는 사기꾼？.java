import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int M;
  static int K;
  static int MOD = 1_000_000_009;
  static int[] bcs;
  static int[] in;
  static String LI = "Lier!";
  static String KI = "King-God-Emperor";


  static List<List<Integer>> lists = new ArrayList<>();

  static StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
//    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    in = new int[N+1];
    bcs = new int[N+1];
    for(int i=0 ; i<= N  ; i++){
      lists.add(new ArrayList<>());
    }
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      lists.get(a).add(b);
      in[b]+=1;
    }
    for(int i=0 ; i< K  ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if(a == 1){
        if(in[b] != 0){
          System.out.println(LI);
          return;
        }

        bcs[b]+=1;
        if(bcs[b] ==1) {
          for(int j : lists.get(b)){
            in[j] -= 1;
          }
        }
      }else{
        if(bcs[b] <= 0){
          System.out.println(LI);
          return;
        }
        bcs[b] -= 1;
        if(bcs[b] == 0){
          for(int j : lists.get(b)){
            in[j] += 1;
          }
        }
      }
    }
    System.out.println(KI);
  }

  static void pro() {

  }
}
