import java.util.*;
import java.io.*;

class Main{
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        visited = new boolean[N+1];
        parent = new int[N+1];
        
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i=0; i<N+1 ; i++){
            lists.add(new ArrayList<>());
        }
        for(int i=0 ; i<N-1 ; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            
            lists.get(a).add(b);
            lists.get(b).add(a);
        }
        
        dfs(1, lists);
        
        for(int i=2;i<N+1 ; i++){
            System.out.println(parent[i]);
        }
    }
    public static void dfs(int index, ArrayList<ArrayList<Integer>> lists){
        visited[index] = true;
        for(int i : lists.get(index)){
            if(!visited[i]){
                parent[i] = index;
                dfs(i,lists);
            }
        }
    }
    
}