import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static StringBuilder result = new StringBuilder();
  static PriorityQueue<Info> pq = new PriorityQueue<>((x,y) -> {
    if(x.age!=y.age) return Integer.compare(x.age, y.age);
    return Integer.compare(x.num, y.num);
  });
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();

      pq.add(new Info(age, name, i));
    }
  }

  static void pro() {
    while(!pq.isEmpty()){
      Info info = pq.poll();
      result.append(info.age).append(" ").append(info.name).append("\n");
    }
  }
  static class Info{
    int age;
    String name;
    int num;
    Info(int age, String name, int num){
      this.age =age;
      this.name = name;
      this.num = num;
    }
  }
}
