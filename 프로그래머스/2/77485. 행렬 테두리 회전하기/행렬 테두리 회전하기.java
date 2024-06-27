import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        int num = 1;
        int[] answer = new int[queries.length];
        for(int i=0 ; i<rows ; i++){
            for(int j=0 ; j<columns ; j++){
                arr[i][j] = num++;
            }
        }
        for(int i=0 ; i < queries.length ; i++){
            int[] row = queries[i];
            int cur = arr[row[0]-1][row[1]-1];
            answer[i] = rot(row[0], row[1], row[2], row[3], row[0]-1, row[1], cur, cur, arr);
            // System.out.println();
        }
        return answer;
    }
    
    public int rot(int x1, int y1, int x2, int y2, int curx, int cury, int newV, int min, int[][] arr){
        if(curx == x1-1 && cury == y1-1){
            arr[curx][cury]=newV;
            return min;
        }
        int before = arr[curx][cury];
        // System.out.print(before+" ");
        arr[curx][cury]=newV;
        if(curx == x1-1 && cury < y2-1){
            return rot(x1, y1, x2, y2, curx, cury+1, before, Math.min(min, before), arr);
        }else if(cury == y2-1 && curx < x2 -1){
            return rot(x1, y1, x2, y2, curx+1, cury, before, Math.min(min, before), arr);
        }else if(curx == x2-1 && cury >= y1){
            return rot(x1, y1, x2, y2, curx, cury-1, before, Math.min(min, before), arr);
        }else if(cury == y1-1 && curx >=x1){
            return rot(x1, y1, x2, y2, curx-1, cury, before, Math.min(min, before), arr);
        }
        return 0;
    }
}