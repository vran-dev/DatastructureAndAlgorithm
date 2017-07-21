package cc.cc1234.datastructure.graph;


/**
 * 稠密图：使用邻接矩阵实现
 * @author vran
 */
public class DenseGraph {
	private int[][]  matrix;
	// 有向性
	private boolean direct;
	
	public DenseGraph(int capacity) {
		matrix = new int[capacity][capacity];
		this.direct = false;
	}
	
	public DenseGraph(int capacity, boolean direct) {
		matrix = new int[capacity][capacity];
		this.direct = direct;
	}
	
	public boolean addEdge(int x, int y) {
		return false;
	}
	
	public boolean containsEdge(int x, int y) {
		return false;
	}
	
}
