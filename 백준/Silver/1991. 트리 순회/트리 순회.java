import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String, Node> map = new HashMap<>();
    static int N = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i =0  ; i<N ; i++){
            String[] arr = br.readLine().split(" ");
            map.put(arr[0],new Node(arr[0], arr[1], arr[2]));
        }
        rootLeftRight("A");
        sb.append("\n");
        leftRootRight("A");
        sb.append("\n");
        leftRightRoot("A");
        System.out.println(sb);
    }

    static void rootLeftRight(String cur){
        Node node = map.get(cur);
        sb.append(node.root);
        if(!node.left.equals(".")){
            rootLeftRight(node.left);
        }
        if(!node.right.equals(".")){
            rootLeftRight(node.right);
        }
    }
    static void leftRootRight(String cur){
        Node node = map.get(cur);
        if(!node.left.equals(".")){
            leftRootRight(node.left);
        }
        sb.append(node.root);
        if(!node.right.equals(".")){
            leftRootRight(node.right);
        }
    }
    static void leftRightRoot(String cur){
        Node node = map.get(cur);
        if(!node.left.equals(".")){
            leftRightRoot(node.left);
        }
        if(!node.right.equals(".")){
            leftRightRoot(node.right);
        }
        sb.append(node.root);
    }

}
class Node{
    String root;
    String left;
    String right;

    public Node(String root, String left, String right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }
}
