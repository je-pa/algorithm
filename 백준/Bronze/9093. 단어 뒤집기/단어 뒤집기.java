import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for(int i=0 ; i<N ; i++){
            String sentence = br.readLine()+" ";
            char[] strArr = sentence.toCharArray();
            for(char c : strArr){
                if(c==' '){
                    while(!stack.empty()){
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                }else{
                    stack.push(c);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
