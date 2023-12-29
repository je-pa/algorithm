import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int N = 0;
    static int[] arr;
    static int REMOVE = 0;
    static int ROOT = 0;
    static int count = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        REMOVE = Integer.parseInt(br.readLine());

        for(int i=0 ; i<N ; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0 ; i<N ; i++){
            if(arr[i]==-1){
                ROOT = i;
            }
            if(i==REMOVE) continue;
            if(arr[i]==-1) continue;
            list.get(arr[i]).add(i);
        }
        if(ROOT == REMOVE){
            System.out.println(0);
            return;
        }
        dfs(ROOT);
        System.out.println(count);
    }
    static void dfs(int index){
        if(list.get(index).isEmpty()) {
            count++;
            return;
        }
        for(int i : list.get(index)){
            dfs(i);
        }
    }
}
