/**
 * 힙정렬 응용 : 우선순위 큐
 */
package section03_Sort_05;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	public static void HeapSort(List<Integer> data)
	{
		BuildMaxHeap(data);
		int heap_size = data.size();
		for(int i=data.size()-1;i>0;i--)
		{
			int temp = data.get(0);
			data.set(0, data.get(i));
			data.set(i, temp);
			heap_size--;
			MaxHeapify(data, 0, heap_size);
		}
	}
	
	public static void BuildMaxHeap(List<Integer> data)
	{
		for(int i=(int)Math.floor(data.size())/2-1;i>=0;i--)
		{
			int heap_size = data.size();
			MaxHeapify(data, i, heap_size);
		}
	}
	public static void MaxHeapify(List<Integer> data, int i, int heap_size)
	{
		while(i*2+1<heap_size || i*2+2<heap_size) // 자식노드를 가지고 있는지 검사
		{
			int k;
			int l_idx = i*2+1;
			int r_idx = i*2+2;
			if(l_idx<heap_size && r_idx<heap_size)	// 자식노드가 2개인경우
			{
				if(data.get(l_idx)>=data.get(r_idx))
				{
					k=l_idx;
				}else {
					k=r_idx;
				}
			}
			else {	// 왼쪽 자식 노드만 있는 경우
				k=l_idx;
			}
			
			if(data.get(i)>=data.get(k))
			{
				return;
			}
			int temp = data.get(i);
			data.set(i, data.get(k));
			data.set(k, temp);
			
			i=k;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> data = new ArrayList<Integer>(); 
		int[] temp = {4,1,3,2,16,9,10,14,8,7};
		//int[] temp = {4,1,3,2,16};
		for(int d : temp)
			data.add(d);
		
		System.out.println("정렬 전 : " + data);
		HeapSort(data);
		System.out.println("정렬 후 : " + data);
		
		
	}
}
