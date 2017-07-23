package cc.cc1234.datastructure.tree;


/**
 * AVL树本质上还是一棵二叉树，特点
 * 1 本身是一棵二叉树
 * 2 每个节点的左右子树的高度之差绝对值不能大于1
 * 
 * @author vran1
 *
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
//		TreeNode<E> parent;

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
	 * 平衡
	 */
	private TreeNode<E> balance(TreeNode<E> node) {
		if(height(node.leftChild) - height(node.rightChild) > 1) { // 左子树  > 右子树
			if(height(node.leftChild.leftChild) > height(node.leftChild.rightChild)) { // LL
				
			}else { // LR
				
			}
		}else if(height(node.rightChild) - height(node.leftChild) > 1) { // 右子树 > 左子树
			if(height(node.rightChild.leftChild) > height(node.rightChild.rightChild)) { // RR
				
			}else { // LR
				
			}
		}
		node.height = Integer.max(height(node.leftChild), height(node.rightChild))+1;
		return node;
	}
	
	private TreeNode<E> rotateWithLeftChild(TreeNode<E> node){
		TreeNode<E> n = node.leftChild;
		node.leftChild = n.rightChild;
		n.rightChild = node;
		
		node.height=Integer.max(height(node.leftChild), n.height)+1;
		n.height=Integer.max(height(n.leftChild), height(n.rightChild))+1;
		return n;
	}
	
	private TreeNode<E> doubleWithLeftChlid(TreeNode<E> node){
		
		return null;
	}
	
	private int height(TreeNode<E> node) {
		return node == null?-1:node.height;
	}

	/**
	 * @param p 以p为根节点进行 右旋
	 * @return 当前旋转过后的子树根节点
	 */
	private TreeNode<E> rightRoate(TreeNode<E> p) {
		if(p != null) {
			TreeNode<E> lc = p.leftChild;
			p.leftChild = lc.rightChild;
			lc.rightChild = p;
			return lc;
		}
		return null;
	}

	/**
	 * @param p 以p为根节点左旋
	 * @return 当前旋转过后的子树根节点
	 */
	private TreeNode<E> leftRoate(TreeNode<E> p) {
		if(p != null) {
			TreeNode<E> rc = p.rightChild;
			p.rightChild = rc.leftChild;
			rc.leftChild = p;
			return  rc;
		}
		return null;
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

	private int calcLevel(TreeNode<E> node) {
		if(node == null) { return 0; }
		return Integer.max(calcLevel(node.leftChild), calcLevel(node.rightChild))+1;
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
