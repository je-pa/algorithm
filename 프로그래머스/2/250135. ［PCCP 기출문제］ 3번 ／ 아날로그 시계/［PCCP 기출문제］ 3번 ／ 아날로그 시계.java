class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int startTime = toSec(h1, m1, s1);
        int endTime = toSec(h2, m2, s2);
        
        int num = endTime * 59/3600 + endTime * 719/43200 - startTime * 59/3600 - startTime * 719/43200;
        if (startTime >= 43200) {
            num += 1;
        }
        if (endTime >= 43200) {
            num -= 1;
        }
        if (startTime * 59 % 3600 == 0 || startTime * 719 % 43200 == 0) {
            num += 1;
        }

        return num;
    } 
    private static int toSec(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }
    
}

// 초침이 시침이나 분침과 겹칩때
// 속도비 1/60 : 1/3600 : 1/ 60 ^ 2 * 24 = 60 ^ 2 : 60 ^ 1 : 1 = s : m : h
// 상대속도 초와 분 3600 - 60 초와 시  60 * 12 - 1 
// 그럼 1시간에 59번 초침과 분침, 12시간에 719번 초침과 시침이 만남
//  초침과 분침은 59 / 3600, 719 / 43200
// 12시 정각에만 초, 분, 시침이 겹치니까 1빼주자.
