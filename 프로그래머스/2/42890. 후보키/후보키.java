// import java.util.*;
// class Solution {
//     static int answer;
//     static int n,m;
//     static List<HashSet<Integer>> candidateKey;
//     static String[][] relationCopy;
//     public int solution(String[][] relation) {
//         relationCopy = relation;
        
//         answer = 0;

//         // 중복 조합을 고려하여 HashSet 사용
//         candidateKey = new ArrayList<>();
//         n = relationCopy.length;
//         m = relationCopy[0].length;

//         // 1부터 m까지 사이즈만큼 조합 생성하기
//         for (int i = 1; i < m + 1; i++) {
//             combination(0, i, 0, new HashSet<>());
//         }

//         return answer;
//     }
//     // 조합 생성 메서드
//     static void combination(int idx, int size, int depth, HashSet<Integer> set) {
//         // 조합이 만들어지면
//         if(depth == size) {
//             // 유일성 검사
//             if(!unique(set)) {
//                 return;
//             }
//             // 최소성 검사
//             for (HashSet<Integer> key : candidateKey) {
//                 if(set.containsAll(key)) {
//                     return;
//                 }
//             }
//             // 조합을 추가하고 answer 증가
//             candidateKey.add(set);
//             answer++;
//             return;
//         }
//         // 조합 만들기
//         for (int i = idx; i < m; i++) {
//             HashSet<Integer> newSet = new HashSet<>(set);
//             newSet.add(i);
//             idx++;
//             combination(idx, size, depth + 1, newSet);
//         }
//     }
//     // 유일성 검사 메서드
//     static boolean unique(HashSet<Integer> set) {
//         List<String> list = new ArrayList<>();
//         // 만들어진 조합으로 중복되는지 검사
//         for (int i = 0; i < n; i++) {
//             StringBuilder sb = new StringBuilder();
//             for (int idx : set) {
//                 sb.append(relationCopy[i][idx]);
//             }
//             if(!list.contains(sb.toString())) {
//                 list.add(sb.toString());
//             } else {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

import java.util.*;
class Solution {
    static int answer;
    static int n, m;
    static List<HashSet<Integer>> candidateKey;
    static String[][] relationCopy;
    
    public int solution(String[][] relation) {
        relationCopy = relation;
        
        answer = 0;
        candidateKey = new ArrayList<>();
        n = relationCopy.length;
        m = relationCopy[0].length;

        // 1부터 m까지 사이즈만큼 조합 생성하기
        for (int size = 1; size <= m; size++) {
            generateCombinations(size);
        }

        return answer;
    }

    // 조합 생성 메서드 (DFS 대신 반복문 사용)
    static void generateCombinations(int size) {
        int[] indices = new int[size];
        for (int i = 0; i < size; i++) {
            indices[i] = i;
        }

        while (indices[0] < m - size + 1) {
            HashSet<Integer> set = new HashSet<>();
            for (int index : indices) {
                set.add(index);
            }

            // 유일성 검사
            if (unique(set)) {
                // 최소성 검사
                boolean isMinimal = true;
                for (HashSet<Integer> key : candidateKey) {
                    if (set.containsAll(key)) {
                        isMinimal = false;
                        break;
                    }
                }
                if (isMinimal) {
                    candidateKey.add(set);
                    answer++;
                }
            }

            // 다음 조합으로 이동
            int t = size - 1;
            while (t != 0 && indices[t] == m - size + t) {
                t--;
            }
            indices[t]++;
            for (int i = t + 1; i < size; i++) {
                indices[i] = indices[i - 1] + 1;
            }
        }
    }

    // 유일성 검사 메서드
    static boolean unique(HashSet<Integer> set) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int idx : set) {
                sb.append(relationCopy[i][idx]);
            }
            if (!list.contains(sb.toString())) {
                list.add(sb.toString());
            } else {
                return false;
            }
        }
        return true;
    }
}
