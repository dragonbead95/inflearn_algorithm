package section03_Sort_08;

import java.util.Arrays;

public class Main {
	
	public static int getMax(int[] data)
	{
		int m_val = data[0];
		for(int i=0;i<data.length;i++)
		{
			if(m_val<data[i])
			{
				m_val = data[i];
			}
		}
		return m_val;
	}
	
	public static void CountSort(int[] data, int exp)
	{
		int[] output = new int[data.length];
		int[] count = new int[10];
		Arrays.fill(count, 0);
		
		// count �� count �迭�� ����
		for(int i=0;i<data.length;i++)
		{
			count[(data[i]/exp)%10]++;
		}
		// ������ count �迭 ����
		for(int i=1; i<10; i++)
		{
			count[i] += count[i-1];
		}
		// output�迭 ����
		for(int i=data.length-1;i>=0;i--)
		{
			output[count[(data[i]/exp)%10]-1] = data[i];
			count[(data[i]/exp)%10]--;
		}
		// output �迭�� ����� ���� data �迭�� ����
		for(int i=0;i<data.length;i++)
		{
			data[i] = output[i];
		}
	}
	
	public static void RadixSort(int[] data)
	{
		// �ִ밪 ã��
		int m = getMax(data);
		for(int exp=1; m/exp>0; exp*=10)
		{
			CountSort(data,exp);
		}
	}
	
	public static void main(String args[])
	{
		int data[] = {329,457,657,839,436,720,355};
		
		System.out.println("������� �� : " + Arrays.toString(data));
		RadixSort(data);
		System.out.println("������� �� : " + Arrays.toString(data));
		
	}
}
