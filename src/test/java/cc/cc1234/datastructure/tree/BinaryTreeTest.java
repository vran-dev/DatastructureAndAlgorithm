package cc.cc1234.datastructure.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {
	
	BinaryTree<Integer> v1;
	BinaryTreeV2<Integer> v2;
	
	@Before
	public void setUp() throws Exception {
		v1 = new BinaryTree<>();
		v2 = new BinaryTreeV2<>();
	}

	/**
	 * 
	 * 				8
	 * 			/	 	\
	 * 			6		10
	 * 		  /	  \   /	   \
	 *       3     7 9      13
	 *      / \
	 *     1   4
	 */
	@Test
	public void testBinaryTreeV1() {
		assertTrue(v1.size() == 0);
		v1.insert(8);
		v1.insert(6);
		v1.insert(10);
		v1.insert(3);
		v1.insert(7);
		v1.insert(9);
		v1.insert(13);
		v1.insert(1);
		v1.insert(4);
		assertTrue(v1.size() == 9);
		assertTrue(v1.contains(13));
		assertTrue(v1.contains(1));
		assertTrue(v1.contains(4));
		assertTrue(v1.contains(6));
		assertTrue(v1.contains(8));
		assertTrue(!v1.contains(0));
		
		assertTrue(v1.remove(6).equals(6));
		assertTrue(v1.size() == 8);
		
		assertTrue(v1.remove(8).equals(8));
		assertTrue(v1.size() == 7);
		v1.preorder(v1.root);
	}
	
	@Test
	public void testBinaryTreeV2() {
		assertTrue(v2.size() == 0);
		v2.insert(8);
		v2.insert(6);
		v2.insert(10);
		v2.insert(3);
		v2.insert(7);
		v2.insert(9);
		v2.insert(13);
		v2.insert(1);
		v2.insert(4);
		assertTrue(v2.size() == 9);
		assertTrue(v2.contains(13));
		assertTrue(v2.contains(1));
		assertTrue(v2.contains(4));
		assertTrue(v2.contains(6));
		assertTrue(v2.contains(8));
		assertTrue(!v2.contains(0));
		
		assertTrue(v2.remove(6).equals(6));
		assertTrue(v2.size() == 8);
		
		assertTrue(v2.remove(8).equals(8));
//		v2.preOrder(v2.root);
		assertTrue(v2.size() == 7);
	}

}
