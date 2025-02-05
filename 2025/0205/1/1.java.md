# 문제
N개의 구간이 있다.
각 구간은 [a[i], b[i]]
a[i] <= 10^9
N <= 1000

일때 

곂치는 부분이 있다면 곂치는 해당 구간을 합친다.

각 i번째까지 구간을 사용했을때 구간의 수를 알아보자.
  
```
int[] a = {1, 5, 6, 3, 3};
int[] b = {3, 7, 8, 5, 5};

1: (1,3) 구간 1개
2: (1,3)(5,7) 구간 2개
3: (1,3)(5,8) 구간 2개
4: (1,8) 구간 1개
5: (1,8) 구간 1개

-> [1, 2, 2, 1, 1]
```
  
## 해결방법
- 구간 병합 (merge intervals) 기법

```java
import java.util.*;

public class Main {
    public static int[] sol(int[] a, int[] b) {
        int n = a.length;
        int[] result = new int[n];

        List<int[]> intervals = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            // 현재 구간 추가
            intervals.add(new int[]{a[i], b[i]});
            
            // 정렬: 시작점 기준 오름차순, 같다면 끝점 기준 오름차순
            intervals.sort(Comparator.comparingInt(o -> o[0]));
            
            // 병합된 구간 리스트
            List<int[]> merged = new ArrayList<>();
            int[] prev = intervals.get(0);
            merged.add(prev);
            
            for (int j = 1; j < intervals.size(); j++) {
                int[] curr = intervals.get(j);
                if (prev[1] >= curr[0]) { // 겹치는 경우 병합
                    prev[1] = Math.max(prev[1], curr[1]);
                } else { // 겹치지 않으면 새로운 구간
                    prev = curr;
                    merged.add(prev);
                }
            }
            
            // 현재 병합된 구간 개수 저장
            result[i] = merged.size();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 6, 3, 3};
        int[] b = {3, 7, 8, 5, 5};
        
        System.out.println(Arrays.toString(sol(a, b))); // 출력: [1, 2, 2, 1, 1]
    }
}

```
