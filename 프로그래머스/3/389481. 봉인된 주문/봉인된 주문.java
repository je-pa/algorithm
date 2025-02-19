import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        long[] arr = new long[bans.length];
        for(int i =0 ; i<bans.length ; i++){
            arr[i] = isSmallOrE(bans[i]);
        }
        Arrays.sort(arr);
        Set<Long> set = new HashSet<>();
        for(long l : arr){
            if(set.contains(n)) n++;
            if(l <= n){
                n++;
            }else{
                set.add(l);
            }
        }
        while(set.contains(n)){
            n++;
        }
        return to(n);
    }
    String to(long n){
        StringBuilder sb = new StringBuilder();
        while(true){
            sb.append((char)('a'+ (long)(n%(long)26 == 0 ? 26 : n%(long)26) - (long)1));
            n=(n-1)/(long)26;
            if(n==0) break;
        }
        return sb.reverse().toString();
    }
    
    long isSmallOrE(String ban){
        char[] cs = ban.toCharArray();
        long len = ban.length();
        long count = 0;
        for(int i=0 ; i<len ; i++){
            count += (long)Math.pow(26, len-(long)i-(long)1)*(long)(cs[i] - 'a' + (long)1);
            count = Math.min((long)Math.pow(10,15), count);
        }
        return count;
    }
}