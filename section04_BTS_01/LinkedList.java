package section04_BTS_01;

public class LinkedList {
	/* head nof of link list */
	public static LNode head;
	
	/* Link list Node */
	class LNode
	{
		int data;
		LNode next, prev;
		
		LNode(int d)
		{
			data = d;
			next = null;
			prev = null;
		}
	}
	
	/* A Binary Tree Node */
	class TNode
	{
		int data;
		TNode left, right;
		
		TNode(int d)
		{
			data = d;
			left = null;
			right = null;
		}
	}
	
	/*This function counts the number of nodes in Linked List
	 * and then calss sortedListToBSTRecur() to construct BST */
	public TNode sortedListToBST()
	{
		/*Count the number of nodes in Linked List */
		int n = countNodes(head);
		
		/* Construct BST*/
		return sortedListToBSTRecur(n);
	}
	
	/* The main function that constructs balanced BST and
	 * returns root of it.
	 * n --> No. of nodes in the Doubly Linked List
	 * */
	TNode sortedListToBSTRecur(int n)
	{
		/* Base Case */
		if(n<=0)
		{
			return null;
		}
		
		/* Recursively construct the left subtree */
		TNode left = sortedListToBSTRecur(n/2);
		
		/* head_ref now refers to middle node,
		 * make middle node as root of BST */
		TNode root = new TNode(head.data);
		
		// Set Pointer to left subtree
		root.left = left;
		
		/* Change head potiner of Linked List for parent recursive calls*/
		head = head.next;
		
		/* Recursively construct the right subtree and link it
		 * with root. The number of nodes in right subtree is
		 * total nodes - nodes in left subtrees -1 (for root) */
		root.right = sortedListToBSTRecur(n-(n/2)-1);
		
		return root;
	}
	
	/* UTILITY FUNCTIONS */
	/* A utility function that returns count of nodes in a 
	 * given Linked List */
	int countNodes(LNode head)
	{
		int count = 0;
		LNode temp = head;
		while(temp != null)
		{
			temp = temp.next;
			count++;
		}
		return count;
	}
	
	/* Function to insert a node at the beginging of
	 * the Doubly Linked List */
	public void push(int new_data)
	{
		/* allocate node */
		LNode new_node = new LNode(new_data);
		
		/* since we are adding at the beginning,
		 * prev is always NULL */
		new_node.prev = null;
		
		/* link the old list off the new node*/
		new_node.next = head;
		
		/* change prev of head node to new node*/
		if(head!=null)
		{
			head.prev = new_node;
		}
		
		/* move the head to point the new node*/
		head = new_node;
	}
	
	/* Function to print nodes in a given linked list */
    public void printList(LNode node)  
    { 
        while (node != null)  
        { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
	
	/* A utility function to print preorder traversal of BST*/
	void preOrder(TNode node)
	{
		if(node==null)
		{
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/* A utility function to print Inorder traversal of BST*/
	void inOrder(TNode node)
	{
		if(node==null)
		{
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}
	
	/* A utility function to print Postorder traversal of BST*/
	void postOrder(TNode node)
	{
		if(node==null)
		{
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}
	
	TNode searchTree(TNode x, int k)
	{
		if(x==null || k==x.data)
		{
			return x;
		}
		if(k<x.data)
		{
			return searchTree(x.left, k);
		}else 
		{
			return searchTree(x.right, k);
		}
	}
	
	TNode Iterative_searchTree(TNode x, int k)
	{
		while(x!=null && k!=x.data)
		{
			if(k<x.data)
			{
				x = x.left;
			}
			else
			{
				x = x.right;
			}
		}
		return x;
	}
}
