package section04_BTS_04;

import section04_BTS_04.BinarySearchTree.BTreeNode;

public class BinarySearchTreeMain {
	
	public static void main(String[] args) {
		CBinarySearchTree c = new CBinarySearchTree();
		BTreeNode bstRoot = null;
		BTreeNode sNode;
		
		c.BSTMakeAndInit(bstRoot);
		
		bstRoot = c.BSTInsert(bstRoot, 5);
		bstRoot = c.BSTInsert(bstRoot, 8);
		bstRoot = c.BSTInsert(bstRoot, 1);
		bstRoot = c.BSTInsert(bstRoot, 6);
		bstRoot = c.BSTInsert(bstRoot, 4);
		bstRoot = c.BSTInsert(bstRoot, 9);
		bstRoot = c.BSTInsert(bstRoot, 3);
		bstRoot = c.BSTInsert(bstRoot, 2);
		bstRoot = c.BSTInsert(bstRoot, 7);
		
		c.BSTShowAll(bstRoot);
		System.out.println();
		sNode = c.BSTRemove(bstRoot, 3);
		sNode = null;
		
		c.BSTShowAll(bstRoot);
		System.out.println();
		sNode = c.BSTRemove(bstRoot, 8);
		sNode = null;
		
		c.BSTShowAll(bstRoot);
		System.out.println();
		sNode = c.BSTRemove(bstRoot, 1);
		sNode = null;
		
		c.BSTShowAll(bstRoot);
		System.out.println();
		sNode = c.BSTRemove(bstRoot, 6);
		sNode = null;
		
		c.BSTShowAll(bstRoot);
		System.out.println();
		
	}

}
