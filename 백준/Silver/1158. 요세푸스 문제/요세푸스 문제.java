import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1])-1; // K-1번째 ( 0부터 시작하는 것을 고려)

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1 ; i<=N ; i++){
            list.add(i);
        }
        int index = K;
        StringBuilder sb = new StringBuilder("<"+list.remove(index));

        while(!list.isEmpty()){
            index = (index + K)%list.size();
            sb.append(", ").append(list.remove(index));
        }
        sb.append(">");
        System.out.println(sb);
    }

}
