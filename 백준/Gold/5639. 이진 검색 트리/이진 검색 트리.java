import java.io.*;
import java.util.*;

public class Main {
  static StringBuilder result= new StringBuilder();
  static Node root;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    root = new Node(Integer.parseInt(br.readLine()));
    String input;
    while ((input = br.readLine()) != null) { // EOF가 올 때까지 반복, Ctrl+D
      root.add(new Node(Integer.parseInt(input)));
    }
  }

  static void pro() {
    root.lrc();
  }
  static class Node{
    Node l;
    Node r;
    int c;
    Node(int c){
      this.c = c;
    }
    void add(Node n){
      if(c > n.c){
        if(l == null){
          l = n;
          return;
        }
        l.add(n);
        return;
      }
      if(r == null){
        r = n;
        return;
      }
      r.add(n);
    }
    void lrc(){
      if(l != null){
        l.lrc();
      }
      if(r != null){
        r.lrc();
      }
      result.append(c).append("\n");
    }
  }
}
