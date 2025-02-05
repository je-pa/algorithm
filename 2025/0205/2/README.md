# 문제

범위가
```java
1 <= arr 배열 길이 <= 20만개
0 <= arr[i]의 값 <= 범위 1억
```

일때

Math.abs(arr[i]- arr[i-1])은 1이어야한다.

int[] arr이 무작위로 있을때

최소 몇개를 제거해야 위를 만족할 수 있을까?

## 해결 방법

- LIS (최장 증가 부분 수열, Longest Increasing Subsequence) 변형
- 주어진 조건에서 연속하는 수의 차이가 반드시 1이어야 하므로, 부분 수열의 원소가 (x, x+1, x, x+1, ...)의 패턴을 따라야 합니다.
- 따라서, 해당 패턴을 최대한 유지하면서 길이가 긴 부분 수열을 찾아야 합니다.
- 가장 긴 유효한 부분 수열을 구한 후, 제거해야 하는 원소 개수 = 전체 길이 - 유효한 부분 수열의 길이입니다.

```java
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

```
위의 실행결과 16이 나옵니다.
