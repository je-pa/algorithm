import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] A, B, C;
	
	// 값의 범위가 int를 넘어가서 Long을 사용했다.
	static long min = Long.MAX_VALUE;
	static long max = Long.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		B = new int[N];
		C = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			
			min = Math.min(min, A[i]);
			max = Math.max(max, C[i]);
		}
		max++;
		bs();
	}
	
	static void bs() {
		long left = min;
		long right = max;
		
		while (left < right) {
			long mid = (left + right) / 2;
			
			long sum = getSum(mid);
			
			// mid까지의 숫자갯수의 총합이 짝수면 조사하지 않은 범위에
			// 홀수인 정수가 존재한다는 의미이므로 left = mid + 1
			if (sum % 2 == 0) {
				left = mid + 1;
				
			// mid까지의 숫자갯수의 총합이 홀수면 해당 영역에 
			// 홀수인 정수가 존재한다는 의미이므로 right = mid;
			} else {
				right = mid;
			}
		}
		
		// 탐색을 마쳤을 때 left가 max라면 홀수인 값이 없다는 뜻
		if (left == max) System.out.println("NOTHING");
		
		// 아니라면 해당하는 숫자를 구하기 위해 아래와 같은 식을 사용
		else {
			long num = getSum(left) - getSum(left - 1);
			System.out.println(left + " " + num);
		}
	}
	
	static long getSum(long mid) {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (mid >= A[i]) sum += (Math.min(mid, C[i]) - A[i]) / B[i] + 1;
		}
		return sum;
	}
}

