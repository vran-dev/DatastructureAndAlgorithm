package cc.cc1234.algorithm.tree;

import cc.cc1234.datastructure.queue.Queue;
import cc.cc1234.datastructure.queue.imp.LinkedQueue;

/**
 * 计算树的层高(基于队列来实现)
 * @author vran1
 *
 */
public class CalcTreeLevel {
	
	private static class TreeNode<E>{
		E v;
		TreeNode<E> left;
		TreeNode<E> right;
		
		public TreeNode(E v, TreeNode<E> left, TreeNode<E> right) {
			this.v = v;
			this.left = left;
			this.right = right;
		}
		
		public TreeNode(E v, TreeNode<E> left) {
			this.v = v;
			this.left = left;
			this.right = right;
		}
		
		public TreeNode(E v) {
			this.v = v;
		}
		
	}
	
	public static int level(TreeNode root) {
		if(root == null) {
			return -1;
		}
		return calcByQueue(root);
	}
	
	/**
	 * 该方法不仅可以计算树的总的层高，还可以记录每层的元素个数
	 */
	private static int calcByQueue(TreeNode root) {
		Queue<TreeNode> a = new LinkedQueue<>();
		Queue<TreeNode> b = new LinkedQueue<>();		
		a.add(root);
		int level = 1;
		
		while(!a.isEmpty() || !b.isEmpty() ) {
			while(!a.isEmpty()) {
				TreeNode n = a.poll();
				if(n.left!=null) {
					b.add(n.left);
				}
				
				if(n.right!=null) {
					b.add(n.right);
				}
			}
			if(!b.isEmpty()) {
				level++;
			}
			while(!b.isEmpty()) {
				TreeNode n = b.poll();
				if(n.left!=null) {
					a.add(n.left);
				}
				
				if(n.right!=null) {
					a.add(n.right);
				}
			}
			if(!a.isEmpty()) {
				level++;
			}
		}
		return level;
	}
	
	private static int calcByRecursion(TreeNode node) {
		if(node == null) {
			return 0;
		}
		return Integer.max(calcByRecursion(node.left), calcByRecursion(node.right))+1;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1,new TreeNode<>(2,new TreeNode<>(4,new TreeNode<>(4,new TreeNode<>(4)))),new TreeNode<>(3));
		int l = CalcTreeLevel.level(root);
		System.out.println("level = "+l);
		int l2 = CalcTreeLevel.calcByRecursion(root);
		System.out.println("level = "+l2);
	}
}
