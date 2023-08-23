import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<len ; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(leastCommonMultiple(arr[0],arr[1],greatestCommonFactor(arr[0],arr[1]))).append('\n');
        }
        System.out.println(sb);
    }
    static int greatestCommonFactor(int x, int y){
        if(x == 0 ) return y;
        else return greatestCommonFactor(y%x,x);
    }
    static int leastCommonMultiple(int x, int y , int gcf){
        return x/gcf*y;
    }
}
