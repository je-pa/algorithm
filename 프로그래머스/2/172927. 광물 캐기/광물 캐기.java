import java.util.*;
class Solution {
    int di = 0;
    int ir = 1;
    int st = 2;
    String sdi = "diamond";
    String sir = "iron";
    String sst = "stone";
    public int solution(int[] picks, String[] minerals) {
        int[][] arr = new int[3][3];
        for(int i=0 ; i<3; i++){
            for(int j = 0 ; j<3 ; j++){
                if(i<=j){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 5;
                }
            }
        }
        arr[st][di] = 25;
        int k =0;
        Count cur = new Count(0,0,0,0);
        PriorityQueue<Count> q = new PriorityQueue<>((x,y) -> Integer.compare(y.total, x.total));
        int gok = 0;
        for(int i=0 ; i<3 ; i++){
            gok += picks[i];
        }
        for(int i=0 ; i< minerals.length && i<=gok*5 ;i++){
            if(k==5){
                q.add(cur);
                cur = new Count(0,0,0,0);
                k=0;
            }
            switch(minerals[i]){
                case "diamond":
                    cur.dicount+=1;
                    cur.total+=25;
                    break;
                case "iron":
                    cur.ircount+=1;
                    cur.total+=5;
                    break;
                case "stone":
                    cur.stcount+=1;
                    cur.total+=1;
                    break;
            }
            if(i == minerals.length-1){
                q.add(cur);
            }
            k++;
            
        }
        int index = 0;
        int answer = 0;
        
        while(!q.isEmpty()){
            while(index < picks.length && picks[index] == 0){
                index++;
            }
            if(index >= picks.length){
                break;
            }
            // System.out.println("pi"+picks[index] + " index "+index);
            Count node = q.poll();
            if(index == 0){
                answer += (node.dicount + node.ircount + node.stcount);
            }else if(index == 1){
                answer += (node.dicount*5 + node.ircount + node.stcount);
            }else if(index ==2){
                answer += node.total;
            }
            picks[index] -= 1;
            // System.out.println("--pi"+picks[index] + " index "+index+" answer:"+answer);
        }
        return answer;
    }
    
}

class Count{
    int total;
    int dicount;
    int ircount;
    int stcount;
    
    public Count(int total,
                int dicount,
                int ircount,
                int stcount){
        this.total = total;
        this.dicount = dicount;
        this.stcount = stcount;
        this.ircount = ircount;
    }
}