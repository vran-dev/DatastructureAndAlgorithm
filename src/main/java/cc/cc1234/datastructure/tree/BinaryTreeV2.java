package cc.cc1234.datastructure.tree;

/**
 * 二叉树实现V2(递归版)
 * @author vran
 * @date 2017-07-31 16:46:19
 */
public class BinaryTreeV2<E extends Comparable<? super E>> extends BaseTree<E>{

	Node<E> root;

	private static class Node<E>{
		E e;
		Node<E> left;
		Node<E> right;
		public Node(E e) {
			super();
			this.e = e;
		}
		
		public Node(Node<E> node) {
			this.e = node.e;
			this.left = node.left;
			this.right = node.right;
		}
		
		@Override
		public String toString() {
			return " [e=" + e + ", left=" + left + ", right=" + right + "]";
		}
	}

	@Override
	public void insert(E e) {
		root = doInsert(root,e);
		size++;
	}

	private Node<E> doInsert(Node<E> node, E e){
		if(node == null) {
			return new Node<>(e);
		}

		if(node.e.compareTo(e) > 0) {
			node.left = doInsert(node.left,e);
		}else {
			node.right = doInsert(node.right,e);
		}
		return node;
	}

	@Override
	public boolean contains(E e) {
		Node<E> node = root;
		while(node!=null) {
			if(node.e.compareTo(e) == 0) {
				return true;
			}else if(node.e.compareTo(e) == 1) {
				node = node.left;
			}else {
				node = node.right;
			}
		}
		return false;
	}

	@Override
	public E remove(E e) {
		if(size == 0) {
			return null;
		}
		root = doRemove(root,e);
		return e;
	}

	private Node<E> doRemove(Node<E> node,E e){
		if(node == null || e == null) {
			return null;
		}

		if(node.e.compareTo(e) == 0){
			if(node.left == null) {
				Node<E> n = node.right;
				node.right = null;
				size--;
				return n;
			}

			if(node.right == null) {
				Node<E> n = node.left;
				node.left = null;
				size--;
				return n;
			}

			Node<E> successor = new Node<>(successor(node.right));
			successor.right = removeMin(node.right);
			successor.left = node.left;
			
			return successor;
		}else if(node.e.compareTo(e) == 1) {
			node.left =  doRemove(node.left, e);
			return node;
		}else {
			node.right = doRemove(node.right, e);
			return node;
		}
	}

	/**
	 * 返回指定节点的后继
	 * @param node  指定节点
	 * @return
	 * @Date 2017年7月31日
	 */
	private Node<E> successor(Node<E> node){
		if(node == null) {
			return null;
		}
		
		if(node.left == null) { // 此时表示node为后继节点
			return node;
		}else {
			return successor(node.left);
		}
	}
	
	private Node<E> removeMin(Node<E> node){
		if(node == null) {
			return null;
		}
		
		if(node.left == null) { // 此时表示node为后继节点
			Node<E> nodeRight = node.right;
			node.right = null;
			size--;
			return nodeRight;
		}
		
		node.left = removeMin(node.left);
		return node;
	}

	public void preOrder(Node<E> node) {
		if(node!=null) {
			System.out.print(node.e+"->");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	@Override
	public String toString() {
		return "BinaryTreeV2 [root=" + root + "]";
	}
}
