import java.util.stream.LongStream;
class Solution {
    public long[] solution(int x, int n) {
        // long[] answer = new long[n];
        // for(int i=0; i<n; i++){
        //     answer[i]=(long)x*(i+1);
        // }
        return LongStream.iterate(x, i->i+x).limit(n).toArray();
    }
}

// class Solution {
//     public long[] solution(long x, int n) {
//         long[] answer = new long[n];
//         for(int i=0; i<n; i++){
//             answer[i]=x*(i+1);
//         }
//         return answer;
//     }
// }


// class Solution {
//     public static long[] solution(int x, int n) {
//         long[] answer = new long[n];
//         answer[0] = x;

//         for (int i = 1; i < n; i++) {
//             answer[i] = answer[i - 1] + x;
//         }

//         return answer;

//     }
// }