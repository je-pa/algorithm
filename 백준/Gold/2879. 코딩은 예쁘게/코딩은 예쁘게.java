import java.util.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		long ans = 0;
		
		int[] before = new int[n];
		int[] after = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int j = 0 ; j < n ; j++)
		{
			before[j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int j = 0 ; j < n ; j++)
		{
			after[j] = Integer.parseInt(st.nextToken());
		}
		
		while(!same(before, after, n))
		{
			int start = 0;	//스타트 지점
			int end = 0;
			boolean bigger = true;

			for(int i = 0 ; i < n ; i++)	//before after가 다른 시점을 찾고 탭을 삭제 / 추가해야 하는지(bigger) 표시
			{
				if(before[i] != after[i])
				{
					if(before[i] < after[i])
						bigger = false;
						
					start = i;
					end = i;
					break;
				}
			}

			if(start != n-1)
			{
				for(int i = start+1 ; i < n ; i++)	//같은 연산을 하는 끝지점을 찾아낸다
				{
					if(bigger && before[i] > after[i] || !bigger && before[i] < after[i]) end = i;
					else break;
				}
			}

			int gap = Integer.MAX_VALUE;
			
			for(int i = start ; i <= end ; i++)
			{
				gap = Math.min(gap, Math.abs(before[i] - after[i]));	//최소한의 연산 횟수 찾기
			}
			
			ans += gap;
			
			for(int i = start ; i <= end ; i++)	//연산 실행
			{
				if(bigger) before[i] -= gap;
				else before[i] += gap;
			}

		}
		System.out.println(ans);
	}
	public static boolean same(int[] b, int[] a, int n)
	{
		for(int i = 0 ; i < n ; i++)
		{
			if(b[i] != a[i]) return false;
		}
		
		return true;
	}
}