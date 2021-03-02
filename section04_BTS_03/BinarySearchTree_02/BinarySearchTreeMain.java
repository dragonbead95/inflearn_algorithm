package section04_BTS_03.BinarySearchTree_02;

import section04_BTS_03.BinarySearchTree_02.BinarySearchTree.BTreeNode;

public class BinarySearchTreeMain {
	
	public static void main(String[] args) {
		CBinarySearchTree c = new CBinarySearchTree();
		BTreeNode bstRoot = null;
		BTreeNode sNode;
		
		c.BSTMakeAndInit(bstRoot);
		
		bstRoot = c.BSTInsert(bstRoot, 9);
		bstRoot = c.BSTInsert(bstRoot, 1);
		bstRoot = c.BSTInsert(bstRoot, 6);
		bstRoot = c.BSTInsert(bstRoot, 2);
		bstRoot = c.BSTInsert(bstRoot, 8);
		bstRoot = c.BSTInsert(bstRoot, 3);
		bstRoot = c.BSTInsert(bstRoot, 5);
		
		sNode = c.BSTSearch(bstRoot, 1);
		if(sNode==null)
		{
			System.out.println("탐색 실패");
		}
		else
		{
			System.out.println("탐색에 성공한 키의 값 : " + c.BSTGetNodeData(sNode));
		}
		
		sNode = c.BSTSearch(bstRoot, 4);
		if(sNode==null)
		{
			System.out.println("탐색 실패");
		}
		else
		{
			System.out.println("탐색에 성공한 키의 값 : " + c.BSTGetNodeData(sNode));
		}
		
		sNode = c.BSTSearch(bstRoot, 6);
		if(sNode==null)
		{
			System.out.println("탐색 실패");
		}
		else
		{
			System.out.println("탐색에 성공한 키의 값 : " + c.BSTGetNodeData(sNode));
		}
		
		sNode = c.BSTSearch(bstRoot, 7);
		if(sNode==null)
		{
			System.out.println("탐색 실패");
		}
		else
		{
			System.out.println("탐색에 성공한 키의 값 : " + c.BSTGetNodeData(sNode));
		}
	}

}
