package cc.cc1234.algorithm.tree;

/**
 * 树的遍历递归算法：
 * 前序遍历
 * 后序遍历
 * 中序遍历
 * @author vran
 * @date 2017-07-26 18:25:00
 */
public class TreeTraversal {
	/**
	 * 树节点
	 */
	private static class TreeNode<E>{
		E v;
		TreeNode<E> left;
		TreeNode<E> right;
		
		public TreeNode(E v, TreeNode<E> left, TreeNode<E> right) {
			super();
			this.v = v;
			this.left = left;
			this.right = right;
		}
	}
	
	
	/**
	 * 前序遍历：根->左->右
	 * @param node
	 * @Date 2017年7月26日
	 */
	public <E> void preOrder(TreeNode<E> node) {
		if(node!=null) {
			System.out.println(node.v);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	/**
	 * 中序遍历：左->根->右
	 * @param node
	 * @Date 2017年7月26日
	 */
	public <E> void inOrder(TreeNode<E> node) {
		if(node!=null) {
			inOrder(node.left);
			System.out.println(node.v);
			inOrder(node.right);
		}
	}
	
	/**
	 * 后序遍历：左->右->根
	 * @param node
	 * @Date 2017年7月26日
	 */
	public <E> void postOrder(TreeNode<E> node) {
		if(node!=null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.v);
		}
	}
}
