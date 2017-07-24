package cc.cc1234.datastructure.tree;


/**
 * @author vran
 * @date 2017-07-24 09:13:33
 */
public class AVLTree<E extends Comparable<? super E>> {
	// 树的根节点
	private TreeNode<E> root;
	private int size;
	private static class TreeNode<E>{
		E v;
		int height; // 高度
		TreeNode<E> leftChild;
		TreeNode<E> rightChild;

		public TreeNode(E v) {
			this.v = v;
		}

		@Override
		public String toString() {
			return "TreeNode [v=" + v ;
		}

	}


	/**
	 * 添加元素，保持平衡规则 
	 */
	public boolean add(E e) {
		root = doAdd(e, root);
		size++;
		return true;
	}

	private TreeNode<E> doAdd(E e , TreeNode<E> node) {
		if(node == null) {
			return new TreeNode<E>(e);
		}
		int c = e.compareTo(node.v);
		if(c>1) {
			node.rightChild = doAdd(e, node.rightChild);
		}else if(c<1) {
			node.leftChild = doAdd(e, node.leftChild);
		}else { 
			// 相等的情况不做任何处理 
		}

		return balance(node);
	}

	/*
	 * 平衡操作
	 */
	private TreeNode<E> balance(TreeNode<E> node) {
		if(height(node.leftChild) - height(node.rightChild) > 1) { // 左子树  > 右子树
			if(height(node.leftChild.leftChild) > height(node.leftChild.rightChild)) { // LL
				rightRoate(node);
			}else { // LR
				doubleRoateWithLeftChild(node);
			}
		}else if(height(node.rightChild) - height(node.leftChild) > 1) { // 右子树 > 左子树
			if(height(node.rightChild.rightChild) > height(node.rightChild.leftChild)) { // RR
				rightRoate(node);
			}else { // RL
				doubleRoateWithRightChild(node);
			}
		}
		node.height = Integer.max(height(node.leftChild), height(node.rightChild))+1;
		return node;
	}
	
	/**
	 * 单次右旋
	 * @param node 带旋转子树的根节点
	 * @return 旋转后新树的根节点
	 * @Date 2017年7月24日
	 */
	/**
	 * @param node
	 * @return
	 */
	private TreeNode<E> rightRoate(TreeNode<E> node){
		TreeNode<E> l = node.leftChild;
		node.leftChild = l.rightChild;
		l.rightChild = node;
		
		node.height=Integer.max(height(node.leftChild), height(node.rightChild))+1;
		l.height=Integer.max(height(l.leftChild), node.height)+1;
		return l;
	}
	
	/**
	 * 单次左旋
	 * @param node 带旋转子树的根节点
	 * @return 旋转后新树的根节点
	 */
	private TreeNode<E> leftRoate(TreeNode<E> node){
		TreeNode<E> r = node.rightChild;
		node.rightChild = r.leftChild;
		r.leftChild = node;
		
		node.height = Integer.max(height(node.rightChild), height(node.leftChild)) + 1;
		r.height = Integer.max(height(r.rightChild), node.height)+1;
		return r;
	}
	
	/**
	 * 右旋 -> 左旋 RL
	 * @param node
	 * @return
	 */
	private TreeNode<E> doubleRoateWithRightChild(TreeNode<E> node){
		// 右旋
		rightRoate(node.leftChild);
		// 左旋
		return leftRoate(node);
	}
	
	/**
	 * 左旋 -> 右旋 LR
	 * @param node
	 * @return
	 */
	private TreeNode<E> doubleRoateWithLeftChild(TreeNode<E> node){
		// 左旋
		leftRoate(node.leftChild);
		// 右旋
		return rightRoate(node);
	}
	
	private int height(TreeNode<E> node) {
		return node == null?-1:node.height;
	}

	public boolean contains(E e) {
		TreeNode<E> node = root;
		while(node!=null) {
			int c = node.v.compareTo(e);
			if(c == 1) {
				return true;
			}else if(c == -1) {
				node = node.rightChild;
			}else { // c==1
				node = node.leftChild;
			}
		}
		return false;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<>();
		TreeNode<Integer> root =new TreeNode<>(7);
		root.leftChild = new TreeNode<Integer>(6);
		root.leftChild.leftChild  = new TreeNode<Integer>(5);
		root.leftChild.leftChild.leftChild  = new TreeNode<Integer>(4);
		root.leftChild.leftChild.leftChild.leftChild = new TreeNode<Integer>(3);
		root.leftChild = tree.rightRoate(root.leftChild);

		System.out.println(root);
		System.out.println(root.leftChild);
		System.out.println(root.leftChild.leftChild);
		System.out.println(root.leftChild.rightChild);
	}
}
