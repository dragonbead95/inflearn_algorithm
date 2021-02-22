/**
 * 퀵정렬
 */
package section03_Sort_03;

public class Sort {
	public static void QuickSort(int data[], int p, int r)
	{
		int q;
		if(p<r)
		{
			q = partion(data, p, r);	// 분할
			QuickSort(data, p, q-1);	// 왼쪽 부분배열 정렬
			QuickSort(data, q+1, r);	// 오른쪽 부분배열 정렬
		}
	}
	
	public static int partion(int data[], int p, int r)
	{
		int pivot = data[r];
		int i = p-1;
		int temp;
		for(int j=p;j<=r-1;j++)
		{
			if(data[j]<=pivot)
			{
				i++;
				temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}
		temp = data[i+1];
		data[i+1] = data[r];
		data[r] = temp;
		return i+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {10,9,8,7,6,5,4,3,2,1};
		
		QuickSort(data,0,data.length-1);
		
		for(int i=0;i<data.length;i++)
		{
			System.out.print(data[i] + " ");
		}
	
	}

}
