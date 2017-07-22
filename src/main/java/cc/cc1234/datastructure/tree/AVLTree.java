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
		int bf; // 平衡因子
		TreeNode<E> leftChild;
		TreeNode<E> rightChild;
		TreeNode<E> parent;
		public TreeNode(E v) {
			this.v = v;
		}
		@Override
		public String toString() {
			return " [v=" + v + ", bf=" + bf + ", parent=" + parent + "]";
		}
		
	}
	/**
	 * 添加元素，保持平衡规则 
	 */
	public boolean add(E e) {
		if(root == null) {
			root = new TreeNode<E>(e);
			size++;
			return true;
		}else {
			TreeNode<E> node = root;
			while(true) {
				int c = e.compareTo(node.v);
				if(c == -1 ) {
					if(node.leftChild!=null) {
						node = node.leftChild;
					}else {
						node.leftChild = new TreeNode<E>(e);
						node.leftChild.parent = node;
						updateBF(node); // 插入节点后需要维护平衡因子
						if(node.bf==1 && node.parent!=null && node.parent.bf==1) { // 连续两层节点的平衡因子为1，说明该子树已经破坏了平衡
							balance(node.parent);
						}
						size++;
						return true;
					}
				}else {
					if(node.rightChild!=null) {
						node = node.rightChild;
					}else {
						node.rightChild = new TreeNode<E>(e);
						node.rightChild.parent = node;
						updateBF(node);
						if(node.bf==1 && node.parent!=null && node.parent.bf==1) {
							balance(node.parent);
						}
						size++;
						return true;
					}
				}
			}
		}
	}
	
	private void updateBF(TreeNode<E> node) {
		if(node.bf == 1) {
			node.bf = 0;
		}else {
			node.bf = 1;
		}
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
	
	/*
	 * 平衡
	 */
	private void balance(TreeNode<E> node) {
		System.out.println("------- 开始自平衡旋转 -------");
		if(node.leftChild !=null && node.leftChild.leftChild!=null) { // 左左类型：直接右旋
			rrRoate(node);
		}else if(node.rightChild!=null && node.rightChild.rightChild!=null) { // 右右类型：直接左旋
			llRoate(node);
		}else if(node.leftChild!=null && node.leftChild.rightChild!=null) { // 左右类型：先左旋再右旋
			lrRoate(node);
		}else if(node.rightChild!=null && node.rightChild.leftChild!=null) { // 右左类型：先右旋再左旋
			rlRoate(node);
		}
	}
	
	private void rlRoate(TreeNode<E> node) {
		TreeNode<E> rc = node.rightChild;
		TreeNode<E> rl = rc.leftChild;
		
		rl.parent = node;
		node.rightChild = rl;
		rl.rightChild = rc;
		rc.parent = rl;
		
		rc.bf = 0;
		rl.bf = 1;
		llRoate(node);
	}

	private void lrRoate(TreeNode<E> node) {
		TreeNode<E> lc = node.leftChild;
		TreeNode<E> lr = lc.rightChild;
		
		lr.leftChild = lc;
		lr.parent = node;
		node.leftChild = lr;
		lc.parent = lr;
		
		lr.bf = 1;
		lc.bf = 0;
		rrRoate(node);
	}

	private void llRoate(TreeNode<E> node) {
		TreeNode<E> rc = node.rightChild;
		rc.parent = node.parent;
		if(node.parent!=null) {
			node.parent.rightChild = rc;
		}else {
			root = rc;
		}
		node.parent = rc;
		rc.leftChild = node;
		node.rightChild = null;
		
		node.bf = 0;
		rc.bf = 0;
	}
	
	private void rrRoate(TreeNode<E> node) {
		TreeNode<E> lc = node.leftChild;
		lc.parent = node.parent;
		if(node.parent!=null) {
			node.parent.leftChild = lc;
		}else {
			root = lc;
		}
		node.parent = lc;
		lc.rightChild = node;
		node.leftChild = null;
		
		node.bf = 0;
		lc.bf = 0;
	}
	
	public int size() {
		return size;
	}
	
	
	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<>();
		tree.add(7);
		tree.add(4);
		tree.add(10);
		tree.add(3);
		tree.add(2);
		System.out.println(tree.root);
		System.out.println(tree.root.leftChild);
		System.out.println(tree.root.rightChild);
		System.out.println(tree.root.leftChild.leftChild);
		System.out.println(tree.root.leftChild.rightChild);
	}
}
