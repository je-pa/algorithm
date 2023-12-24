import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];
        boolean[] visit = new boolean[200_001];
        int[] parent = new int[200_001];
        int[] count = new int[200_001];
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(n, 0));
        int resultL=0;

        while (!queue.isEmpty()){
            Pair cur = queue.remove();
            int curK = cur.getKey();
            int curL = cur.getLength();
            visit[curK] =true;
            if(curK == k){
                resultL = curL;
                break;
            }
            if(curK-1 >=0 && !visit[curK-1]){
                int nextK = curK -1;
                parent[nextK] = curK;
                count[nextK] = curL+1;
                queue.add(new Pair(nextK, curL+1));
                visit[nextK] =true;
            }
            if(curK+1 < visit.length && !visit[curK+1]){
                int nextK = curK +1;
                parent[nextK] = curK;
                count[nextK] = curL+1;
                queue.add(new Pair(nextK, curL+1));
                visit[nextK] =true;
            }
            if(curK*2 < visit.length && !visit[curK*2]){
                int nextK = curK *2;
                parent[nextK] = curK;
                count[nextK] = curL+1;
                queue.add(new Pair(nextK, curL+1));
                visit[nextK] =true;
            }
        }
        int back = k;
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        while(back != n){
            stack.push(parent[back]);
            back = parent[back];
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        System.out.println(resultL);
        System.out.println(sb);
    }
}

class Pair {
    private int key;
    private int length;

    public Pair(int key, int length) {
        this.key = key;
        this.length = length;
    }

    public int getKey() {
        return key;
    }

    public int getLength(){
        return length;
    }
}