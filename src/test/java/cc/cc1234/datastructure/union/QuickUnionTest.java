package cc.cc1234.datastructure.union;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuickUnionTest {
	private QuickUnion v1;
	private QuickUnionV2 v2;
	private QuickUnionV3 v3;

	@Before
	public void setUp() throws Exception {
		v1 = new QuickUnion(10);
		v2 = new QuickUnionV2(10);
		v3 = new QuickUnionV3(10);

	}

	@Test
	public void v1Test() {
		for(int i=0;i<10;i++) {
			assertTrue(v1.find(i) == i);
			assertTrue(v1.isConnected(i, i));
		}

		try {
			v1.find(11);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}

		assertTrue(v1.union(0, 1));
		assertTrue(v1.union(1, 2));
		assertTrue(v1.union(2, 3));
		assertTrue(v1.union(5, 3));
		assertTrue(v1.union(5, 3));

		assertTrue(v1.isConnected(0, 1));
		assertTrue(v1.isConnected(0, 2));
		assertTrue(v1.isConnected(0, 3));
		assertTrue(v1.isConnected(0, 5));
		assertTrue(v1.isConnected(2, 5));

		assertTrue(!v1.isConnected(1, 4));
		assertTrue(!v1.isConnected(3, 4));

	}

	@Test
	public void v2Test() {
		for(int i=0;i<10;i++) {
			assertTrue(v2.find(i) == i);
			assertTrue(v2.isConnected(i, i));
			assertTrue(v2.size(i) == 1);
		}

		try {
			v2.find(11);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}

		assertTrue(v2.union(0, 1));
		assertTrue(v2.size(1) == 2);

		assertTrue(v2.union(2, 3));
		assertTrue(v2.size(3) == 2);

		assertTrue(v2.union(3, 4));
		assertTrue(v2.size(4) == 1);

		assertTrue(v2.isConnected(0, 1));
		assertTrue(v2.isConnected(2, 3));
		assertTrue(v2.isConnected(2, 4));

		assertTrue(!v2.isConnected(0, 2));
		assertTrue(!v2.isConnected(3, 5));

	}

	@Test
	public void v3Test() {
		for(int i=0;i<10;i++) {
			assertTrue(v3.find(i) == i);
			assertTrue(v3.isConnected(i, i));
		}

		try {
			v3.find(11);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}

		assertTrue(v3.union(0, 1));
		assertTrue(v3.union(2, 3));
		assertTrue(v3.union(3, 4));

		assertTrue(v3.isConnected(0, 1));
		assertTrue(v3.isConnected(2, 3));
		assertTrue(v3.isConnected(2, 4));

		assertTrue(!v3.isConnected(0, 2));
		assertTrue(!v3.isConnected(3, 5));
	}

}
