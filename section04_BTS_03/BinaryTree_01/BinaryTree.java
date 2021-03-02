package section04_BTS_03.BinaryTree_01;

public interface BinaryTree {
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
}
