import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int max = -1_000_000;
        int min = 1_000_000;
        int n = scan.nextInt();
        for(int i = 0 ; i < n ; i++)
        {
            int x= scan.nextInt();
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        System.out.println(min + " " + max);
    }
}