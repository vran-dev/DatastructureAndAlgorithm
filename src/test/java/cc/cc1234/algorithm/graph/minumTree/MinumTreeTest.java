package cc.cc1234.algorithm.graph.minumTree;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import cc.cc1234.datastructure.graph.imp.SparseWeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraph;

public class MinumTreeTest {
	WeightGraph graph;
	
	@Before
	public void setUp() {
		graph = new SparseWeightGraph(8);
		graph.addEdge(0, 2, 0.26);
		graph.addEdge(0, 4, 0.38);
		graph.addEdge(0, 6, 0.58);
		graph.addEdge(0, 7, 0.16);
		graph.addEdge(1, 2, 0.36);
		graph.addEdge(1, 3, 0.29);
		graph.addEdge(1, 5, 0.32);
		graph.addEdge(1, 7, 0.19);
		graph.addEdge(2, 3, 0.17);
		graph.addEdge(2, 6, 0.40);
		graph.addEdge(2, 7, 0.34);
		graph.addEdge(3, 6, 0.52);
		graph.addEdge(4, 5, 0.35);
		graph.addEdge(4, 6, 0.93);
		graph.addEdge(4, 7, 0.37);
		graph.addEdge(5, 7, 0.28);
	}
	
	@Test
	public void testPrim() {
		MinumTree prim = new LazyPrim(graph);
		assertTrue(prim.weight() == 1.81);
	}
	
	@Test
	public void testOptPrim() {
		MinumTree opPrim = new OptimizePrim(graph);
		assertTrue(opPrim.weight() == 1.81);
	}
	
	@Test
	public void testKruskal() {
		MinumTree kruskal = new Kruskal(graph);
		assertTrue(kruskal.weight() == 1.81);
	}
}
