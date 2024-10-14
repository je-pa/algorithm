import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char[] arr = br.readLine().toCharArray();
    int l = 0;
    int r = 0;
    int max = 0;
    Map<Character, Integer> map = new HashMap<>();
    while(r != arr.length){
      map.put(arr[r], map.getOrDefault(arr[r],0)+1);
      while(map.size()>n){
        map.put(arr[l], map.getOrDefault(arr[l],0)-1);
        if(map.get(arr[l])==0){
          map.remove(arr[l]);
        }
        l++;
      }
      max = Math.max(max, r-l+1);
      r++;
    }
    System.out.println(max);
  }

}
