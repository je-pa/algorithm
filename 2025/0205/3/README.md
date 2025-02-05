# 문제
범위는 아래와 같다.
```java
문제 수 N <= 1000
참여자 수 M <= 100_000
```
- int[] A에서 A[i]는 i번째 문제의 점수를 뜻한다.
- int[][] V는 참가자가 푼 문제의 기록으로 아래와 같은 정보를 지닌다.
  - V[i][0]: 참가자 번호
  - V[i][1]: 맞춘 문제 번호
  - V[i][2]: 푼 시간 (<=60)
  - V.length <= N*M
- int [][] Z는 질의로 아래와 같은 정보를 지닌다.
  - Z[i][0]: 시간
  - Z[i][1]: 참가자 번호

위와 같이 주어질 때 Z의 답(=int[] result)을 구해야한다.
result[i] = Z[i]의 답: Z[i][0]시간 대에 Z[i][1] 참가자의 등수

```java
int N= 3,
int M= 5,
int[] A = {100, 230, 360};
int[][] V = {{2, 1, 5},{1, 3, 15},{3, 2, 10}};
int[][] Z = {{5,1},{15,3},{10,2}};

일때

5초에는 2번(100점)이 1등 나머지는 5등
10초에는 3번이(230점) 1등 2번(100점)이 2등 나머지는 5등
15초에는 1번이(360점) 1등 3번(230점)이 2등 2번(100점)이 3등 나머지는 5등

{5,1}: 5초에 1번은 5등
{15,3}: 15초에 3번은 2등
{10,2}: 10초에 2번은 3등
```

```java
import java.util.*;

public class Main {
  public static int[] sol(int N, int M, int[] A, int[][] V, int[][] Z) {
    return null;
  }

  public static void main(String[] args) {


    System.out.println(Arrays.toString(sol(3, 5,
        new int[]{100, 230, 360},
        new int[][]{{2, 1, 5},{1, 3, 15},{3, 2, 10}},
        new int[][]{{5,1},{15,3},{10,2}}
    ))); // {5, 2, 3}
    }

}
```

```java
import java.util.*;

public class Main {
  public static int[] sol(int N, int M, int[] A, int[][] V, int[][] Z) {
    int Q = Z.length;
    int[] result = new int[Q];

    // 시간별 제출 기록을 저장하는 맵 (TreeMap 사용하여 시간순 정렬 유지)
    TreeMap<Integer, List<int[]>> submissions = new TreeMap<>();
    for (int[] v : V) {
      int participant = v[0], problem = v[1], time = v[2];
      submissions.putIfAbsent(time, new ArrayList<>());
      submissions.get(time).add(new int[]{participant, A[problem - 1]});
    }

    // 참가자의 현재 점수를 저장하는 맵
    Map<Integer, Integer> scoreMap = new HashMap<>();
    Set<Integer> participants = new HashSet<>(); // 참가자 목록
    List<Integer> scores = new ArrayList<>();

    // 질의 처리 (시간순으로 접근)
    int queryIndex = 0;
    for (int[] query : Z) {
      int time = query[0], participant = query[1];

      // 현재 시간까지 점수 업데이트
      while (!submissions.isEmpty() && submissions.firstKey() <= time) {
        int curTime = submissions.firstKey();
        List<int[]> logs = submissions.pollFirstEntry().getValue();

        for (int[] log : logs) {
          int user = log[0], score = log[1];
          scoreMap.put(user, scoreMap.getOrDefault(user, 0) + score);
          participants.add(user); // 참가자로 등록
        }
      }

      // 현재 등수 계산
      scores.clear();
      scores.addAll(scoreMap.values());
      scores.sort(Comparator.reverseOrder());

      // 등수 설정 (참가자가 없으면 최하위)
      int rank = M + 1; // 기본적으로 등수를 최하위로 설정
      int prevScore = -1, count = 1;
      for (int s : scores) {
        if (s != prevScore) {
          rank = count;
        }
        if (scoreMap.getOrDefault(participant, 0) == s) {
          result[queryIndex] = rank;
          break;
        }
        prevScore = s;
        count++;
      }

      // 참가하지 않은 경우 최하위 등수 부여
      if (!participants.contains(participant)) {
        result[queryIndex] = M;
      }

      queryIndex++;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sol(3, 5,
        new int[]{100, 230, 360},
        new int[][]{{2, 1, 5}, {1, 3, 15}, {3, 2, 10}},
        new int[][]{{5,1}, {15,3}, {10,2}}
    ))); // 출력: [5, 2, 3]
  }
}
```
