package section04_BTS_03.BinarySearchTree_02;

import section04_BTS_03.BinaryTree_01.BinaryTree.BTreeNode;

public class CBinarySearchTree implements BinarySearchTree{
	@Override
	public BTreeNode MakeBTreeNode() {
		// TODO Auto-generated method stub
		BTreeNode nd = new BTreeNode();
		nd.left = null;
		nd.right = null;
		return nd;
	}

	@Override
	public int GetData(BTreeNode bt) {
		// TODO Auto-generated method stub
		
		return bt.data;
	}

	@Override
	public void SetData(BTreeNode bt, int data) {
		// TODO Auto-generated method stub
		bt.data = data;
	}

	@Override
	public BTreeNode GetLeftSubTree(BTreeNode bt) {
		// TODO Auto-generated method stub
		return bt.left;
	}

	@Override
	public BTreeNode GetRightSubTree(BTreeNode bt) {
		// TODO Auto-generated method stub
		return bt.right;
	}

	@Override
	public void MakeLeftSubTree(BTreeNode main, BTreeNode sub) {
		// TODO Auto-generated method stub
		if(main.left!=null)
		{
			main.left = null;
		}
		main.left = sub;
	}

	@Override
	public void MakeRightSubTree(BTreeNode main, BTreeNode sub) {
		// TODO Auto-generated method stub
		if(main.right!=null)
		{
			main.right = null;
		}
		main.right = sub;
	}

	@Override
	public void PreorderTraverse(BTreeNode bt) {
		// TODO Auto-generated method stub
		if(bt==null)
		{
			return;
		}
		
		System.out.print(bt.data + " ");
		PreorderTraverse(bt.left);
		PreorderTraverse(bt.right);
	}

	@Override
	public void InorderTraverse(BTreeNode bt) {
		// TODO Auto-generated method stub
		if(bt==null)
		{
			return;
		}
		
		InorderTraverse(bt.left);
		System.out.print(bt.data + " ");
		InorderTraverse(bt.right);
	}

	@Override
	public void PostorderTraverse(BTreeNode bt) {
		// TODO Auto-generated method stub
		if(bt==null)
		{
			return;
		}
		
		PostorderTraverse(bt.left);
		PostorderTraverse(bt.right);
		System.out.print(bt.data + " ");
	}

	@Override
	public void BSTMakeAndInit(BTreeNode pRoot) {
		// TODO Auto-generated method stub
		pRoot = null;
	}

	@Override
	public int BSTGetNodeData(BTreeNode bst) {
		// TODO Auto-generated method stub
		
		return GetData(bst);
	}

	@Override
	public BTreeNode BSTInsert(BTreeNode pRoot, int data) {
		// TODO Auto-generated method stub
		BTreeNode pNode = null;		// parent node
		BTreeNode cNode = pRoot;	// current node
		BTreeNode nNode = null;		// new node
		
		// 새로운 노드가(새 데이터가 담긴 노드가) 추가될 위치를 찾는다.
		while(cNode != null)
		{
			if(data==GetData(cNode))
			{
				return null;		// 데이터의 중복을 허용하지 않음
			}
			
			pNode = cNode;
			if(GetData(cNode)> data)
			{
				cNode = GetLeftSubTree(cNode);
			}else
			{
				cNode = GetRightSubTree(cNode);
			}
		}
		
		// pNode의 자식 노드로 추가할 새노드의 생성
		nNode = MakeBTreeNode();	// 새노드의 생성
		SetData(nNode, data);		// 새노드의 데이터 저장
		
		// pNode의 자식 노드로 새 노드를 추가
		if(pNode != null)
		{
			if(data<GetData(pNode))
			{
				MakeLeftSubTree(pNode, nNode);
			}
			else
			{
				MakeRightSubTree(pNode, nNode);
			}
		}else {		// 새 노드가 루트 노드라면
			pRoot = nNode;
		}
		
		return pRoot;
	}

	@Override
	public BTreeNode BSTSearch(BTreeNode bst, int target) {
		// TODO Auto-generated method stub
		BTreeNode cNode = bst;	// current node
		int cd;					// current data
		
		while(cNode!=null)
		{
			cd = GetData(cNode);
			
			if(target==cd)
			{
				return cNode;
			}
			else if(target < cd)
			{
				cNode = GetLeftSubTree(cNode);
			}
			else 
			{
				cNode = GetRightSubTree(cNode);
			}
		}
		return null;	// 탐색 대상이 저장되어 있지 않음
	}

}
