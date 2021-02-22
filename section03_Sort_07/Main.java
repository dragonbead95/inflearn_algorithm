package section03_Sort_07;

import java.util.Arrays;

public class Main {
	
	// 문제점 : 정수로만 비교시 레코드 전체를 움직이지 못하게함
	public static int[] CountingSort(int[] data, int n, int k)
	{
		int A[] = new int[n];
		int C[] = new int[k+1];
		Arrays.fill(C, 0);
		
		for(int i=0;i<n;i++)
		{
			C[data[i]]++;
		}
		
		for(int s=0, i=0; i<=k; i++)
		{
			for(int j=0;j<C[i];j++)
			{
				A[s++] = i;
			}
		}
		return A;
	}
	
	public static int[] CountingSort2(int[] data, int n, int k)
	{
		int B[] = new int[n];
		int C[] = new int[k+1];
		
		Arrays.fill(C, 0);
		
		// step1 : 카운팅
		for(int i=0;i<n;i++)
		{
			C[data[i]]++;
		}
		
		// step2 : 누적합
		for(int i=1;i<=k;i++)
		{
			C[i] += C[i-1];
		}
		
		// step3 : Counting Sort 수행
		for(int i=n-1;i>=0;i--)
		{
			B[C[data[i]]-1] = data[i];
			C[data[i]]--;
		}
		
		return B;
	}
	
	public static void main(String args[])
	{
		int data[] = {2,5,3,0,2,3,0,3};
		int n = data.length;
		int k = 5;
		int result[] = CountingSort(data, n, k);
		//System.out.println(Arrays.toString(result));
		
		int result2[] = CountingSort2(data, n, k);
		System.out.println(Arrays.toString(result2));
	}
}
