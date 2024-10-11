import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] trees = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      trees[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(two(trees, m));
  }
  public static int two(int[] trees, int m) {
    int left = 0;
    int right = Integer.MAX_VALUE;
    while(left <= right){
      int mid = (left + right) / 2;
      long sum = 0;
      for(int i = 0; i < trees.length; i++){
        sum += Math.max(0, trees[i] - mid);
      }

      if(sum >= m){
        left = mid + 1;
      }else{
        right = mid - 1;
      }
    }
    return right;
  }

}
