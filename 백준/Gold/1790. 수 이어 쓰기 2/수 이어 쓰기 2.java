import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 받기
        long N = scanner.nextLong();
        long k = scanner.nextLong();
        
        // 자리수별로 숫자가 몇 개인지, 그 숫자들이 차지하는 자리수를 누적 계산
        long length = 0; // 지금까지의 자리수 총합
        long digit = 1; // 자리수 (1자리, 2자리, 3자리...)
        long start = 1; // 각 자리수의 시작 숫자
        long count = 9; // 각 자리수의 숫자 개수 (1자리수는 9개, 2자리수는 90개 등)

        // N을 포함하는 자리까지 계산
        while (k > length + digit * count && start <= N) {
            length += digit * count;
            digit++;
            start *= 10;
            
            if (start * 10 - 1 > N) {
                count = N - start + 1;
            }else{
                count = (start * 10 - start); // 각 자리수 범위에 있는 숫자 개수
            }
        }

        // k번째 자리 숫자가 있는지 확인
        if (k > length + digit * count) {
            System.out.println(-1);
            return;
        }

        // k번째 자리가 있는 숫자를 찾는다.
        long number = start + (k - length - 1) / digit; // 몇 번째 숫자인지 찾기
        int digitIndex = (int) ((k - length - 1) % digit); // 해당 숫자의 몇 번째 자릿수인지
        
        // 해당 숫자의 digitIndex번째 자리 출력
        System.out.println(String.valueOf(number).charAt(digitIndex));
    }
}
