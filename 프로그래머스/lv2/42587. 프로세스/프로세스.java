import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<int[]> list = new LinkedList<>();
        int[] arr = new int[10];
        
        for(int i=0; i<priorities.length ; i++){
            arr[priorities[i]]++;
            list.add(new int[]{priorities[i], i});
        }
        int index = 9;
        int count = 0;
        while(index != 0){
            if(arr[index] == 0){
                index--;
            }else{
                while(list.peek()[0] != index){
                    list.add(list.remove());
                }
                int play = list.remove()[1];
                count++;
                if(play == location){
                    break;
                }
                arr[index]--;
            }
        }
        
        return count;
    }
}