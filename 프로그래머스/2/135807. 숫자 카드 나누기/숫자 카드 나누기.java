import java.util.Arrays;
class Solution {
    public static int solution(int[] arrayA, int[] arrayB) {
    int answer = 0;
    int aMin = Arrays.stream(arrayA).min().getAsInt();
    int bMin = Arrays.stream(arrayB).min().getAsInt();
    int aGcd = gcd(arrayA[0], aMin);
    for(int i=1 ;i< arrayA.length ; i++){
      aGcd = gcd(arrayA[i], aGcd);
      if(aGcd == 1) break;
    }
    int bGcd = gcd(arrayB[0], bMin);
    for(int i=1 ;i< arrayB.length ; i++){
      bGcd = gcd(arrayB[i], bGcd);
      if(bGcd == 1) break;
    }
    if(aGcd == bGcd) return 0;

    boolean checkA = false;
    for(int i=0 ; i<arrayB.length ; i++){
      if(arrayB[i]%aGcd ==0) {
        checkA = true;
        break;
      }
    }
    boolean checkB = false;
    for(int i=0 ; i<arrayA.length ; i++){
      if(arrayA[i]%bGcd ==0) {
        checkB = true;
        break;
      }
    }
    if(!checkA && !checkB){
      return Math.max(aGcd, bGcd);
    }else if(!checkA){
      return aGcd;
    }else if(!checkB){
      return bGcd;
    }

    return 0;
  }
    public static int gcd(int a, int b){
    if(b==0) return a;
    return gcd(b, a%b);
  }
}