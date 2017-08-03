package cc.cc1234.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import cc.cc1234.datastructure.graph.Graph;
import cc.cc1234.datastructure.graph.GraphIterator;
import cc.cc1234.datastructure.graph.SparseGraph;


/**
 * 图的广度优先遍历算法
 * 
 * @author vran1
 *
 */
public class BFS {
	private Graph graph;
	private boolean[] visited;
	private int[] from;
	private int[] len;
	private Queue<Integer> queue;

	public BFS(Graph graph) {
		this.graph = graph;
		visited = new boolean[graph.vertexs()];
		len = new int[graph.vertexs()];
		from = new int[graph.vertexs()];
		queue = new LinkedList<>();
		for(int i = 0; i < from.length; i++) {
			from[i] = i;
		}
	}

	/**
	 * 该版本只会遍历一个联通分量
	 * @return
	 * @param v 指定一个开始遍历的定点
	 */
	public List<Integer> order(int v) {
		List<Integer> list = new ArrayList<>();
		queue.add(v);
		visited[v] = true;
		while(!queue.isEmpty()) {
			Integer x = queue.poll();
			GraphIterator iterator = graph.iterator(x);
			list.add(x);
			while(!iterator.end()) {
				int j = iterator.next();
				if(!visited[j]) {
					visited[j] = true;
					queue.add(j);
					from[j] = x;
					len[j] = len[x] + 1;
				}
			}
		}
		return list;
	}


	/*
	 * 该版本可以遍历多个联通分量
	 */
	public List<Integer> orderV2() {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < graph.vertexs(); i++) {
			if(!visited[i]) {
				queue.add(i);
			}
			while(!queue.isEmpty()) {
				Integer x = queue.poll();
				if(!visited[x]) {
					visited[x] = true;
					GraphIterator iterator = graph.iterator(x);
					list.add(x);
					while(!iterator.end()) {
						int j = iterator.next();
						if(!visited[j]) {
							queue.add(j);
						}
					}
				}
			}
		}
		return list;
	}


	/*
	 * 是否存在到v点的路径
	 */
	public boolean hasPath(int v) {
		assert v>0 || v<graph.vertexs():"v must >0 and <vertexs";
		return visited[v];
	}

	/*
	 * 到v点的距离
	 */
	public int length(int v) {
		assert v>0 || v<graph.vertexs():"v must >0 and <vertexs";
		assert visited[v]:"the length to v is null";
		return len[v];
	}
	
	/*
	 * 到v点的路径
	 */
	public List<Integer> path(int v){
		assert v>0 || v<graph.vertexs():"v must >0 and <vertexs";
		LinkedList<Integer> list = new LinkedList<>();
		if(visited[v]) {
			int p = v;
			while(from[p] != p) {
				list.addFirst(p);
				p = from[p];
			}
		}
		return list;
	}

}
