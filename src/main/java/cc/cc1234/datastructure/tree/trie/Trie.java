package cc.cc1234.datastructure.tree.trie;

import java.util.HashSet;
import java.util.Set;

/**
 * 前缀树
 * @author vran
 * @date 2017-07-27 14:16:32
 */
public class Trie {
	private Node root;

	private static class Node{
		Character v;
		Set<Node> childs;
		boolean red; // 节点为红色,代表该节点的单词存在

		public Node() {
			this(null);
		}

		public Node(Character v) {
			this.v = v;
			childs = new HashSet<>();
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", childs=" + childs + ", red=" + red + "]";
		}
	}

	public Trie() {
		root = new Node();
	}

	/*
	 * 插入
	 */
	public void insert(String word) {
		char[] charArray = word.toCharArray();
		Node n = root;
		for(int i=0;i<charArray.length;i++) {														
			char c = charArray[i];
			Node t = findNodeFromChilds(n, c);
			if(t == null) {
				t = new Node(c);
				n.childs.add(t);
			}
			n = t;
		}
		n.red = true;
	}

	/*
	 * 查找
	 */
	public boolean find(String word) {
		char[] charArray = word.toCharArray();
		Node n = root;
		for(int i=0;i<charArray.length;i++) {
			Node t = findNodeFromChilds(n, charArray[i]);
			if(t == null) {
				return false;
			}
			n=t;
		}
		return n.red;
	}

	/*
	 * 是否包含前缀
	 */
	public boolean containsPrefix(String prefix) {
		char[] charArray = prefix.toCharArray();
		Node n = root;
		for(int i=0;i<charArray.length;i++) {
			Node t = findNodeFromChilds(n, charArray[i]);
			if(t == null) {
				return false;
			}
			n = t;
		}
		return true;
	}

	private Node findNodeFromChilds(Node n,char c) {
		if(n == null || n.childs.size()==0) {
			return null;
		}
		return n.childs.stream().filter(node->node.v.equals(c)).findFirst().orElse(null);
	}

	@Override
	public String toString() {
		return  root.toString();
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("hello");
		System.out.println(trie);
		trie.insert("helle");
		System.out.println(trie);
		trie.insert("he");
		System.out.println(trie);
		System.out.println(trie.find("hello"));
		System.out.println(trie.find("helle"));
		System.out.println(trie.find("hellel"));
		System.out.println(trie.containsPrefix("he"));
		System.out.println(trie.containsPrefix("hello"));
		System.out.println(trie.containsPrefix("hellol"));
	}
}
