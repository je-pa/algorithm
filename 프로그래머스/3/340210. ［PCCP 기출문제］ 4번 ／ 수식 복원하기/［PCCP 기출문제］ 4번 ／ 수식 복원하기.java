import java.util.*;
class Solution {
    int max = 0;
    int ok = 0;
    ArrayList<String> result = new ArrayList<>();
    public String[] solution(String[] expressions) {
        for(String str : expressions){
            start(str);
        }
        String[] answer = new String[result.size()];
        for(int i=0 ; i<result.size(); i++){
            String str = result.get(i);
            answer[i] = change(str);
        }
        return answer;
    }
    // ? 문제 풀기
    String change(String str){
        String[] ss = str.split(" ");
        int A = Integer.parseInt(ss[0]);
        int B = Integer.parseInt(ss[2]);
        char cal = ss[1].charAt(0);

        if(ok != 0){
            // System.out.println(ok);
            int result10 = calc(A, B, cal, ok);
            int result = change(result10, ok);
            return new StringBuilder().append(A).append(" ").append(cal).append(" ")
                .append(B).append(" ").append("=").append(" ").append(result).toString();
        }
        int start = Math.max(2, max);
        // AB 10진법 계산 후 원래 진법으로 돌림
        int r = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = start; i<10 ; i++){
            r = change(calc(A, B, cal, i),i);
            set.add(r);
            if(set.size()>1) break;
        }
        return new StringBuilder().append(A).append(" ").append(cal).append(" ")
                .append(B).append(" ").append("=").append(" ").append(set.size()>1 ? "?" : r).toString();
    }
    
    void start(String str)    {
        if(str.contains("X")){
            containX(str);
        }else{
            no(str);
        }
    }
    
    void containX(String str){
        result.add(str);
        if(ok!=0) return;
        checkMax(str);    
    }
    
    void no(String str){        
        if(ok != 0) return;
        String[] ss = str.split(" ");
        int A = Integer.parseInt(ss[0]);
        int B = Integer.parseInt(ss[2]);
        int C = Integer.parseInt(ss[4]);
        char cal = ss[1].charAt(0);
        
        if(ok != 0) return;
        checkMax(str);
        int count = 0;
        int last = 0;
        for(int i = Math.max(2, max); i<10 ; i++){
            
            int C10 = changeTo10(C, i);
            int r = calc(A, B, cal, i);
            // System.out.println(i + " :" + r + " " + C10);
            if(r == C10){
                count++;
                last = i;
            }
        }
        if(count == 1){
            ok = last;
        }
    }
    int calc(int A, int B, char cal, int i){
        int A10 = changeTo10(A, i);
        int B10 = changeTo10(B, i);
        if(cal == '+'){
            return A10 + B10;
        }else{
            return A10 - B10;
        }
    }
    
    // from진법 -> 10진법
    int changeTo10(int n, int from){
        // from -> 10
        // int sum = 0;
        // int go = 1;
        // while(n != 0){
        //     sum += (n%10)*go;
        //     n/=10;   
        //     go*=from;
        // }
        // return sum;
        String str = String.valueOf(n);
        int result = 0;
        try{
            result = Integer.parseInt(str, from);
        }catch(Exception e){
            
        }
        return result;
    }
    // 10진법 -> k 진법
    int change(int n, int k){
        int sum = 0;
        int i = 1;
        while(n!=0){
            sum += n%k*i;
            n /= k;
            i*=10;
        }
        return sum;
    }
    void checkMax(String str){
        for(int i=0 ; i<str.length(); i++){
            char c = str.charAt(i);
            if(c <'0' || c >'9') continue;
            max = Math.max(max, c-'0'+1);
            if(max == 9) ok = 9;
        }
    }
}