package cc.cc1234.datastructure.queue.imp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
	PriorityQueue<String> queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new PriorityQueue<>();
	}

	@Test
	public void testAdd() {
		assertTrue(queue.add("A", 10));
		assertTrue(queue.add("B", 9));
		assertTrue(queue.add("C", 8));
		assertTrue(queue.add("D", 7));
		assertTrue(queue.add("A", 11));
	}

	@Test
	public void testPoll() {
		assertTrue(queue.add("A", 10));
		assertTrue(queue.add("B", 9));
		assertTrue(queue.add("C", 8));
		assertTrue(queue.add("D", 7));
		assertTrue(queue.add("A", 11));
		
		assertEquals("A", queue.poll());
		assertEquals("A", queue.poll());
		assertEquals("B", queue.poll());
		assertEquals("C", queue.poll());
		assertEquals("D", queue.poll());
		assertNull(queue.poll());
	}

	@Test
	public void testTail() {
		assertTrue(queue.add("A", 10));
		assertTrue(queue.add("B", 9));
		assertTrue(queue.add("C", 8));
		assertTrue(queue.add("D", 7));
		
		assertEquals("D", queue.removeTail());
		
		assertTrue(queue.add("E", 6));
		assertEquals("E", queue.removeTail());
		
		assertTrue(queue.add("G", 3));
		assertEquals("G", queue.removeTail());
		
		assertEquals("A", queue.poll());
		assertEquals("B", queue.poll());
		assertEquals("C", queue.poll());
		
		assertNull(queue.poll());
		assertNull(queue.removeTail());
		
		assertTrue(queue.add("A", 10));
		assertEquals("A", queue.poll());
		
		assertTrue(queue.add("A", 10));
		assertEquals("A", queue.removeTail());
	}

	@Test
	public void testSize() {
		assertTrue(queue.size() == 0);
		assertTrue(queue.add("A", 10));
		assertTrue(queue.add("B", 9));
		assertTrue(queue.add("C", 8));
		assertTrue(queue.add("D", 7));
		assertTrue(queue.size() == 4);
		
		assertTrue(queue.poll().equals("A"));
		assertTrue(queue.size() == 3);
		
		assertTrue(queue.poll().equals("B"));
		assertTrue(queue.size() == 2);
		
		assertTrue(queue.poll().equals("C"));
		assertTrue(queue.poll().equals("D"));
		assertTrue(queue.size() == 0);
	}

}
