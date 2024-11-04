import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
  public static ArrayList<ArrayList<Integer>> leafs = new ArrayList<>();
  public static int turnCount = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    findL(1, -1,0);
    if(turnCount %2 == 0){
      System.out.println("No");
    }else{
      System.out.println("Yes");
    }
  }
  public static void input(BufferedReader br) throws IOException{
    N = Integer.parseInt(br.readLine());
    for(int i = 0; i <= N; i++){
      lists.add(new ArrayList<>());
    }
    for(int i=1; i<N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      lists.get(a).add(b);
      lists.get(b).add(a);
    }
  }

  public static void findL(int num, int pre, int dep){
    ArrayList<Integer> list = lists.get(num);
    if(list.size() ==1 && num != 1){
      turnCount += dep;
      return;
    }
    for(int i : list){
      if(pre == i) continue;
      findL(i, num, dep+1);
    }
  }
}