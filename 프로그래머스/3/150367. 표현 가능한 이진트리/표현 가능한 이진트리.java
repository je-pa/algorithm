import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int[] result = new int[numbers.length];
        for(int i = 0 ; i<numbers.length ; i++){
            result[i] = pro(numbers[i]) ? 1 : 0;
        }
        return result;
    }
    
    boolean pro(long n){
        String s2 = Long.toString(n, 2);
        int h = getH(s2);
        int size = (int)Math.pow(2,h) -1;
        StringBuilder sb = new StringBuilder();
        int s2Size = s2.length();
        for(int i=0 ; i<size-s2Size ; i++){
            sb.append(0);
            
        }
        for(int i=0 ; i<s2Size ; i++){
            sb.append(s2.charAt(i));
        }
        return dfs(sb.toString());
    }
    
    int getH(String s){
        int k = 0;
        int size = s.length();
        while(Math.pow(2, k) <= size){
            k++;
        }
        return k;
    }
    
    boolean dfs(String str){
        int l = str.length();
        if(l == 1) return true;
        if(str.charAt(l/2) == '0'){
            if(check1(str)) return false;
        }
        return dfs(str.substring(0, l/2)) && dfs(str.substring(l/2+1, l));
    }
    
    boolean check1(String str){
        int l = str.length();
        for(int i=0 ; i<l ; i++){
            if(i == l/2) continue;
            if(str.charAt(i) == '1') return true;
        }
        return false;
    }
}