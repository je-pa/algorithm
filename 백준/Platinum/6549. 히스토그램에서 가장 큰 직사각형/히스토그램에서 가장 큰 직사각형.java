import java.util.*;
import java.io.*;
class Main {
  static Stack<long[]> stack;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      String[] str = br.readLine().split(" ");
      if("0".equals(str[0])) {
        break;
      }

      long answer = ract(str);
      bw.write(String.valueOf(answer));
      bw.write("\n");

    }

    bw.flush();
    bw.close();
  }

  public static long ract(String[] str) {
    long answer = 0;
    stack = new Stack<>();
    stack.push(new long[]{(long)1, Long.parseLong(str[1])}); // 시작 최대 높이 저장

    for(int i=2; i<str.length; i++) {
      long[] pre = stack.peek();
      long now = Long.parseLong(str[i]);

      if(pre[1] > now) {
        long lastIdx = 0;
        while(!stack.isEmpty() && stack.peek()[1] > now) {
          long[] tmp = stack.pop();
          answer = Math.max(answer, (i-tmp[0])*tmp[1]);
          lastIdx = tmp[0];
        }
        if(stack.isEmpty() || stack.peek()[1] < now) {
          stack.push(new long[]{lastIdx, now});
        }
      }else if(pre[1] < now){ // pre 보다 크다면 푸시
        stack.push(new long[]{(long)i, now});
      }
    }

    while(!stack.isEmpty()) {
      long[] remain = stack.pop();
      answer = Math.max(answer, (str.length-remain[0])*remain[1]);
    }
    return answer;
  }
}