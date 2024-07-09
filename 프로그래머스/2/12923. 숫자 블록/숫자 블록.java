import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

   //숫자 0이 적힌 블록들이 설치된 도로에 다른 숫자가 적힌 블록들을 설치
   //블록에 적힌 번호가 n 일때, 가장 첫 블록은 n*2 번째 위치에 설치, 그 다음은 n*3, ... 위치에 설치
   //기존에 설치된 블록은 빼고 새로운 블록을 집어 넣는다.
   //블록은 1이 적힌 블록부터 숫자를 1씩 증가시키며 순서대로 설치한다.
   //1이 적힌 블록은 2,3,4,5 ...인 위치에 우선 설치
   //그 후, 2가 적힌 블록은 4,6,8,10,...인 위치에 설치

   public static int[] solution(long begin, long end) {
      int[] answer = new int[(int)(end - begin) + 1];

      for (int i = (int)begin,idx = 0; i <= end; i++) {
         answer[idx++] = getMaxDivisorExceptMe(i);
      }

      return answer;
   }


   private static int getMaxDivisorExceptMe(int x) {
      if (x == 1) {
         return 0;
      }

      List<Integer> l = new ArrayList<>();

      for (int i = 2; i <= Math.sqrt(x); i++) {
         if (x % i == 0) {
            l.add(i);
            if (x / i <= 10_000_000) {
               return x/i;
            }
         }
      }

      if (!l.isEmpty()) {
         return l.get(l.size() - 1);
      }

      return 1;
   }

   // public static void main(String[] args) {
   //    System.out.println(Arrays.toString(solution(1, 10)));
   //    System.out.println(Arrays.toString(solution(2, 10)));
   // }
}
// class Solution {
//     public int[] solution(long begin, long end) {
        
//         int[] ch = new int[(int)end+1];
        
//         for(int i=2; i*2<ch.length ; i++){
//             if(ch[i]!=0) continue;
//             for(int j=i ; i*j>0 &&j*i<ch.length ; j++){
//                 if(i<j && j<=10_000_000){
//                     ch[i*j] = j;
//                 }
//             }
//         }
//         int[] result = new int[(int)end-(int)begin+1];
//         for(int i=(int)begin ; i<=end ; i++){
//             int num = ch[i];
//             result[i-(int)begin] = num==0 ? 1 : num;
//             // System.out.println(num+" :"+(i-(int)begin));
//         }
//         if(begin==1){
//             result[0] =0;
//         }
        
        
//         return result;
//     }
// }