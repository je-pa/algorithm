import java.util.*;
import java.io.*;
class Main{
    static int N;
    static int C;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr= new int[N];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 1;
        int right = arr[arr.length-1];
        while(left <= right){
            int mid = right - (right - left)/2;
            boolean t = false;
            int cur = arr[0];
            int count = 1;
            for(int i : arr){
                if(i == arr[0]) continue;
                if(i-cur >= mid){
                    count++;
                    cur = i;
                    if(count >= C){
                        t = true;
                        break;
                    }
                }
            }
            
            if(t){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(left-1);
    }
}