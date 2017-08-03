package cc.cc1234.datastructure.list.imp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cc.cc1234.datastructure.list.BaseList;

public class ArrayListTest {
	
	BaseList<String> list;
	
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<>(10);
	}

	@Test
	public void testAdd() {
		assertEquals(list.size(), 0);
		list.add("a");
		assertEquals(list.size(), 1);
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		assertEquals(list.size(), 6);
		list.add("g");
		list.add("h");
		list.add("i");
		list.add("j");
		list.add("k");
		assertEquals(list.size(), 11);
	}

	
	@Test
	public void testRemove() {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		assertTrue(list.size() == 5);
		assertEquals(list.remove(0), "a");
		assertEquals(list.remove(3),"e");
		assertEquals(list.remove(0),"b");
		assertTrue(list.size() == 2);
		try {
			list.remove(5);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testGet() {
		list.add("a");
		list.add("b");
		list.add("c");
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("c", list.get(2));
		
		try {
			list.remove(4);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testContains() {
		list.add("a");
		list.add("j");
		assertTrue(list.contains("a"));
		assertTrue(list.contains("j"));
		assertTrue(!list.contains("g"));
	}
}
