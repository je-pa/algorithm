class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=1 ; i<food.length ; i++){
            for(int j=0 ; j<food[i]/2 ; j++ ){
                sb.append(i);
            }
        }
        String s = sb.toString();
        sb.reverse();
        System.out.print(sb);
        
        return s+"0"+sb.toString();
    }
}