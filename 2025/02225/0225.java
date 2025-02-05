import java.util.HashMap;

public class MinRemovals {
  public static int minRemovalsToSatisfyCondition(int[] arr) {
    HashMap<Integer, Integer> dp = new HashMap<>();
    int maxLength = 0;

    for (int num : arr) {
      // 현재 숫자를 포함할 때 가능한 최대 길이
      int length = Math.max(dp.getOrDefault(num - 1, 0), dp.getOrDefault(num + 1, 0)) + 1;
      dp.put(num, length);
      maxLength = Math.max(maxLength, length);
    }

    return arr.length - maxLength;
  }

  public static void main(String[] args) {
    int[] arr = {
        1, 2, 3, 4,
        4,
        100,
        1,  //1
        3, 4, 5, 6,7,8,9,10 // 8
        ,101, 102, 103, 104, 105, 106,107,108,109,110,111,112, //12
        4, 5};
    System.out.println(minRemovalsToSatisfyCondition(arr));
  }
}
