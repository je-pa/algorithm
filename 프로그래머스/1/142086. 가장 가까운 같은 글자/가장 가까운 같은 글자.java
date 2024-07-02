class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] in = new int['z'+1];
        for(int i=0 ; i< answer.length ; i++){
            int c = s.charAt(i);
            System.out.print(c);
            answer[i] = in[c] == 0? -1 : i+1 - in[c];
            in[c] = i+1;
        }
        return answer;
    }
}