class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        String temp;
        for(int i=0;i<strings.length;i++){
            for(int j=i+1;j<strings.length;j++){
                String t1=strings[i].substring(n,n+1);
                String t2=strings[j].substring(n,n+1);
                //System.out.print(t1+" "+t2);
                //System.out.print(" "+t1.compareTo(t2)+" ");
                System.out.print(t1.compareTo(t2)+" ");
                if(t1.compareTo(t2)>0){
                    temp=strings[i];
                    strings[i]=strings[j];
                    strings[j]=temp;
                }else if(t1.compareTo(t2)==0){
                    if(strings[i].compareTo(strings[j])>0){
                        temp=strings[i];
                        strings[i]=strings[j];
                        strings[j]=temp;
                    }
                }
                
            }
            
        }answer=strings;
        
        for(int i=0;i<strings.length;i++){
            answer[i]=strings[i];
        }
        return answer;
    }
}