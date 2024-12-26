import java.util.*;
import java.io.*;
 
public class Main {
    static int N,M;
    static int paper[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                paper[i][j] = str.charAt(j) - '0';
            }
        }
        
        int ans = 0;
        
        for(int s=0; s<(1<<(N*M)); s++) {
            int sum = 0;
            /* 가로(0) 찾기 */
            for(int i=0; i<N; i++) {
                int cur = 0;
                for(int j=0; j<M; j++) {
                    int k = i*M+j;    
                    if( (s&(1<<k)) ==0 ) {    // s의 k번째 비트가 0이면-> 해당 숫자는 가로
                        cur*= 10;    
                        cur += paper[i][j];    
                    }else {    // 해당 숫자는 세로
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            
            /* 세로(1) 찾기 */
            for(int j=0; j<M; j++) {
                int cur = 0;
                for(int i=0; i<N; i++) {
                    int k = i*M +j;
                    if( (s&(1<<k)) != 0) {    // s의 k번째 비트가 1이면-> 해당 숫자는 세로
                        cur *= 10;
                        cur += paper[i][j];
                    }else {    // 해당 숫자는 가로
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            ans = Math.max(ans, sum);
        }
        
        System.out.println(ans);        
    }
 
}