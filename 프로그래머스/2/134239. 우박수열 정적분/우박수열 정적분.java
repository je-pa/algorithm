import java.util.*;
class Solution {
    int count = 0;
    List<Double> list = new ArrayList<>();
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        set(k);
        // System.out.println(count);
        for(int j=0 ; j<ranges.length ; j++){
            int[] arr = ranges[j];
            if(arr[0] > count+arr[1]){
                answer[j]=-1;
            }
            for(int i=arr[0] ; i< count+arr[1] ;i++){
                answer[j]+=list.get(i);
                // System.out.print(list.get(i)+" ");
            }
            // System.out.println();
        }
        return answer;
    }
    
    public void set(int n){
        while(n!=1){
            count++;
            if(n%2==1){
                list.add((double)2*(double)n + (double)1/(double)2);
                n=n*3+1;
            }else{
                list.add(3.0*(double)n/4.0);
                n/=2;
            }
        }
    }
}
// 8 4
// 4*1 + 4*1/2 = (N/2) + (n/2)*1/2 = 
// N/2 + N/4  
// 짝 3*N/4

// 5 16
// N + ((3N+1)-N)/2 = N + N +1/2 = 
// 홀 2N + 1/2

