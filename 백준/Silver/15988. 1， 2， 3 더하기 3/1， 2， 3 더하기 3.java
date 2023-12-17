import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] o = new int[1_000_001];
        o[1]=1;
        o[2]=2;
        o[3]=4;
        for(int i=4; i<o.length ; i++){
            o[i]=((o[i-3]+o[i-2])%1_000_000_009+o[i-1])%1_000_000_009;
        }
        for(int i=0 ; i<n ; i++){
            int x = scan.nextInt();
            System.out.println(o[x]);
        }
    }
}
