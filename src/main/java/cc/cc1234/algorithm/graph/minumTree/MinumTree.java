package cc.cc1234.algorithm.graph.minumTree;

import java.util.List;

import cc.cc1234.datastructure.graph.imp.Edge;

public interface MinumTree {
	
	/**
	 * 生成最小生成数
	 * @return
	 */
	List<Edge> generate();
	
	/**
	 * 计算生成的最小树的总权值
	 * @return
	 */
	double weight();
}
