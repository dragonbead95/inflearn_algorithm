/**
 * 기본적인 정렬 알고리즘
 * Selction Sort
 * Bubble Sort
 * Insertion Sort
 */
package section03_Sort_01;

import java.util.ArrayList;

public class Sort {
	public static int[] SelectionSort(int data[])
	{
		int size = data.length;
		int min; // 최소값을 가진 데이터의 인덱스 저장 변수
		int temp;
		
		for(int i=0;i<size-1;i++)
		{
			min = i;
			for(int j=i+1;j<size;j++)
			{
				if(data[min]>data[j])
				{
					min = j;
				}
			}
			temp = data[min];
			data[min] = data[i];
			data[i] = temp;
			
		}
		return data;
	}
	public static int[] BubbleSort(int[] data)
	{
		int size = data.length;
		int temp;
		for(int i=0;i<size;i++)
		{
			for(int j=0; j<size-i-1;j++)
			{
				if(data[j]>data[j+1])
				{
					temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
		return data;
	}
	public static void InsertionSort(int[] data)
	{
		int size = data.length;
		int temp = 0;
		
		for(int i=size-2;i>0;i--)
		{
			int j;
			for(j=i;j>0;j--)
			{
				if(data[j]<data[j-1])
				{
					temp = data[j];
					data[j] = data[j-1];
				}else 
				{
					break;
				}
			}
			data[j] = temp;
			
		}
	}
	public static void print(int[] data)
	{
		for(int d : data)
		{
			System.out.print(d + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {29,10,14,37,13};
		data = SelectionSort(data);
		print(data);
		
		int data2[] = {29,10,14,37,13};
		data2 = BubbleSort(data2);
		print(data2); 
		
		int data3[] = {29,10,14,37,13};
		data3 = BubbleSort(data3);
		print(data3); 
	
	}

}
