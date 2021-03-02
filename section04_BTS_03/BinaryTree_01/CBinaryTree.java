package section04_BTS_03.BinaryTree_01;

import section04_BTS_03.BinaryTree_01.BinaryTree.BTreeNode;

public class CBinaryTree implements BinaryTree{

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



}
