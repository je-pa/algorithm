import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Map<String, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      String[] arr = br.readLine().split("\\.");
      map.put(arr[1], map.getOrDefault(arr[1], 0)+1);
    }
    StringBuilder sb = new StringBuilder();
    for(String key : map.keySet()){
      sb.append(key)
          .append(" ")
          .append(map.get(key))
          .append("\n");
    }
    System.out.println(sb);
  }


}
