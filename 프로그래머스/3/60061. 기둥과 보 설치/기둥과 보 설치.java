import java.util.*;
class Solution {
    boolean[][][] map;
    int DEL = 0, INS = 1;
    int LI = 0, BO = 1;
    int N;
    int count = 0;
    public int[][] solution(int n, int[][] build_frame) {        
        int[][] answer;
        N = n;
        map = new boolean[n+1][n+1][2];
        for(int[] arr : build_frame){
            int x = arr[0];
            int y = arr[1];
            if(arr[2] == LI){
                if(arr[3] == INS){
                    insLine(x,y);
                }else{
                    delLine(x,y);
                }
            }else{
                if(arr[3] == INS){
                    insBo(x,y);
                }else{
                    delBo(x,y);
                }
            }
        }
        // System.out.println(count);
        answer = new int[count][3];
        int idx = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0 ; i<N+1; i++){
            for(int j=0 ; j<N+1 ; j++){
                if(map[i][j][LI]){
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = LI;
                    list.add(new int[]{i, j, LI});
                    idx++;
                }
                if(map[i][j][BO]){
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = BO;
                    list.add(new int[]{i, j, BO});
                    idx++;
                }
            }
        }
        // answer = new int[idx][3];
        // for(int i = 0 ; i < idx ; i++){
            // answer[i] = list.get(i);
        // }
        return answer;
    }
    
    void insLine(int x, int y){
        if(map[x][y][LI]) return;
        if(x<0 || x>N || y < 0 || y>N) return;
        if(x < 0 || y < 0) return;
        if(y == 0){
            map[x][y][LI] = true;
            count++;
            // System.out.println(1);
            return;
        }
        if((x>0 && map[x-1][y][BO])
           || map[x][y][BO] 
           || (y>0 && map[x][y-1][LI])
          ){
            map[x][y][LI] = true;
            count++;
            // System.out.println(2);
        }
    }  
    void insBo(int x, int y){
        if(x<0 || x>N || y < 0 || y>N) return;
        if(map[x][y][BO]) return;
        if(y == 0) return;
        if((y>0 && map[x][y-1][LI] )
           || (x < N && y>0 && map[x+1][y-1][LI])
           || (x > 0 && x<N && map[x-1][y][BO] && map[x+1][y][BO])){
            map[x][y][BO] = true;
            count++;
            // System.out.println(3);
        }
    } 
    void delLine(int x, int y){
        if(x<0 || x>N || y < 0 || y>N) return;
        if(!map[x][y][LI]) return;
        map[x][y][LI] = false;
        count--;
        if((y<N && !checkLine(x,y+1))
          // || (x>0 && !checkBo(x-1, y)) || ! checkBo(x, y)
          || (y<N && x>0 && !checkBo(x-1, y+1)) || (y<N && !checkBo(x, y+1))
          ){
            map[x][y][LI] =true;
            // System.out.println(x +" " + y);
            count++;
        }
    }
    void delBo(int x, int y){
        if(x<0 || x>N || y < 0 || y>N) return;
        if(!map[x][y][BO]) return;
        map[x][y][BO] = false;
        count--;
        if((x<N && !checkBo(x-1,y)) || (x<N && !checkBo(x+1,y))
          || (y>0 && !checkLine(x, y-1)) || (x<N && !checkLine(x, y))
          || (y>0 && !checkLine(x+1, y-1)) || (x<N && !checkLine(x+1, y))
          ){
            map[x][y][BO] =true;
            count++;
        }
    }
    
    boolean checkLine(int x, int y){
        if(x<0 || x > N || y < 0 || y > N) return true;
        if(!map[x][y][LI]) return true;
        if(y == 0
           || (x>0 && map[x-1][y][BO] )
           || map[x][y][BO]
           || (y>0 && map[x][y-1][LI])
          ){
            return true;
        }
        return false;
    }
    boolean checkBo(int x, int y){
        if(x<0 || x > N || y < 0 || y > N) return true;
        if(!map[x][y][BO]) return true;
        // if(y == 0) return false;
        if((y>0 && map[x][y-1][LI])
           || (x<N && y>0 && map[x+1][y-1][LI])
           || (x>0 && x<N && map[x-1][y][BO] && map[x+1][y][BO])){
            return true;
        }
        return false;
    }
    
}