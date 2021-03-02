package section04_BTS_04;

public interface BinarySearchTree{
	
	public class BTreeNode{
		int data;
		BTreeNode left;
		BTreeNode right;
	}
	
	public BTreeNode MakeBTreeNode();	// 이진 트리 노드를 생성하여 객체 반환
	public int GetData(BTreeNode bt);				// 노드에 저장된 데이터 반환
	public void SetData(BTreeNode bt, int data);		// 노드에 데이터 저장, data로 전달된 값을 저장
	
	public BTreeNode GetLeftSubTree(BTreeNode bt);			// 왼쪽 서브트리 객체 반환
	public BTreeNode GetRightSubTree(BTreeNode bt);		// 오른쪽 서브트리 객체 반환
	
	public void MakeLeftSubTree(BTreeNode main, BTreeNode sub);	// 왼쪽 서브 트리 연결
	public void MakeRightSubTree(BTreeNode main, BTreeNode sub);	// 오른쪽 서브 트리 연결
	
	public void PreorderTraverse(BTreeNode bt);
	public void InorderTraverse(BTreeNode bt);
	public void PostorderTraverse(BTreeNode bt);
	
	// 왼쪽 자식 노드를 트리에서 제거, 제거된 노드의 주소 값이 반환된다.
	public BTreeNode RemoveLeftSubTree(BTreeNode bt);
	
	// 오른족 자식 노드를 트리에서 제거, 제거된 노드의 주소 값이 반환된다.
	public BTreeNode RemoveRightSubTree(BTreeNode bt);
	
	// 메모리 소멸을 수반하지 않고 main의 왼쪽 자식 노드를 변경한다.
	public void ChangeLeftSubTree(BTreeNode main, BTreeNode sub);
	
	// 메모리 소멸을 수반하지 않고 main의 오른쪽 자식 노드를 변경한다.
	public void ChangeRightSubTree(BTreeNode main, BTreeNode sub);
	
	
	
	// BST의 생성 및 초기화
	public void BSTMakeAndInit(BTreeNode pRoot);
	
	// 노드에 저장된 데이터 반환
	public int BSTGetNodeData(BTreeNode bst);
	
	// BST를 대상으로 데이터 저장(노드의 생성과정 포함)
	public BTreeNode BSTInsert(BTreeNode pRoot, int data);
	
	// BST를 대상으로 데이터 탐색
	public BTreeNode BSTSearch(BTreeNode bst, int target);
	
	// 트리에서 노드를 제거하고 제거된 노드의 주소 값을 반환한다.
	public BTreeNode BSTRemove(BTreeNode pRoot, int target);
	
	// 이전 탐색 트리에 저장된 모든 노드의 데이터를 출력한다.
	public void BSTShowAll(BTreeNode bst);
	
	
}
