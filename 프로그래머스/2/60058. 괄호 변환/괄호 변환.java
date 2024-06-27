import java.util.*;
class Solution {
    public String solution(String p) {
        if(p.isEmpty()) return "";
        String u = makeu(p);
        String v = p.substring(u.length(), p.length());
        System.out.println(change(u) + " "+ v);
        return re(u, v);
        // return "";
    }
    
    public String re(String u, String v){
        if(v.equals("")){
            if(collect(u)){
                return u;
            }else{
                return "()" + change(u);
            }
                
        }
        String newu = makeu(v);
        
        if(collect(u)){
            return u + re(newu, v.substring(newu.length(), v.length()));
        }else{
            return "(" + re(newu, v.substring(newu.length(), v.length())) + ")" + change(u) ;    
        }
        
    }
    
    public String makeu(String p){
        Stack<String> stack = new Stack<>();
        String[] arr = p.split("");
        StringBuilder sb = new StringBuilder();
        stack.push(arr[0]);
        sb.append(arr[0]);
        for(int i=1 ; i<arr.length ; i++){
            if(stack.isEmpty()){
                break;
            }else{
                if(stack.peek().equals("(")){
                    if(arr[i].equals("(")){
                        sb.append("(");
                        stack.push("(");
                    }else{
                        stack.pop();
                        sb.append(")");
                    }
                }else{
                    if(arr[i].equals("(")){
                        sb.append("(");
                        stack.pop();
                    }else{
                        stack.push(")");
                        sb.append(")");
                    }
                } 
            }
        }
        return sb.toString();
    }
    
    public String change(String u){
        if(collect(u)){
            return u;
        }
        String newu = u.substring(1, u.length()-1);
        System.out.print("new: "+newu);
        newu = newu.replace("(","A");
        newu = newu.replace(")","B");
        newu = newu.replace("A",")");
        newu = newu.replace("B","(");
        return newu;
    }
    
    public boolean collect(String u){
        Stack<String> stack = new Stack<>();
        String[] arr = u.split("");
        if(arr[0].equals(")")){
            return false;
        }
        stack.push(arr[0]);
        for(int i=0 ; i<arr.length ; i++){
            if(stack.isEmpty()){
                return false;
            }else{
                if(arr[i].equals("(")){
                    stack.push("(");
                }else{
                    stack.pop();
                }
            }
        }
        return true;
    }
}