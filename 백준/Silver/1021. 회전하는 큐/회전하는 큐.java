import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) throws Exception{
        LinkedList<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1; i<=arr[0] ; i++){
            list.add(i);
        }

        for(int i : arr2){
            int size = list.size();
            int index = list.indexOf(i);
            if(index <= size/2){
                while(list.peek()!=i){
                    list.add(list.remove());
                    count++;
                }
            }else{
                while(list.peek()!=i){
                    list.addFirst(list.removeLast());
                    count++;
                }
            }
            list.remove();
        }
        System.out.println(count);
    }
}
