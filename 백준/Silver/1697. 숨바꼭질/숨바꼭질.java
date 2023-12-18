import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = nk[1];
        boolean[] visited = new boolean[200_001];
        Queue<Integer[]> queue = new LinkedList<>();

        queue.add(new Integer[]{nk[0],0});
        Integer count =0;
        while(!queue.isEmpty()){
            Integer[] xc = queue.remove();
            Integer n = xc[0];
            visited[n] = true;
            count = xc[1];
            if(n==k){
                break;
            }
            if (n-1>=0 && !visited[n-1])
            {
                queue.add(new Integer[]{n-1,count+1});

            }
            if (n+1 <= 100000 && !visited[n+1])
            {
                queue.add(new Integer[]{n+1,count+1});

            }
            if (2*n <= 100000 && !visited[2*n])
            {
                queue.add(new Integer[]{n*2,count+1});

            }
        }
        System.out.println(count);
    }
}