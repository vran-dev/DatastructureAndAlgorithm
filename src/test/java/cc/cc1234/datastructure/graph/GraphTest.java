package cc.cc1234.datastructure.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cc.cc1234.datastructure.graph.imp.DenseGraph;
import cc.cc1234.datastructure.graph.imp.SparseGraph;


/**
 * 图论 单元测试
 * @author vran
 * @Date 2017-08-04 18:36:08
 */
public class GraphTest {
	private SparseGraph sparse;
	private DenseGraph dense;

	@Before
	public void setUp() throws Exception {
		sparse = new SparseGraph(10);
		dense = new DenseGraph(10);
	}
	
	/*
	 * 测试稠密图
	 */
	@Test
	public void testDenseGraph() {
		assertTrue(dense.vertexs() == 10);
		assertTrue(dense.edges() == 0);
		// 添加边测试
		assertTrue(dense.addEdge(0, 1));
		assertTrue(dense.addEdge(0, 2));
		assertTrue(dense.addEdge(0, 5));
		assertTrue(dense.addEdge(1, 4));
		assertTrue(dense.addEdge(2, 3));
		assertTrue(dense.addEdge(2, 4));
		assertTrue(dense.addEdge(3, 4));
		assertTrue(dense.addEdge(3, 5));
		assertTrue(dense.edges() == 8);

		assertTrue(dense.addEdge(6, 7));
		assertTrue(dense.addEdge(6, 8));
		assertTrue(dense.addEdge(6, 9));
		assertTrue(dense.addEdge(7, 9));
		assertTrue(dense.addEdge(8, 9));
		assertTrue(dense.edges() == 13);

		assertTrue(dense.hasEdge(0, 1));
		assertTrue(dense.hasEdge(1, 0));
		assertTrue(dense.hasEdge(8, 9));
		assertTrue(dense.hasEdge(9, 8));
		assertTrue(dense.hasEdge(2, 3));
		assertTrue(dense.hasEdge(3, 2));

		assertTrue(!dense.hasEdge(4, 5));
		assertTrue(!dense.hasEdge(0, 4));
		assertTrue(!dense.hasEdge(7, 8));
		
		GraphIterator iterator = dense.iterator(0);
		List<Integer> list = new ArrayList<>();
		int j;
		while((j=iterator.next())!=-1) {
			list.add(j);
		}
		Integer[] expected = {1,2,5};
		assertArrayEquals(expected, list.toArray());
	}
	
	/**
	 * 测试稀疏图
	 */
	@Test
	public void testSparseGraph() {
		assertTrue(sparse.vertexs() == 10);
		assertTrue(sparse.edges() == 0);
		// 添加边测试
		assertTrue(sparse.addEdge(0, 1));
		assertTrue(sparse.addEdge(0, 2));
		assertTrue(sparse.addEdge(0, 5));
		assertTrue(sparse.addEdge(1, 4));
		assertTrue(sparse.addEdge(2, 3));
		assertTrue(sparse.addEdge(2, 4));
		assertTrue(sparse.addEdge(3, 4));
		assertTrue(sparse.addEdge(3, 5));
		assertTrue(sparse.edges() == 8);

		assertTrue(sparse.addEdge(6, 7));
		assertTrue(sparse.addEdge(6, 8));
		assertTrue(sparse.addEdge(6, 9));
		assertTrue(sparse.addEdge(7, 9));
		assertTrue(sparse.addEdge(8, 9));
		assertTrue(sparse.edges() == 13);

		assertTrue(sparse.hasEdge(0, 1));
		assertTrue(sparse.hasEdge(1, 0));
		assertTrue(sparse.hasEdge(8, 9));
		assertTrue(sparse.hasEdge(9, 8));
		assertTrue(sparse.hasEdge(2, 3));
		assertTrue(sparse.hasEdge(3, 2));

		assertTrue(!sparse.hasEdge(4, 5));
		assertTrue(!sparse.hasEdge(0, 4));
		assertTrue(!sparse.hasEdge(7, 8));
		
		GraphIterator iterator = sparse.iterator(0);
		List<Integer> list = new ArrayList<>();
		int j;
		while((j=iterator.next())!=-1) {
			list.add(j);
		}
		Integer[] expected = {1,2,5};
		assertArrayEquals(expected, list.toArray());
	}
}
