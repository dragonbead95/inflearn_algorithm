/**
 * 병합정렬
 */
package section03_Sort_02;

public class Sort {
	public static void mergeSort(int data[], int p, int r)
	{
		int q = r;
		if(p<r)
		{
			q = (p+r)/2;
			mergeSort(data, p, q);		// 전반부 정렬
			mergeSort(data, q+1, r); 	// 후반부 정렬
			merge(data, p, q, r); 		// 합병
		}
	}
	public static void merge(int data[], int p, int q, int r)
	{
		int i=p, j=q+1, k=p;
		int[] tmp = new int[data.length];
		
		while(i<=q && j<=r)
		{
			if(data[i]<=data[j])
			{
				tmp[k++] = data[i++];
			}
			else
			{
				tmp[k++] = data[j++];
			}
		}
		
		while(i<=q)
		{
			tmp[k++] = data[i++];
		}
		while(j<=r)
		{
			tmp[k++] = data[j++];
		}
		
		for(i=p;i<=r;i++)
		{
			data[i] = tmp[i];
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {10,9,8,7,6,5,4,3,2,1};
		
		mergeSort(data,0,data.length-1);
		
		for(int i=0;i<data.length;i++)
		{
			System.out.print(data[i] + " ");
		}
	
	}

}
