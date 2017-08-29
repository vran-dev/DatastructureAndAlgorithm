package cc.cc1234.datastructure.heap;

import java.util.Comparator;

/**
 * 左式堆
 * 
 * @author vran
 *
 */
public class LeftistHeap<E> {
	private Comparator<E> cmp;
	private Node<E> root;

	private static class Node<E> {
		E e;
		Node<E> left;
		Node<E> right;
		int npl;
	}

	public LeftistHeap(Comparator<E> cmp) {
		this.cmp = cmp;
	}

	public void merge(LeftistHeap<E> heap) {
		if (this == heap) {
			return;
		}
		this.root = merge(this.root, heap.root);
		heap.root = null;
	}

	private Node<E> merge(Node<E> h1, Node<E> h2) {
		if (h1 == null) {
			return h2;
		}
		if (h2 == null) {
			return h1;
		}
		if (cmp.compare(h1.e, h2.e) < 0) {
			return doMerge(h1,h2);
		}else {
			return doMerge(h2,h1);
		}
	}

	private Node<E> doMerge(Node<E> h1, Node<E> h2) {
		if(h1.left == null) {
			h1.left = h2;
		}else {
			h1.right = merge(h1.right, h2);
			if(h1.left.npl < h1.right.npl) {
				swapChild(h1);
			}
			h1.npl = h1.right.npl +1;
		}
		return h1;
	}
	
	private void swapChild(Node<E> node) {
		Node<E> l = node.left;
		node.left = node.right;
		node.right = l;
	}
	

	public E findMin() {
		return null;
	}

	public E deleteMin() {
		return null;
	}

	public void clear() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}
}
