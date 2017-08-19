package cc.cc1234.algorithm.graph;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import cc.cc1234.algorithm.graph.traversal.BFS;
import cc.cc1234.datastructure.graph.imp.SparseGraph;

public class BFSTest {
	private BFS bfs;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		SparseGraph graph = new SparseGraph(9);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(4, 3);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(3, 6);
		graph.addEdge(7, 8);
		bfs = new BFS(graph);
	}

	@Test
	public void testOrder() {
		List<Integer> list = bfs.order(0);
		Integer[] expt = {0,1,2,4,3,5,6};
		assertArrayEquals(expt, list.toArray());
	}

	@Test
	public void testOrderV2() {
		List<Integer> list = bfs.orderV2();
		Integer[] expt = {0,1,2,4,3,5,6,7,8};
		assertArrayEquals(expt, list.toArray());
	}

	@Test
	public void testHasPath() {
		bfs.order(0);
		assertTrue(bfs.hasPath(0));
		assertTrue(bfs.hasPath(6));
		assertTrue(bfs.hasPath(5));
		assertTrue(bfs.hasPath(4));
		assertTrue(bfs.hasPath(3));
		assertTrue(bfs.hasPath(2));
		assertTrue(bfs.hasPath(1));
		
		assertTrue(!bfs.hasPath(7));
		assertTrue(!bfs.hasPath(8));
	}

	@Test
	public void testLength() {
		bfs.order(0);
		assertTrue(bfs.length(0) == 0);
		assertTrue(bfs.length(1) == 1);
		assertTrue(bfs.length(2) == 1);
		assertTrue(bfs.length(5) == 3);
		assertTrue(bfs.length(6) == 3);
		assertTrue(bfs.length(4) == 2);
		assertTrue(bfs.length(3) == 2);
	}

	@Test
	public void testPath() {
		bfs.order(0);
		Integer[] empty = {};
		assertArrayEquals(empty, bfs.path(0).toArray());
		
		Integer[] to4 = {1,4};
		assertArrayEquals(to4, bfs.path(4).toArray());
		
		Integer[] to5 = {1,4,5};
		assertArrayEquals(to5, bfs.path(5).toArray());
		
		Integer[] to3 = {2,3};
		assertArrayEquals(to3, bfs.path(3).toArray());
	}

}
