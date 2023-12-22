import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = null;
        while((str=br.readLine()) != null){
            int[] count = new int[4];
            for(char c : str.toCharArray()){
                if(c>='a'&&c<='z'){
                    count[0]++;
                }else if(c>='A'&&c<='Z'){
                    count[1]++;
                }else if(c==' '){
                    count[3]++;
                }else{
                    count[2]++;
                }
            }
            for(int i : count){
                sb.append(i).append(' ');
            }sb.append('\n');
        }
        System.out.println(sb);
    }
}
