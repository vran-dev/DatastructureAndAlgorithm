package cc.cc1234.datastructure.queue.imp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayQueueTest {
	private ArrayQueue<Integer> queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new ArrayQueue<>(10);
	}


	@Test
	public void testAdd() {
		for(int i=0;i<10;i++) {
			assertTrue(queue.add(i));
		}
		assertTrue(!queue.add(11));
	}

	@Test
	public void testPoll() {
		for(int i=0;i<10;i++) {
			assertTrue(queue.add(i));
		}
		assertTrue(queue.size() == 10);
		for(int i = 0;i<10;i++) {
			assertTrue(queue.poll().equals(i));
		}
		assertNull(queue.poll());
		assertTrue(queue.size() == 0);
	}

	@Test
	public void testPeek() {
		for(int i=0;i<10;i++) {
			assertTrue(queue.add(i));
		}
		
		assertTrue(queue.peek().equals(0));
		assertTrue(queue.size() == 10);
	}

	@Test
	public void testAddFirst() {
		for(int i=0;i<10;i++) {
			assertTrue(queue.addFirst(i));
		}
		assertTrue(queue.size() == 10);
		for(int i = 9;i>=0;i--) {
			assertTrue(queue.poll().equals(i));
		}
		assertTrue(queue.size() == 0);
	}

	@Test
	public void testTail() {
		for(int i=0;i<10;i++) {
			assertTrue(queue.add(i));
		}
		
		assertTrue(queue.tail().equals(9));
		assertTrue(queue.size() == 10);
	}

	@Test
	public void testSize() {
		for(int i=0;i<10;i++) {
			assertTrue(queue.add(i));
			assertTrue(queue.size() == (i+1));
		}
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		for(int i=0;i<10;i++) {
			assertTrue(queue.add(i));
			assertTrue(!queue.isEmpty());
		}
	}

}
