class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case 'z' :
                    sb.append(0);
                    i=i+3;
                    break;
                case 'o' :
                    sb.append(1);
                    i=i+2;
                    break;
                case 't' :
                    if(s.charAt(i+1)=='w'){
                        sb.append(2);
                        i=i+2;
                    }else{
                        sb.append(3);
                        i=i+4;
                    }
                    break;
                case 'f' :
                    if(s.charAt(i+1)=='o'){
                        sb.append(4);
                    }else{
                        sb.append(5);
                    }
                    i=i+3;
                    break;
                case 's' :
                    if(s.charAt(i+1)=='i'){
                        sb.append(6);
                        i=i+2;
                    }else{
                        sb.append(7);
                        i=i+4;
                    }
                    break;
                case 'e' :
                    sb.append(8);
                    i=i+4;
                    break;
                case 'n' :
                    sb.append(9);
                    i=i+3;
                    break;
                default :
                    sb.append(s.charAt(i));
                    break;
            }
        }System.out.println(sb);
        answer = Integer.parseInt(sb.toString());
        return answer;
    }
}

// z , o, t2, f2, s2, e, n