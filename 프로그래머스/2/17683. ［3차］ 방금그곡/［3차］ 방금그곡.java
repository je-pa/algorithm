import java.util.*;

class Solution {
    int start = 0;
    int end = 1;
    int title = 2;
    int mel = 3;
    ArrayList<String> titles = new ArrayList<>();
    public String solution(String m, String[] musicinfos) {
        // String test = "CC#BCC#BCC#BCC#BCC#BCC#BCC#BCC#BCC#BCC#B";
        // int cc = (int)Arrays.stream(test.split("")).filter(s -> s.equals("#")).count();
        // System.out.println(test.length() - cc);
        
        String answer = "";
        m = replaceM(m);
        int len = musicinfos.length;
        int maxTime = 0;
        // int minStart = 24*60;
        String[][] arr = new String[len][];
        for(int i=0 ; i< len ; i++){
            arr[i] = musicinfos[i].split(",");
            int time = time(arr[i][start], arr[i][end]);
            // int startTime = time(arr[i][start]);
            String mf = make(arr[i][mel], time);
            if(mf.contains(m)){
                // String[] sp = mf.split(m);
                // boolean check = false;
                // for(int k=0 ; k<sp.length; k++){
                //     if(!sp[k].equals("") &&  sp[k].charAt(0) == '#'){
                //         check = true;
                //         break;
                //     }
                // }
                if(maxTime < time){
                    maxTime = time;
                    // minStart = startTime;
                    answer = arr[i][title];
                }
            }
        } 
        
        return answer.equals("") ? "(None)" : answer;
    }
    
    public int time(String start, String end){
        int ms = time(start);
        int me = time(end);
        return me - ms;
    }
    
    private int time(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
    }
    
    public String make(String music, int time){
        music = replaceM(music);
        StringBuilder sb = new StringBuilder();
        // int sCount = (int)Arrays.stream(music.split("")).filter(i -> i.equals("#")).count();
        // int count = music.length() - sCount;
        
        int banbok = time / music.length() ;
        for(int i=0 ; i< banbok ; i++){
            sb.append(music);
        }
        int i = 0;
        for(int j=0 ; j < time%music.length() ; i++, j++){
            char c = music.charAt(i);
            sb.append(c);
            // if(c == '#') j--;
        }
        // if(music.charAt(i) == '#'){
        //     sb.append("#");
        // }
        return sb.toString();
    }
    
    public String replaceM(String m){
        String[] before = new String[]{"C#","D#","F#", "G#", "B#", "A#","E#", "A",  "B", "C", "D", "E", "F", "G"};
        String[] after = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E"};
        for(int i=0 ; i<before.length ; i++){
            m = m.replaceAll(before[i], after[i]);
        }
        System.out.println("변환 : "+ m);
        return m;
    }

}
// 음악 제목, 제생 시작 끝 시각, 악보
// C, C#, D, D#, E, F, F#, G, G#, A, A#, B
// 음 1분에 1개씩 재생
// 음악 처음부터 재생
// 조건 일치 - 재생 시간 제일 긴 음악, 먼저 입력 음악 제목
// (NONE)