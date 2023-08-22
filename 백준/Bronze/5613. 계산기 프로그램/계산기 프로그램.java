import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int answer = scan.nextInt();
        String cal = scan.next();
        while(!cal.equals("=")){
            int nextValue = scan.nextInt();
            switch(cal){
                case "+":
                    answer+=nextValue;
                    break;
                case "-":
                    answer-=nextValue;
                    break;
                case "/":
                    answer/=nextValue;
                    break;
                case "*":
                    answer*=nextValue;
                    break;
            }
            cal = scan.next();
        }
        System.out.print(answer);
    }
}