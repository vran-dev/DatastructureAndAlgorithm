package cc.cc1234.datastructure.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * 最大堆测试用例
 * @author vran
 * @date 2017-08-03 15:32:15
 */
public class MaxHeapTest {
	MaxHeap<Integer> heap;
	@Before
	public void setUp() throws Exception {
		heap = new MaxHeap<>(6);
	}

	@Test
	public void testInsert() {
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		assertTrue(heap.size() == 6);
		try {
			heap.insert(7);
		} catch (Exception e) {
			assertTrue( e instanceof IllegalStateException);
		}
	}

	@Test
	public void testPop() {
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		assertTrue(heap.size() == 4);
		assertTrue(heap.pop().equals(4));
		assertTrue(heap.size() == 3);
		assertTrue(heap.pop().equals(3));
		assertTrue(heap.pop().equals(2));
		assertTrue(heap.pop().equals(1));
		assertTrue(heap.pop() == null);
		assertTrue(heap.size() == 0);
		
	}
	
	@Test
	public void testHeapify() {
		Integer[] data = {1,3,5,7,9};
		MaxHeap<Integer> maxHeap = new MaxHeap<>(data);
		assertTrue(maxHeap.size() == 5);
		assertTrue(maxHeap.pop().equals(9));
		assertTrue(maxHeap.pop().equals(7));
		assertTrue(maxHeap.pop().equals(5));
		assertTrue(maxHeap.pop().equals(3));
		assertTrue(maxHeap.pop().equals(1));
		assertTrue(maxHeap.pop() == null);
		assertTrue(maxHeap.size() == 0);
		
	}

}
