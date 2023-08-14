import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<N ; i++){
            int key = scan.nextInt();
            map.put(key, map.containsKey(key) ? map.get(key)+1 : 1);
            
        }
        int v = scan.nextInt();
        System.out.print(map.containsKey(v) ? map.get(v) : 0);
    }
}