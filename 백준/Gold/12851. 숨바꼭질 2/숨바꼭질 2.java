import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
    int n=Integer.parseInt(tokenizer.nextToken());
    int k=Integer.parseInt(tokenizer.nextToken());
    if(n == k){
      System.out.println(0);
      System.out.println(1);
      return;
    }
    LinkedList<Info> list = new LinkedList<>();
    int[] arr = new int[Math.max(n, k)*2];
    list.add(new Info(n, 0));
    int minT = 0;
    int count = 0;
    while(!list.isEmpty()){
      Info info = list.poll();
      int cur = info.point;
      int nextT = info.time+1;
      if(minT != 0 && minT < nextT){
        continue;
      }

      int minus = cur - 1;
      int plus = cur + 1;
      int gob = cur * 2;

      if(minus >= 0 && (arr[minus] >= nextT || arr[minus] == 0)){
        if(minus == k){
          count++;
          minT = nextT;
          continue;
        }
        list.add(new Info(minus, nextT));
        arr[minus] = nextT;
      }
      if(plus < arr.length && (arr[plus] >= nextT || arr[plus] == 0)){
        if(plus == k){
          count++;
          minT = nextT;
          continue;
        }
        list.add(new Info(plus, nextT));
        arr[plus] = nextT;
      }
      if(gob < arr.length && (arr[gob] >= nextT || arr[gob] == 0)){
        if(gob == k){
          count++;
          minT = nextT;
          continue;
        }
        list.add(new Info(gob, nextT));
        arr[gob] = nextT;
      }

    }

    System.out.println(minT);
    System.out.println(count);
  }
  static class Info{
    int point;
    int time;

    public Info(int point, int time) {
      this.point = point;
      this.time = time;
    }
  }

}
// 10 20 19 18 17
// 6 7 8 16 17
// 4 8 16 17
// 10 9 18 17

// 1 4 -> 2 2
// 2 4
