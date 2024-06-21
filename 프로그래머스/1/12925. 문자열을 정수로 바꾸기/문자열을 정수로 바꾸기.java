// class Solution {
//     public int solution(String s) {
//         return Integer.parseInt(s);
//     }
// }


class Solution {
    public int solution(String s) {
        boolean Sign = true;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-')
                Sign = false;
            else if(ch !='+')
                result = result * 10 + (ch - '0');
        }
        // return (Sign?1:-1)* result;
        return Integer.parseInt(s);
    }
}