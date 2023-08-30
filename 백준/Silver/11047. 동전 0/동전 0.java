// N , M
import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scan  = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<N ; i++){
            list.add(scan.nextInt());
        }
        int count=0;
        for(int i=list.size()-1 ; i>=0 ; i--){
            int k = list.get(i);
            if(M<k) continue;
            count += (M/k);
            M%=k;
            if(M==0){break;}
        }
        System.out.print(count);
    }
}