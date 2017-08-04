package cc.cc1234.datastructure.union;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * 并查集
 * 
 * quickfind 查找时间复杂度只有O(1)
 * 
 * @author vran1
 *
 */
public class UnionFindTest {
	
	private UnionFind union;
	
	@Before
	public void setup() {
		union = new UnionFind(10);
	}
	
	@Test
	public void testUnionFind() {
		for(int i=0;i<10;i++) {
			assertTrue(union.find(i) == i);
			assertTrue(union.isConnected(i, i));
		}
		
		assertTrue(union.union(0, 2));
		assertTrue(union.union(1, 2));
		assertTrue(union.union(2, 7));
		
		assertTrue(union.union(5, 4));
		assertTrue(union.union(3, 4));
		
		assertTrue(union.isConnected(0, 7));
		assertTrue(union.isConnected(1, 7));
		assertTrue(union.isConnected(2, 7));
		
		assertTrue(union.isConnected(0, 1));
		assertTrue(union.isConnected(3, 5));
		
		assertTrue(!union.isConnected(1, 3));
		assertTrue(!union.isConnected(4, 6));
		
	}

}
