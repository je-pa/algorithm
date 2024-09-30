import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files, new Comparator<String>(){
           public int compare(String a, String b){
               String headA = findHead(a).toUpperCase();
               String headB = findHead(b).toUpperCase();
               if(!headA.equals(headB)){
                   return headA.compareTo(headB);
               }
               String tailA = findTail(a, headA.length());
               String tailB = findTail(b, headB.length());
               int numberA = Integer.parseInt(a.substring(headA.length(), a.length() - tailA.length()));
               int numberB = Integer.parseInt(b.substring(headB.length(), b.length() - tailB.length()));
               if(numberA != numberB){
                   return Integer.compare(numberA, numberB);
               }
               return 0;
           } 
        });
        return files;
    }
    
    public String findHead(String str){
        int i=0;
        char c = str.charAt(i);
        while(i< str.length() && (c < '0' || c > '9')){
            i++;
            c = str.charAt(i);
        }
        return str.substring(0,i);
    }
    public String findTail(String str, int headLen){
        int i=headLen;
        char c = str.charAt(i);
        while(c >= '0' && c <= '9'){
            i++;
            if(i >= str.length()) break;
            c = str.charAt(i);
        }
        return str.substring(i);
    }
}