import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Stack<Integer>> arrayList = new ArrayList<>();
        for(int i=0 ; i<4 ; i++){
            arrayList.add(new Stack<>());
            arrayList.get(i).push(0);
        }

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<5 ;j++){
                if(j==4) {
                    System.out.println("NO");
                    return;
                }
                Stack<Integer> stack = arrayList.get(j);
                if(arr[i]>stack.peek()){
                    stack.push(arr[i]);
                    break;
                }
            }
        }
        System.out.println("YES");
    }
}
