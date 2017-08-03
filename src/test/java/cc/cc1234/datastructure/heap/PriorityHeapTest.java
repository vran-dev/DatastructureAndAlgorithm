package cc.cc1234.datastructure.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityHeapTest {
	private PriorityHeap<String> heap;
	
	@Before
	public void setUp() throws Exception {
		heap = new PriorityHeap<>(5);
	}

	@Test
	public void testInsert() {
		assertTrue(heap.insert("a", 1));
		assertTrue(heap.insert("b", 2));
		assertTrue(heap.insert("c", 3));
		assertTrue(heap.insert("d", 4));
		assertTrue(heap.insert("e", 5));
		assertTrue(!heap.insert("f", 10));
		assertTrue(heap.size() == 5);
		assertEquals(heap.pop(), "e");
		assertTrue(heap.size() == 4);
		assertEquals(heap.pop(), "d");
		assertEquals(heap.pop(), "c");
		assertEquals(heap.pop(), "b");
	}


	@Test
	public void testChange() {
		assertTrue(heap.insert("a", 1));
		assertTrue(heap.insert("b", 2));
		assertTrue(heap.insert("c", 3));
		assertTrue(heap.insert("d", 4));
		assertTrue(heap.insert("e", 5));
		assertTrue(heap.change("a", 10));
		assertTrue(!heap.change("g", 10));
		
		assertEquals("a", heap.pop());
		assertEquals("e", heap.pop());
		assertEquals("d", heap.pop());
		assertEquals("c", heap.pop());
		assertEquals("b", heap.pop());
		assertNull(heap.pop());
	}

}
