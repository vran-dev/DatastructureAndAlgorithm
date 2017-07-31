package cc.cc1234.datastructure.tree;

public class BinaryTreeV2<E extends Comparable<? super E>> extends BaseTree<E>{
	
	private Node<E> root;
	
	private static class Node<E>{
		E e;
		Node<E> left;
		Node<E> right;
		public Node(E e) {
			super();
			this.e = e;
		}
		@Override
		public String toString() {
			return " [e=" + e + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	@Override
	public void insert(E e) {
		root = doInsert(root,e);
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
		root = doRemove(root,e);
		return e;
	}
	
	private Node<E> doRemove(Node<E> node,E e){
		if(node == null || e == null) {
			return null;
		}
		if(node.e.compareTo(e) == 0){
			Node<E> successor = successor(node);
			if(successor != null) {
				successor.left = node.left;
				successor.right = node.right;
			}
			return successor;
		}else if(node.e.compareTo(e) == 1) {
			node.left =  doRemove(node.left, e);
		}else {
			node.right = doRemove(node.right, e);
		}
		return node;
	}
	
	/**
	 * 寻找指定节点的后继
	 * @param node  指定节点
	 * @return
	 * @Date 2017年7月31日
	 */
	private Node<E> successor(Node<E> node){
		if(node == null) {
			return null;
		}
		
		if(node.left == null) {
			return node.right;
		}
		Node<E> pre = null;
		while(node.left!=null) {
			pre = node;
			node = node.left;
		}
		pre.left = null;
		return node;
	}
	
	@Override
	public String toString() {
		return "BinaryTreeV2 [root=" + root + "]";
	}

	public static void main(String[] args) {
		BaseTree<Integer> tree =  new BinaryTreeV2<>();
		tree.insert(8);
		tree.insert(9);
		tree.insert(6);
		tree.insert(7);
		tree.insert(4);
		tree.insert(3);
		System.out.println(tree);
		System.out.println(tree.remove(6));
		System.out.println(tree);
	}
}
