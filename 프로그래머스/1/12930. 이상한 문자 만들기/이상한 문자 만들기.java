class Solution {
    public String solution(String s) {
        String[] arr = s.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str : arr){
            for(int i=0 ; i<str.length(); i++){
                char data = str.charAt(i);
                sb.append(i%2==0 ? (char)(data-32) : data );
            }
            sb.append(" ");
        }
        int index = s.length()-1;
        while(s.charAt(index)==' '){
            index-=1;
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.lastIndexOf(" ")).toString();
    }
}//9