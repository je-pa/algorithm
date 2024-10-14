import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    long min = Long.MAX_VALUE;
    Arrays.sort(arr);
    int[] result = new int[3];
    for(int i = 0; i < n-1; i++) {
      int l = i+1;
      int r = n-1;

      while(l < r){
        if(r == i) {
          r--;
          continue;
        }
        if(l == i){
          l++;
          continue;
        }
        long ai = arr[i];
        long al = arr[l];
        long ar = arr[r];
        if(Math.abs(ai + al + ar) < Math.abs(min)){
          result[0] = (int)ai;
          result[1] = (int)al;
          result[2] = (int)ar;
          min = ai + al + ar;
        }
        if(ai + al +ar < 0){
          l++;
        }else if(ai + al +ar > 0){
          r--;
        }else{
          break;
        }
      }
    }
    Arrays.sort(result);
    System.out.printf("%d %d %d",result[0], result[1], result[2]);
  }

}
