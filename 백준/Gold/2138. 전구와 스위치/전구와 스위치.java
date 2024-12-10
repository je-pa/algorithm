import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static boolean[] arr1;
  static boolean[] goal;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr1 = new boolean[N];
    goal = new boolean[N];
    String s1 = br.readLine();
    String s2 = br.readLine();
    for(int i=0 ; i < N ; i++){
      arr1[i] = s1.charAt(i) == '1';
      goal[i] = s2.charAt(i) == '1';
    }

  }

  static void pro() {
    boolean[] now1 = new boolean[N];//0번째 누름
    boolean[] now2 = new boolean[N];
    for(int i=0 ; i<N ; i++){
      now1[i] = arr1[i];
      now2[i] = arr1[i];
    }
    now1[0] = !now1[0];
    now1[1] = !now1[1];
    int count1 = 1;
    int count2 = 0;
    for(int i=0 ; i<N-1 ; i++){
      if(goal[i] != now1[i]){
        click(now1, i+1);
        count1 ++;
      }
      if(goal[i] != now2[i]){
        click(now2, i+1);
        count2++;
      }
    }

    if(now1[N-1] != goal[N-1] && now2[N-1] != goal[N-1]) {
      result = -1;
      return;
    }
    
    if(now1[N-1] == goal[N-1]) result = count1;
    if(now2[N-1] == goal[N-1]) result = count2;
  }

  static void click(boolean[] arr, int i){
    arr[i] = !arr[i];
    if(i-1>0) arr[i-1] = !arr[i-1];
    if(i+1<N) arr[i+1] = !arr[i+1];
  }
}