import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(make1(N,0));
    }

    public static int make1(int n, int count){
        int a, b;
        if(n==0 || n==1){
            return count;
        }
        a = make1(n/3, count+1 + n%3);

        b = make1(n/2, count+1+ n%2);

        return Math.min(a,b);
    }
}
