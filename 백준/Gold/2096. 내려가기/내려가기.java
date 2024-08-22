import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][3];
    for (int i = 0; i < n; i++) {
      arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    int[] min = new int[arr[0].length];
    int[] max = new int[arr[0].length];
    for (int i = 0; i < arr[0].length; i++) {
      min[i] = arr[0][i];
      max[i] = arr[0][i];
    }
    for (int i = 1; i < n; i++) {
      int[] nextMin = new int[arr[0].length];
      int[] nextMax = new int[arr[0].length];
      for (int j = 0; j < arr[0].length; j++) {
        Integer minV = Integer.MAX_VALUE;
        Integer maxV = 0;

        if(j>0){
          minV = Math.min(min[j-1]+arr[i][j], minV);
          maxV = Math.max(max[j-1]+arr[i][j], maxV);
        }
        if(j<arr[0].length-1){
          minV = Math.min(min[j+1]+arr[i][j], minV);
          maxV = Math.max(max[j+1]+arr[i][j], maxV);
        }
        minV = Math.min(min[j]+arr[i][j], minV);
        maxV = Math.max(max[j]+arr[i][j], maxV);
       
       
        nextMin[j] = minV;
        nextMax[j] = maxV;
      }
      min = nextMin;
      max = nextMax;
    }
    int minV = Integer.MAX_VALUE;
    int maxV = 0;
    for(int i = 0; i < min.length; i++){
      
      minV = Math.min(min[i], minV);
      maxV = Math.max(max[i], maxV);
    }
    System.out.println(maxV+" "+minV);
  }

}
