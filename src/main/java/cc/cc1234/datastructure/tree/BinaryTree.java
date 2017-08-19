package cc.cc1234.datastructure.tree;


/**
 * 二叉树：
 * 任意一个节点node，它的左子节点值小于它，右子节点大于它
 * @author vran
 */
public class BinaryTree<E extends Comparable<? super E>> extends BaseTree<E> {
	// 根节点
	TreeNode<E> root;

	private static class TreeNode<E>{
		E v;
		TreeNode<E> left;
		TreeNode<E> right;

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
		while(node != null) {
			int c = e.compareTo(node.v);
			if(c == 1) {
				pre = node;
				node = node.right;
			}else if(c == -1) {
				pre = node;
				node = node.left;
			}else {
				size--;
				return removeNode(pre,node).v;
			}
		}
		return null;
	}

	private TreeNode<E> removeNode(TreeNode<E> p,TreeNode<E> node) {
		if(node.left == null) { // 左空 右不空 | 左右皆为空
			if(p == null) {  
				root = node.right;
			}else {
				if(p.left.v.compareTo(node.v) == 0) {
					p.left = node.right;
				}else {
					p.right = node.right;
				}
			}
			return node;
		}

		if(node.right == null) {
			if(p == null) {
				root = node.left;
			}else {
				if(p.left.v.compareTo(node.v) == 0) {
					p.left = node.left;
				}else {
					p.right = node.left;
				}
			}
			return node;
		}

		// 左右皆不为空 
		TreeNode<E> successor = findSuccessor(node.right);
		if(successor.v.compareTo(node.right.v) != 0) {
			successor.right = node.right;
		}
		successor.left = node.left;

		if(p == null) {
			root = successor;
		}else {
			if(p.left.v.compareTo(node.v) == 0) {
				p.left = successor;
			}else {
				p.right = successor;
			}
		}

		return node;
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
		
		if(last!=null) {
			last.left = node.right;
			node.right = null;
		}
		return node;
	}


	public void preorder(TreeNode<E> node) {
		if(node!=null) {
			System.out.print(node.v+" -> ");
			preorder(node.left);
			preorder(node.right);
		}
	}

}
