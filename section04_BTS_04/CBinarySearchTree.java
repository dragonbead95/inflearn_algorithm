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
		// 삭제 대상이 루트 노드인 경우를 별도로 고려해야 한다.
		BTreeNode pVRoot = MakeBTreeNode();	// 가상 루트 노드
		BTreeNode pNode = pVRoot;			// parent node
		BTreeNode cNode = pRoot;			// current node
		BTreeNode dNode;
		
		// 루트 노드를 pVRoot가 가리키는 노드의 오른쪽 자식 노드가 되게 한다.
		ChangeRightSubTree(pVRoot, pRoot);
		
		// 삭제 대상인 노드를 탐색
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
		
		// 삭제 대상이 존재하지 않는다면
		if(cNode==null)
		{
			return null;
		}
		
		dNode = cNode;	// 삭제 대상을 dNode가 가리키게 한다.
		
		// 첫번째 경우 : 삭제 대상이 단말 노드인 경우
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
		// 두 번째 경우 : 삭제 대상이 하나의 자식 노드를 갖는 경우
		else if(GetLeftSubTree(dNode)==null || GetRightSubTree(dNode)==null)
		{
			BTreeNode dcNode;	// 삭제 대상의 자식 노드를 가리킴
			
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
		// 세 번째 경우 : 두 개의 자식 노드를 모두 갖는 경우
		else 
		{
			BTreeNode mNode = GetRightSubTree(dNode);	// 대체 노드 가리킴
			BTreeNode mpNode = dNode;	// 대체 노드의 부모 노드 가리킴
			int delData;
			
			// 삭제 대상의 대체 노드를 찾는다.
			while(GetLeftSubTree(mNode)!=null)
			{
				mpNode = mNode;
				mNode = GetLeftSubTree(mNode);
			}
			
			// 대체 노드에 저장된 값을 삭제할 노드에 대입한다.
			delData = GetData(dNode);	// 대입 전 데이터 백업
			SetData(dNode, GetData(mNode));
			
			// 대체 노드의 부모 노드와 자식 노드를 연결한다.
			if(GetLeftSubTree(mpNode)==mNode)
			{
				ChangeLeftSubTree(mpNode, GetRightSubTree(mNode));
			}
			else 
			{
				ChangeRightSubTree(mpNode, GetRightSubTree(mNode));
			}
			
			dNode = mNode;
			SetData(dNode, delData); // 백업 데이터 복원
		}
		
		// 삭제된 노드가 루트 노드인 경우에 대한 추가적인 처리
		if(GetRightSubTree(pVRoot)!=pRoot)
		{
			pRoot = GetRightSubTree(pVRoot);	// 루트 노드의 변경을 반영
		}
		
		pVRoot = null; // 가상 루트 노드의 소멸
		
		return dNode;
	}

	@Override
	public void BSTShowAll(BTreeNode bst) {
		// TODO Auto-generated method stub
		InorderTraverse(bst);
	}

}
