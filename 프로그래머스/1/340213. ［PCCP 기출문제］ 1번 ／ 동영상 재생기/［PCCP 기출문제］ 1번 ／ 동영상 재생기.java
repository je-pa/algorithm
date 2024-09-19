class Solution {
    static String[] ss = {"prev", "next"};
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int l = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int p = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int os = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int oe = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        
        for(String str : commands){
            if(os <= p && p <= oe){
                p = oe;
            }
            if(str.equals(ss[0])){
                p = Math.max(0, p - 10);
            }else{
                p = Math.min(l, p + 10);
            }
        }
        if(os <= p && p <= oe){
            p = oe;
        }
        
        return String.format("%02d", p/60)+":"+String.format("%02d", p%60);
    }
}