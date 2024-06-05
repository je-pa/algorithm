import java.util.*;
import java.io.*;
public class Main {
    static int n,m,k,x;
    static int[] d;
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmkx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = nmkx[0];
        m = nmkx[1];
        k = nmkx[2];
        x = nmkx[3];

        d = new int[n+1];
        for(int i = 0 ; i<=n ; i++) {
            d[i] = -1;
            nodes.add(new ArrayList<>());
        }

        for(int i=0 ; i<m ; i++){
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            nodes.get(a).add(b);
        }
        d[x]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while (!q.isEmpty()){
            int now = q.remove();
            for(int i=0 ; i<nodes.get(now).size(); i++){
                int next = nodes.get(now).get(i);
                if(d[next]==-1){
                    d[next] = d[now]+1;
                    q.add(next);
                }
            }
        }
        boolean check = false;

        for(int i=1 ; i<=n ; i++){
//            System.out.print(d[i]+" ");//
            if(d[i]==k){
                check = true;
                System.out.println(i);
            }
        }

        if(!check) System.out.println(-1);
    }
}
