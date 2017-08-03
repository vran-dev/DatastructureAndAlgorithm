package cc.cc1234.datastructure.list.imp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cc.cc1234.datastructure.list.BaseList;

public class LinkedListTest {
	
	private BaseList<String> list;
	
	@Before
	public void setUp() throws Exception {
		list = new LinkedList<>();
	}

	@Test
	public void testAdd() {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		assertTrue(list.size() == 4);
		assertEquals(list.get(0),"a");
		assertEquals(list.get(3),"d");
		
		list.add("f");
		assertTrue(list.size() == 5);
	}

	@Test
	public void testRemove() {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		assertTrue(list.size() == 4);
		assertEquals(list.remove(0),"a");
		assertEquals(list.remove(0),"b");
		assertTrue(list.size() == 2);
		assertEquals(list.remove(1),"d");
	}

	@Test
	public void testGet() {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		assertEquals(list.get(0), "a");
		assertEquals(list.get(3), "d");
		try {
			list.get(6);
		} catch (Exception e) {
			assertTrue(e  instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testContains() {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		assertTrue(list.contains("a"));
		assertTrue(list.contains("d"));
		assertTrue(!list.contains("g"));
	}

}
