import java.util.*;

class Solution {
    char[] cs = new char[]{'+','-','*'};
    char[] cur = new char[3];
    List<char[]> cases = new ArrayList<>();
    public long solution(String expression) {
        re(0, new boolean[3]);
        String[] exs = expression.split("");
        LinkedList<String> deq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<exs.length ; i++){
            String cur = exs[i];
            try{
                Long.parseLong(cur);
                sb.append(cur);
            }catch (Exception e){
                // System.out.println(sb.toString() + " " + cur);
                deq.add(sb.toString());
                sb = new StringBuilder();
                deq.add(cur);
            }
        }
        // System.out.println(sb.toString());
        deq.add(sb.toString());
        LinkedList<String> deq2 = new LinkedList<>();
        long max = 0;
        for(char[] turn : cases){
            // for(int k=0 ; k<3 ; k++){
            //     System.out.print(turn[k]);
            // }
            LinkedList<String> deq1 = new LinkedList<>();
            for(String s : deq){
                deq1.add(s);
            }
            for(int i=0 ; i<3 ; i++){
                while(!deq1.isEmpty()){
                    String cur = deq1.remove();
                    try{
                        // System.out.println(cur);
                        Long.parseLong(cur);
                        deq2.add(cur);
                    }catch (Exception e){
                        if(cur.equals(String.valueOf(turn[i]))){
                            // System.out.println(cur);
                            long one = Long.parseLong(deq2.removeLast());
                            long two = Long.parseLong(deq1.remove());
                            long result = cal(one, two, turn[i]);
                            // System.out.println(result);
                            deq2.add(String.valueOf(result));
                            continue;   
                        }
                        deq2.add(cur);
                    }
                }
                while(!deq2.isEmpty()){
                    deq1.add(deq2.remove());
                }
            }
            String str = deq1.remove();
            long result = Long.parseLong(str);
            // System.out.println(result);
            max = Math.max(result<0?result*-1 : result, max);
        }
        return max;
    }
    public void re(int index, boolean[] check){
        if(index==3){
            cases.add(cur);
            // for(int i=0 ; i<cur.length ; i++){
            //     System.out.print(cur[i]+" ");
            // }
            // System.out.println();
            char[] next = new char[3];
            for(int i=0 ; i< 3 ; i++){
                next[i] = cur[i];
            }
            cur = next;
            return;
        }
        for(int i=0 ; i<cs.length ; i++){
            if(check[i]) continue;
            check[i] = true;
            cur[index] = cs[i];
            re(index+1, check);
            check[i] = false;
        }
    }
    
    public long cal(long v1, long v2, char c){
        switch(c){
            case '+':
                return v1+v2;
            case '-':
                return v1-v2;
            case '*':
                return v1*v2;
        }
        return 0;
    }
}
// +, - , *