package section04_BTS_03.BinaryTree_01;

public interface BinaryTree {
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
}
