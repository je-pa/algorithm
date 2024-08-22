import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String s = str.replaceAll("pi", "1")
        .replaceAll("ka", "1")
        .replaceAll("chu", "1")
        .replaceAll("1", "");

    if(s.length() == 0){
      System.out.println("YES");
    }else{
      System.out.println("NO");
    }
  }

}