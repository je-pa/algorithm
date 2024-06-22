class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<n ; i++){
            if(i%2==0){
                answer.append("수");
            }else{
                answer.append("박");
            }
        }
        
        return answer.toString();
    }
}//1

// class Solution {
//     public String solution(int n) {
//         return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
//     }
// }//1