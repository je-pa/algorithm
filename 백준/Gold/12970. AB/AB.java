import java.io.*;
import java.util.*;

public class Main {
  static StringBuilder result = new StringBuilder();
  static int N;
  static int M;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
  }

  static void pro() {
    int k = 0;
    for(int i=1 ; i<N/2+1; i++){
      int cal = (N-i) * i;
      if(M <= cal) {
        k = i;
        break;
      }
    }
    if(k == 0){
      result.append(-1);
       return;
    }
    int div = M/k;
    int per = M%k;

    LinkedList<Character> list = new LinkedList<>();
    for(int i=0 ; i< div ; i++) list.add('B');
    for(int i=0 ; i< k - per ; i++) list.add('A');
    if(per > 0) list.add('B');
    for(int i=0 ; i< per ; i++) list.add('A');
    while(list.size() < N) list.add('B');
    while(!list.isEmpty()){
      result.append(list.removeLast());
    }
  }

}