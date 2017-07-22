package cc.cc1234.datastructure.tree;


/**
 * 二叉树
 * @author vran
 */
public class BinaryTree<E extends Comparable<? super E>> extends BaseTree<E> {
	// 根节点
	TreeNode<E> root;

	private static class TreeNode<E>{
		E v;
		TreeNode<E> left;
		TreeNode<E> right;

		public TreeNode(E v, TreeNode<E> left, TreeNode<E> right) {
			this.v = v;
			this.left = left;
			this.right = right;
		}

		public TreeNode() {
			super();
		}

		public TreeNode(E v) {
			super();
			this.v = v;
		}

	}


	@Override
	public void insert(E e) {
		TreeNode<E> node =new TreeNode<>(e);
		if(root == null) {
			root = node;
		}else {
			TreeNode<E> last =root;
			TreeNode<E> n = root;
			while(n!=null) {
				last=n;
				if(e.compareTo(n.v) == 1) {
					n = n.right;
				}else {
					n = n.left;
				}
			}
			if(e.compareTo(last.v) == 1) {
				last.right=node;
			}else {
				last.left=node;
			}
		}
		size++;

	}


	@Override
	public boolean contains(E e) {
		TreeNode<E> node = root;
		while(node != null) {
			int c = e.compareTo(node.v);
			if(c == 0) {
				return true;
			}else if(c ==1 ) {
				node = node.right;
			}else {
				node = node.left;
			}
		}
		return false;
	}

	@Override
	public E remove(E e) {
		TreeNode<E> node = root;
		TreeNode<E> pre = null;
		boolean isleft = true;
		while(node != null) {
			int c = e.compareTo(node.v);
			if(c == 1) {
				pre = node;
				isleft = false;
				node = node.right;
			}else if(c == -1) {
				pre = node;
				isleft = true;
				node = node.left;
			}else {
				TreeNode<E> result = node;
				removeNode(pre,node,isleft);
				size--;
				return result.v;
			}
		}
		return null;
	}

	private void removeNode(TreeNode<E> parent,TreeNode<E> node, boolean isleft) {
		if( node.left == null && node.right == null) { // 左右子节点均为空
			node = null;
			updateRelation(parent, null, isleft);
		}else if(node.left == null) { // 左节点为空
			updateRelation(parent, node.right, isleft); 
		}else if(node.right == null){ // 右节点为空
			updateRelation(parent, node.left, isleft);
		}else { // 左右节点均不为空
			TreeNode<E> successor = findSuccessor(node.right);
			successor.left = node.left;
			successor.right = node.right;
			updateRelation(parent, successor, isleft);
		}
	}

	/**
	 * 寻找继任者
	 */
	private TreeNode<E> findSuccessor(TreeNode<E> param){
		TreeNode<E> node = param;
		TreeNode<E> last = null;
		while(node.left!=null) {
			last = node;
			node = node.left;
		}
		last.left = null;
		return node;
	}

	private void updateRelation(TreeNode<E> parent,TreeNode<E> node, boolean isleft) {
		if(parent == null) {
			root = node;
		}else {
			if(isleft) {
				parent.left = node;
			}else {
				parent.right = node;
			}
		}
	}


	public void preorder(TreeNode<E> node) {
		if(node!=null) {
			System.out.print(node.v+" -> ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(20);
		tree.insert(18);
		tree.insert(22);
		tree.insert(15);
		tree.insert(19);
		tree.insert(21);
		tree.insert(30);
		tree.insert(25);
		tree.insert(27);
		tree.insert(26);
		tree.insert(24);
		tree.preorder(tree.root);
		System.out.println("");

		System.out.println("remove 20="+tree.remove(20)+" size="+tree.size);
		tree.preorder(tree.root);
		System.out.println("");

		System.out.println("remove 19="+tree.remove(19)+" size="+tree.size);
		tree.preorder(tree.root);
		System.out.println("");

		System.out.println("remove 18="+tree.remove(18)+" size="+tree.size);
		tree.preorder(tree.root);
		System.out.println("");

		System.out.println("remove 25="+tree.remove(25)+" size="+tree.size);
		tree.preorder(tree.root);
		System.out.println("");
		
		System.out.println("remove 22="+tree.remove(22)+" size="+tree.size);
		tree.preorder(tree.root);
		System.out.println("");
	}

}
