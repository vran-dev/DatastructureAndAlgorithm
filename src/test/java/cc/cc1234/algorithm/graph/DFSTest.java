package cc.cc1234.algorithm.graph;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cc.cc1234.datastructure.graph.DenseGraph;

public class DFSTest {
	private DFS dfs;
	@Before
	public void setUp() throws Exception {
		DenseGraph graph = new DenseGraph(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 5);
		graph.addEdge(3, 5);
		graph.addEdge(2, 5);
		graph.addEdge(4, 6);
		dfs = new DFS(graph);
	}

	@Test
	public void testOrder() {
		List<Integer> order = dfs.order();
		Integer[] expecteds = {0,1,3,5,2,4,6};
		assertArrayEquals(expecteds, order.toArray());
	}

	@Test
	public void testCount() {
		dfs.order();
		assertTrue(dfs.count() == 2);
	}

	@Test
	public void testConnected() {
		dfs.order();
		assertTrue(dfs.connected(0, 2));
		assertTrue(dfs.connected(1, 5));
		assertTrue(dfs.connected(3, 2));
		assertTrue(!dfs.connected(3, 6));
		assertTrue(!dfs.connected(1, 6));
		assertTrue(dfs.connected(4, 6));
	}

}
