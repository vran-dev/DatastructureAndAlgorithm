package cc.cc1234.algorithm.graph.shortestPath;

import java.util.List;

/**
 * 单源最短路径
 * @author vran
 */
public interface ShortestPath<E> {
	
	/**
	 * 最短路径
	 * @return
	 */
	List<E> path();
	
	/**
	 * 最短距离
	 * @return
	 */
	Double dist();
	
	/**
	 * 是否存在到w的最短路径（即是否为同一个联通分量）
	 * @param w
	 * @return
	 */
	boolean exists(E w);
}
