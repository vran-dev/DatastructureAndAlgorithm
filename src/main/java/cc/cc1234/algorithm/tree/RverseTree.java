package cc.cc1234.algorithm.tree;


/**
 * 翻转二叉树
 * @author vran1
 */
public class RverseTree {

	private static class TreeNode<E> {
		E v;
		TreeNode<E> leftChild;
		TreeNode<E> rightChild;

		public TreeNode(E v, TreeNode<E> leftChild, TreeNode<E> rightChild) {
			this.v = v;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		public TreeNode(E v) {
			this.v = v;
		}

		@Override
		public String toString() {
			return "[v=" + v + ", l=" + leftChild + ", r=" + rightChild + "]";
		}
		
	}

	public static TreeNode reverse(TreeNode node) {
		if(node == null) {
			return null;
		}
		TreeNode lc = node.leftChild;
		TreeNode rc = node.rightChild;
		node.leftChild = reverse(rc);
		node.rightChild = reverse(lc);
		return node;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> node =new TreeNode<>(1,new TreeNode<>(2,new TreeNode<>(4),new TreeNode<>(5)),new TreeNode<>(3));
		System.out.println(node);
		TreeNode<Integer> reverse = reverse(node);
		System.out.println(node);
	}
}
