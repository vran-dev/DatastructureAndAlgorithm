package cc.cc1234.datastructure.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cc.cc1234.datastructure.list.imp.ArrayList;
import cc.cc1234.datastructure.list.imp.LinkedList;

public class BaseListTest {
	BaseList<Integer> array;
	BaseList<Integer> linked;
	
	@Before
	public void setUp() throws Exception {
		array = new ArrayList<>(10);
		linked = new LinkedList<>();
		
		assertTrue(array.size() == 0);
		assertTrue(linked.size() == 0);
	}

	
	@Test
	public void testArrayList() {
		for(int i = 0; i < 10; i++) {
			array.add(i);
		}
		assertTrue(array.size() == 10);
		// 测试扩容
		for(int i = 10; i < 16; i++) {
			array.add(i);
		}
		assertTrue(array.size() == 16);
		
		// 测试contains()
		for(int i = 0;i<16;i++) {
			assertTrue(array.get(i).equals(i));
			assertTrue(array.contains(i));
		}
		assertTrue(!array.contains(17));
		
		// 测试remove()
		for(int i = 0;i<16;i++) {
			assertTrue(array.size() == (16-i));
			assertTrue(array.remove(0).equals(i));
		}
		assertTrue(array.size() == 0);
		array.add(1);
		assertTrue(array.size() == 1);
		assertTrue(array.get(0).equals(1));
	}
	
	@Test
	public void testLinkedList() {
		for(int i = 0; i < 16; i++) {
			linked.add(i);
		}
		assertTrue(linked.size() == 16);
		
		// 测试contains()
		for(int i = 0;i<16;i++) {
			assertTrue(linked.get(i).equals(i));
			assertTrue(linked.contains(i));
		}
		assertTrue(!linked.contains(17));
		
		// 测试remove()
		for(int i = 0;i<16;i++) {
			assertTrue(linked.size() == (16-i));
			assertTrue(linked.remove(0).equals(i));
		}
		assertTrue(linked.size() == 0);
		linked.add(1);
		assertTrue(linked.size() == 1);
		assertTrue(linked.get(0).equals(1));
	}
	
}
