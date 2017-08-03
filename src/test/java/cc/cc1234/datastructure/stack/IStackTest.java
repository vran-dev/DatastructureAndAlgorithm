package cc.cc1234.datastructure.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cc.cc1234.datastructure.queue.imp.LinkedQueue;
import cc.cc1234.datastructure.stack.imp.ArrayStack;
import cc.cc1234.datastructure.stack.imp.LinkedStack;

public class IStackTest {
	
	private ArrayStack<Integer> arrayStack;
	private LinkedStack<Integer> linkedStack;
	
	@Before
	public void setUp() throws Exception {
		arrayStack = new ArrayStack<>(10);
		linkedStack = new LinkedStack<>();
		
		assertTrue(arrayStack.size() == 0);
		assertTrue(linkedStack.size() == 0);
	}

	@Test
	public void testArrayStack() {
		for(int i=0;i<10;i++) {
			assertTrue(arrayStack.push(i));
			assertTrue(arrayStack.size() == i+1);
		}
		
		for(int i=9;i>=0;i--) {
			assertTrue(arrayStack.pop().equals(i));
			assertTrue(arrayStack.size() == i);
		}
		
		for(int i=0;i<10;i++) {
			assertTrue(arrayStack.push(i));
			assertTrue(arrayStack.size() == i+1);
		}
		
		for(int i=9;i>=0;i--) {
			assertTrue(arrayStack.pop().equals(i));
			assertTrue(arrayStack.size() == i);
		}
	}

	@Test
	public void testLinkedStack() {
		for(int i=0;i<10;i++) {
			assertTrue(linkedStack.push(i));
			assertTrue(linkedStack.size() == i+1);
		}
		
		for(int i=9;i>=0;i--) {
			assertTrue(linkedStack.pop().equals(i));
			assertTrue(linkedStack.size() == i);
		}
		
		for(int i=0;i<10;i++) {
			assertTrue(linkedStack.push(i));
			assertTrue(linkedStack.size() == i+1);
		}
		
		for(int i=9;i>=0;i--) {
			assertTrue(linkedStack.pop().equals(i));
			assertTrue(linkedStack.size() == i);
		}
	}


}
