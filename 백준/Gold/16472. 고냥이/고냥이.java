import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char[] arr = br.readLine().toCharArray();
    int l = 0;
    int r = -1;
    int max = 0;
    Map<Character, Integer> map = new HashMap<>();
    while(r != arr.length){
      r++;
      if(r == arr.length) break;
      map.put(arr[r], map.getOrDefault(arr[r],0)+1);
      while(map.size()>n){
        map.put(arr[l], map.getOrDefault(arr[l],0)-1);
        if(map.get(arr[l])==0){
          map.remove(arr[l]);
        }
        l++;
      }
      max = Math.max(max, r-l+1);

    }
    System.out.println(max);
  }

}
