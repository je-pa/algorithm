import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        PriorityQueue<long[]> que = new PriorityQueue<>((x,y) -> {
            if(x[1]==y[1]){
                return Long.compare(x[0], y[0]);
            }
            return Long.compare(x[1], y[1]);
        });
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE; 
        int maxy = Integer.MIN_VALUE; 
        for(int i=0 ; i<line.length ; i++){
            int[] l = line[i];
            long a = l[0];
            long b = l[1];
            long e = l[2];
            for(int j=i+1 ; j<line.length ; j++){
                int[] l2 = line[j];
                long c = l2[0];
                long d = l2[1];
                long f = l2[2];
                
                long div = (a*d - b*c);
                if(div == 0) continue;
                if((b*f - e*d)%div != 0) continue;
                if((e*c - a*f)%div != 0) continue;
                int x = (int)((b*f - e*d)/div); 
                int y = (int)((e*c - a*f)/div);
                que.add(new long[]{x,y});
                // System.out.println("x:"+x +" y:"+y);
                minx = Math.min(x, minx);
                miny = Math.min(y, miny);
                
                maxx = Math.max(x, maxx);
                maxy = Math.max(y, maxy);
            }
        }
        answer = sq(minx, miny, maxx, maxy);
        answer = make(que , answer, minx, miny);
        return reverse(answer);
    }
    
    String[] sq(long minx, long miny, long maxx, long maxy){
        int ylen = (int)(maxy-miny + 1);
        String[] arr = new String[ylen];
        int xlen = (int)(maxx - minx +1);
        for(int j=0 ; j<arr.length ; j++){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< xlen ; i++){
                sb.append(".");
            }
            arr[j] = sb.toString();
        }
        return arr;
    }
    
    String[] make(PriorityQueue<long[]> p , String[] arr, long minx, long miny){
        
        while(!p.isEmpty()){
            long[] dot = p.poll();
            int x = (int)(dot[0] - minx);
            int y = (int)(dot[1] - miny);
            String str = arr[y];
            arr[y] = str.substring(0,x)+"*"+str.substring(x+1);
        }
        return arr;
    }
    
    String[] reverse(String[] arr){
        String[] result = new String[arr.length];
        for(int i=0 ; i<arr.length ; i++){
            result[arr.length-i-1] = arr[i];
        }
        return result;
    }
}

