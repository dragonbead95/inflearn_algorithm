package section04_BTS_04;

public interface BinarySearchTree{
	
	public class BTreeNode{
		int data;
		BTreeNode left;
		BTreeNode right;
	}
	
	public BTreeNode MakeBTreeNode();	// ���� Ʈ�� ��带 �����Ͽ� ��ü ��ȯ
	public int GetData(BTreeNode bt);				// ��忡 ����� ������ ��ȯ
	public void SetData(BTreeNode bt, int data);		// ��忡 ������ ����, data�� ���޵� ���� ����
	
	public BTreeNode GetLeftSubTree(BTreeNode bt);			// ���� ����Ʈ�� ��ü ��ȯ
	public BTreeNode GetRightSubTree(BTreeNode bt);		// ������ ����Ʈ�� ��ü ��ȯ
	
	public void MakeLeftSubTree(BTreeNode main, BTreeNode sub);	// ���� ���� Ʈ�� ����
	public void MakeRightSubTree(BTreeNode main, BTreeNode sub);	// ������ ���� Ʈ�� ����
	
	public void PreorderTraverse(BTreeNode bt);
	public void InorderTraverse(BTreeNode bt);
	public void PostorderTraverse(BTreeNode bt);
	
	// ���� �ڽ� ��带 Ʈ������ ����, ���ŵ� ����� �ּ� ���� ��ȯ�ȴ�.
	public BTreeNode RemoveLeftSubTree(BTreeNode bt);
	
	// ������ �ڽ� ��带 Ʈ������ ����, ���ŵ� ����� �ּ� ���� ��ȯ�ȴ�.
	public BTreeNode RemoveRightSubTree(BTreeNode bt);
	
	// �޸� �Ҹ��� �������� �ʰ� main�� ���� �ڽ� ��带 �����Ѵ�.
	public void ChangeLeftSubTree(BTreeNode main, BTreeNode sub);
	
	// �޸� �Ҹ��� �������� �ʰ� main�� ������ �ڽ� ��带 �����Ѵ�.
	public void ChangeRightSubTree(BTreeNode main, BTreeNode sub);
	
	
	
	// BST�� ���� �� �ʱ�ȭ
	public void BSTMakeAndInit(BTreeNode pRoot);
	
	// ��忡 ����� ������ ��ȯ
	public int BSTGetNodeData(BTreeNode bst);
	
	// BST�� ������� ������ ����(����� �������� ����)
	public BTreeNode BSTInsert(BTreeNode pRoot, int data);
	
	// BST�� ������� ������ Ž��
	public BTreeNode BSTSearch(BTreeNode bst, int target);
	
	// Ʈ������ ��带 �����ϰ� ���ŵ� ����� �ּ� ���� ��ȯ�Ѵ�.
	public BTreeNode BSTRemove(BTreeNode pRoot, int target);
	
	// ���� Ž�� Ʈ���� ����� ��� ����� �����͸� ����Ѵ�.
	public void BSTShowAll(BTreeNode bst);
	
	
}
