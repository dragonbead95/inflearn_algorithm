package section04_Sort_01;


import section04_Sort_01.LinkedList;
import section04_Sort_01.LinkedList.TNode; 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Start with the empty list */
		LinkedList llist = new LinkedList();
	
		/* Let us create a sorted linked list to test the functions
		 * Created linked list will be 1->2->3->4->5->6->7*/
		llist.push(7);
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		
		System.out.println("Given Linked List");
		llist.printList(llist.head);
		
		/* Convert List to BST */
		TNode root = llist.sortedListToBST();
		System.out.println("");
		System.out.println("Pre-Order Traversal of constructed BST");
		llist.preOrder(root);
		System.out.println("");
		System.out.println("In-Order Traversal of constructed BST");
		llist.inOrder(root);
		System.out.println("");
		System.out.println("Post-Order Traversal of constructed BST");
		llist.postOrder(root);
		
		System.out.println("");
		System.out.println("recursive search 3");
		System.out.println(llist.searchTree(root, 3).data);
		System.out.println("");
		System.out.println("Iterative search 3");
		System.out.println(llist.Iterative_searchTree(root, 3).data);
	}

}
