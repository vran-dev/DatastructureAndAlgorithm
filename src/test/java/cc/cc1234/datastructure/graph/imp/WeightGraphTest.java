package cc.cc1234.datastructure.graph.imp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cc.cc1234.datastructure.graph.GraphIterator;

/**
 * 带权图测试用例
 * 
 * @author vran1
 *
 */
public class WeightGraphTest {
	private WeightGraph dense;
	private WeightGraph sparse;

	@Before
	public void before() {
		dense = new DenseWeightGraph(10);
		sparse = new SparseWeightGraph(10);
	}

	/**
	 * 稠密带权图 FROM TO 0 1,2,5 1 0,3 2 0,3,4 3 1,2,6 4 2,5,6,7,8 5 0,4,7 6 3,4,8 7
	 * 4,5,9 8 4,6,9 9 7,8
	 */

	@Test
	public void testDenseWeightGraph() {
		dense.addEdge(0, 1, 1);
		dense.addEdge(0, 2, 2);
		dense.addEdge(0, 5, 5);
		dense.addEdge(1, 3, 4);
		dense.addEdge(2, 3, 5);
		dense.addEdge(2, 4, 6);
		dense.addEdge(3, 6, 9);
		dense.addEdge(4, 5, 9);
		dense.addEdge(4, 6, 10);
		dense.addEdge(4, 7, 11);
		dense.addEdge(4, 8, 12);
		dense.addEdge(5, 7, 12);
		dense.addEdge(6, 8, 14);
		dense.addEdge(7, 9, 16);
		dense.addEdge(8, 9, 17);
		System.out.println(dense);
		assertTrue(dense.vertexs() == 10);
		assertTrue(dense.edges() == 15);
		assertTrue(dense.contains(0, 1));
		assertTrue(dense.contains(8, 9));
		assertTrue(dense.contains(1, 3));
		assertTrue(dense.contains(2, 3));
		assertTrue(dense.contains(3, 2));
		assertTrue(!dense.contains(9, 1));

		assertTrue(1 == dense.weight(0, 1));
		assertTrue(1 == dense.weight(1, 0));
		assertTrue(16 == dense.weight(7, 9));
		assertTrue(16 == dense.weight(9, 7));
		assertTrue(-1 == dense.weight(1, 9));
		assertTrue(-1 == dense.weight(9, 1));
	}

	/**
	 * 稀疏带权图
	 */
	@Test
	public void testSparseWeightGraph() {
		sparse.addEdge(0, 1, 1);
		sparse.addEdge(0, 2, 2);
		sparse.addEdge(0, 5, 5);
		sparse.addEdge(1, 3, 4);
		sparse.addEdge(2, 3, 5);
		sparse.addEdge(2, 4, 6);
		sparse.addEdge(3, 6, 9);
		sparse.addEdge(4, 5, 9);
		sparse.addEdge(4, 6, 10);
		sparse.addEdge(4, 7, 11);
		sparse.addEdge(4, 8, 12);
		sparse.addEdge(5, 7, 12);
		sparse.addEdge(6, 8, 14);
		sparse.addEdge(7, 9, 16);
		sparse.addEdge(8, 9, 17);
		System.out.println(sparse);

		assertTrue(sparse.vertexs() == 10);
		assertTrue(sparse.edges() == 15);
		assertTrue(sparse.contains(0, 1));
		assertTrue(sparse.contains(8, 9));
		assertTrue(sparse.contains(1, 3));
		assertTrue(sparse.contains(2, 3));
		assertTrue(sparse.contains(3, 2));
		assertTrue(!sparse.contains(9, 1));

		assertTrue(1 == sparse.weight(1, 0));
		assertTrue(1 == sparse.weight(0, 1));
		assertTrue(16 == sparse.weight(7, 9));
		assertTrue(16 == sparse.weight(9, 7));
		assertTrue(-1 == sparse.weight(1, 9));
		assertTrue(-1 == sparse.weight(9, 1));
	}
}
