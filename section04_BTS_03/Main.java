package section04_BTS_03;

import section04_BTS_03.BinaryTree.BTreeNode;

public class Main {

	public static void main(String[] args) {
		CBinaryTree c = new CBinaryTree();
		BTreeNode bt1 = c.MakeBTreeNode();
		BTreeNode bt2 = c.MakeBTreeNode();
		BTreeNode bt3 = c.MakeBTreeNode();
		BTreeNode bt4 = c.MakeBTreeNode();
		BTreeNode bt5 = c.MakeBTreeNode();
		BTreeNode bt6 = c.MakeBTreeNode();
		
		c.SetData(bt1, 1);
		c.SetData(bt2, 2);
		c.SetData(bt3, 3);
		c.SetData(bt4, 4);
		c.SetData(bt5, 5);
		c.SetData(bt6, 6);
		
		c.MakeLeftSubTree(bt1, bt2);
		c.MakeRightSubTree(bt1, bt3);
		c.MakeLeftSubTree(bt2, bt4);
		c.MakeRightSubTree(bt2, bt5);
		c.MakeRightSubTree(bt3, bt6);
		
		//System.out.println(c.GetData(c.GetLeftSubTree(bt1))); // 2
		//System.out.println(c.GetData(c.GetLeftSubTree(c.GetLeftSubTree(bt1)))); // 4
		
		c.PreorderTraverse(bt1);
		System.out.println();
		c.InorderTraverse(bt1);
		System.out.println();
		c.PostorderTraverse(bt1);
		System.out.println();
		
	}

}
