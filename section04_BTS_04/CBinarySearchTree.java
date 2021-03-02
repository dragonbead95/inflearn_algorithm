package section04_BTS_04;

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
		
		// ���ο� ��尡(�� �����Ͱ� ��� ��尡) �߰��� ��ġ�� ã�´�.
		while(cNode != null)
		{
			if(data==GetData(cNode))
			{
				return null;		// �������� �ߺ��� ������� ����
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
		
		// pNode�� �ڽ� ���� �߰��� ������� ����
		nNode = MakeBTreeNode();	// ������� ����
		SetData(nNode, data);		// ������� ������ ����
		
		// pNode�� �ڽ� ���� �� ��带 �߰�
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
		}else {		// �� ��尡 ��Ʈ �����
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
		return null;	// Ž�� ����� ����Ǿ� ���� ����
	}

	@Override
	public BTreeNode RemoveLeftSubTree(BTreeNode bt) {
		// TODO Auto-generated method stub
		BTreeNode delNode = null;
		
		if(bt!=null)
		{
			delNode = bt.left;
			bt.left = null;
		}
		return delNode;
	}

	@Override
	public BTreeNode RemoveRightSubTree(BTreeNode bt) {
		// TODO Auto-generated method stub
		BTreeNode delNode = null;
		
		if(bt!=null)
		{
			delNode = bt.right;
			bt.right = null;
		}
		return delNode;
	}

	@Override
	public void ChangeLeftSubTree(BTreeNode main, BTreeNode sub) {
		// TODO Auto-generated method stub
		main.left = sub;
	}

	@Override
	public void ChangeRightSubTree(BTreeNode main, BTreeNode sub) {
		// TODO Auto-generated method stub
		main.right = sub;
	}

	@Override
	public BTreeNode BSTRemove(BTreeNode pRoot, int target) {
		// TODO Auto-generated method stub
		// ���� ����� ��Ʈ ����� ��츦 ������ ����ؾ� �Ѵ�.
		BTreeNode pVRoot = MakeBTreeNode();	// ���� ��Ʈ ���
		BTreeNode pNode = pVRoot;			// parent node
		BTreeNode cNode = pRoot;			// current node
		BTreeNode dNode;
		
		// ��Ʈ ��带 pVRoot�� ����Ű�� ����� ������ �ڽ� ��尡 �ǰ� �Ѵ�.
		ChangeRightSubTree(pVRoot, pRoot);
		
		// ���� ����� ��带 Ž��
		while(cNode != null && GetData(cNode)!=target)
		{
			pNode = cNode;
			
			if(target<GetData(cNode))
			{
				cNode = GetLeftSubTree(cNode);
			}
			else
			{
				cNode = GetRightSubTree(cNode);
			}
		}
		
		// ���� ����� �������� �ʴ´ٸ�
		if(cNode==null)
		{
			return null;
		}
		
		dNode = cNode;	// ���� ����� dNode�� ����Ű�� �Ѵ�.
		
		// ù��° ��� : ���� ����� �ܸ� ����� ���
		if(GetLeftSubTree(dNode)==null && GetRightSubTree(dNode)==null)
		{
			if(GetLeftSubTree(pNode)==dNode)
			{
				RemoveLeftSubTree(pNode);
			}
			else
			{
				RemoveRightSubTree(pNode);
			}
		}
		// �� ��° ��� : ���� ����� �ϳ��� �ڽ� ��带 ���� ���
		else if(GetLeftSubTree(dNode)==null || GetRightSubTree(dNode)==null)
		{
			BTreeNode dcNode;	// ���� ����� �ڽ� ��带 ����Ŵ
			
			if(GetLeftSubTree(dNode)!=null)
			{
				dcNode = GetLeftSubTree(dNode);
			}
			else
			{
				dcNode = GetRightSubTree(dNode);
			}
			
			if(GetLeftSubTree(pNode)==dNode)
			{
				ChangeLeftSubTree(pNode, dcNode);
			}
			else
			{
				ChangeRightSubTree(pNode, dcNode);
			}
		}
		// �� ��° ��� : �� ���� �ڽ� ��带 ��� ���� ���
		else 
		{
			BTreeNode mNode = GetRightSubTree(dNode);	// ��ü ��� ����Ŵ
			BTreeNode mpNode = dNode;	// ��ü ����� �θ� ��� ����Ŵ
			int delData;
			
			// ���� ����� ��ü ��带 ã�´�.
			while(GetLeftSubTree(mNode)!=null)
			{
				mpNode = mNode;
				mNode = GetLeftSubTree(mNode);
			}
			
			// ��ü ��忡 ����� ���� ������ ��忡 �����Ѵ�.
			delData = GetData(dNode);	// ���� �� ������ ���
			SetData(dNode, GetData(mNode));
			
			// ��ü ����� �θ� ���� �ڽ� ��带 �����Ѵ�.
			if(GetLeftSubTree(mpNode)==mNode)
			{
				ChangeLeftSubTree(mpNode, GetRightSubTree(mNode));
			}
			else 
			{
				ChangeRightSubTree(mpNode, GetRightSubTree(mNode));
			}
			
			dNode = mNode;
			SetData(dNode, delData); // ��� ������ ����
		}
		
		// ������ ��尡 ��Ʈ ����� ��쿡 ���� �߰����� ó��
		if(GetRightSubTree(pVRoot)!=pRoot)
		{
			pRoot = GetRightSubTree(pVRoot);	// ��Ʈ ����� ������ �ݿ�
		}
		
		pVRoot = null; // ���� ��Ʈ ����� �Ҹ�
		
		return dNode;
	}

	@Override
	public void BSTShowAll(BTreeNode bst) {
		// TODO Auto-generated method stub
		InorderTraverse(bst);
	}

}
