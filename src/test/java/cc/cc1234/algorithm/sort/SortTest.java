package cc.cc1234.algorithm.sort;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cc.cc1234.algorithm.sort.bubble.BubbleSort;
import cc.cc1234.algorithm.sort.heap.HeapSort;
import cc.cc1234.algorithm.sort.insert.InsertSort;
import cc.cc1234.algorithm.sort.merge.MergeSort;
import cc.cc1234.algorithm.sort.quick.QuickSort;
import cc.cc1234.algorithm.sort.select.SelectSort;
import cc.cc1234.algorithm.sort.shell.ShellSort;

/**
 * 排序测试用例：
 * 
 * 1 测试以排好序的数组
 * 2 测试逆序排序的数组
 * 3 测试空数组
 * 4 测试单个值的数组
 * 5 测试奇数个随机数组
 * 6 测试偶数个随机数组
 * 7 测试NUll
 * 
 * @author vran
 * @Date 2017-08-03 10:28:43
 */
public class SortTest {
	
	private BaseSort<Integer> bubble;
	private BaseSort<Integer> select;
	private BaseSort<Integer> insert;
	private BaseSort<Integer> quick;
	private BaseSort<Integer> merge;
	private BaseSort<Integer> heap;
	private BaseSort<Integer> shell;

	@Before
	public void setUp() throws Exception {
		bubble = new BubbleSort<>();
		select = new SelectSort<>();
		insert = new InsertSort<>();
		quick = new QuickSort<>();
		merge = new MergeSort<>();
		heap = new HeapSort<>();
		shell = new ShellSort<>();
	}
	
	/**
	 * 冒泡排序测试
	 * 
	 * @Date 2017年8月3日
	 */
	@Test
	public void testBubbleSort() {
		Integer[] match = {1,2,3,4,5,6,7,8,9};
		Integer[] match2 = {1,2,3,4,5,6,7,8,9,10};

		Integer[] sortedData = {1,2,3,4,5,6,7,8,9};
		Integer[] inverseSortedData = {9,8,7,6,5,4,3,2,1};
		Integer[] empty = {};
		Integer[] single = {1};
		Integer[] random = {1,3,5,2,4,6,9,7,8};
		Integer[] random2 = {1,3,5,2,4,6,9,7,10,8};

		bubble.sort(sortedData);
		Assert.assertArrayEquals(sortedData, match);
		bubble.sort(inverseSortedData);
		Assert.assertArrayEquals(inverseSortedData, match);
		bubble.sort(inverseSortedData);
		Assert.assertArrayEquals(empty, empty);
		bubble.sort(single);
		Assert.assertArrayEquals(single, single);
		bubble.sort(random);
		Assert.assertArrayEquals(random, match);
		bubble.sort(random2);
		Assert.assertArrayEquals(random2, match2);
		
		try {
			bubble.sort(null);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof NullPointerException);
		}

	}
	
	/**
	 * 插入排序测试
	 * 
	 * @Date 2017年8月3日
	 */
	@Test
	public void testInsertSort() {
		Integer[] match = {1,2,3,4,5,6,7,8,9};
		Integer[] match2 = {1,2,3,4,5,6,7,8,9,10};

		Integer[] sortedData = {1,2,3,4,5,6,7,8,9};
		Integer[] inverseSortedData = {9,8,7,6,5,4,3,2,1};
		Integer[] empty = {};
		Integer[] single = {1};
		Integer[] random = {1,3,5,2,4,6,9,7,8};
		Integer[] random2 = {1,3,5,2,4,6,9,7,10,8};

		insert.sort(sortedData);
		Assert.assertArrayEquals(sortedData, match);
		insert.sort(inverseSortedData);
		Assert.assertArrayEquals(inverseSortedData, match);
		insert.sort(inverseSortedData);
		Assert.assertArrayEquals(empty, empty);
		insert.sort(single);
		Assert.assertArrayEquals(single, single);
		insert.sort(random);
		Assert.assertArrayEquals(random, match);
		insert.sort(random2);
		Assert.assertArrayEquals(random2, match2);
		
		try {
			insert.sort(null);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof NullPointerException);
		}
	}
	
	/**
	 * 选择排序测试
	 * 
	 * @Date 2017年8月3日
	 */
	@Test
	public void testSelectSort() {
		Integer[] match = {1,2,3,4,5,6,7,8,9};
		Integer[] match2 = {1,2,3,4,5,6,7,8,9,10};

		Integer[] sortedData = {1,2,3,4,5,6,7,8,9};
		Integer[] inverseSortedData = {9,8,7,6,5,4,3,2,1};
		Integer[] empty = {};
		Integer[] single = {1};
		Integer[] random = {1,3,5,2,4,6,9,7,8};
		Integer[] random2 = {1,3,5,2,4,6,9,7,10,8};

		select.sort(sortedData);
		Assert.assertArrayEquals(sortedData, match);
		select.sort(inverseSortedData);
		Assert.assertArrayEquals(inverseSortedData, match);
		select.sort(inverseSortedData);
		Assert.assertArrayEquals(empty, empty);
		select.sort(single);
		Assert.assertArrayEquals(single, single);
		select.sort(random);
		Assert.assertArrayEquals(random, match);
		select.sort(random2);
		Assert.assertArrayEquals(random2, match2);
		
		try {
			select.sort(null);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof NullPointerException);
		}
	}
	/**
	 * 堆排序测试
	 * 
	 * @Date 2017年8月3日
	 */
	@Test
	public void testHeapSort() {
		Integer[] match = {1,2,3,4,5,6,7,8,9};
		Integer[] match2 = {1,2,3,4,5,6,7,8,9,10};

		Integer[] sortedData = {1,2,3,4,5,6,7,8,9};
		Integer[] inverseSortedData = {9,8,7,6,5,4,3,2,1};
		Integer[] empty = {};
		Integer[] single = {1};
		Integer[] random = {1,3,5,2,4,6,9,7,8};
		Integer[] random2 = {1,3,5,2,4,6,9,7,10,8};

		heap.sort(sortedData);
		Assert.assertArrayEquals(sortedData, match);
		heap.sort(inverseSortedData);
		Assert.assertArrayEquals(inverseSortedData, match);
		heap.sort(inverseSortedData);
		Assert.assertArrayEquals(empty, empty);
		heap.sort(single);
		Assert.assertArrayEquals(single, single);
		heap.sort(random);
		Assert.assertArrayEquals(random, match);
		heap.sort(random2);
		Assert.assertArrayEquals(random2, match2);
		
		try {
			heap.sort(null);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof NullPointerException);
		}
	}
	/**
	 * 希尔排序测试
	 * 
	 * @Date 2017年8月3日
	 */
	@Test
	public void testShellSort() {
		Integer[] match = {1,2,3,4,5,6,7,8,9};
		Integer[] match2 = {1,2,3,4,5,6,7,8,9,10};

		Integer[] sortedData = {1,2,3,4,5,6,7,8,9};
		Integer[] inverseSortedData = {9,8,7,6,5,4,3,2,1};
		Integer[] empty = {};
		Integer[] single = {1};
		Integer[] random = {1,3,5,2,4,6,9,7,8};
		Integer[] random2 = {1,3,5,2,4,6,9,7,10,8};

		shell.sort(sortedData);
		Assert.assertArrayEquals(sortedData, match);
		shell.sort(inverseSortedData);
		Assert.assertArrayEquals(inverseSortedData, match);
		shell.sort(inverseSortedData);
		Assert.assertArrayEquals(empty, empty);
		shell.sort(single);
		Assert.assertArrayEquals(single, single);
		shell.sort(random);
		Assert.assertArrayEquals(random, match);
		shell.sort(random2);
		Assert.assertArrayEquals(random2, match2);
		
		try {
			shell.sort(null);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof NullPointerException);
		}
	}
	/**
	 * 归并排序测试
	 * 
	 * @Date 2017年8月3日
	 */
	@Test
	public void testMergeSort() {
		Integer[] match = {1,2,3,4,5,6,7,8,9};
		Integer[] match2 = {1,2,3,4,5,6,7,8,9,10};

		Integer[] sortedData = {1,2,3,4,5,6,7,8,9};
		Integer[] inverseSortedData = {9,8,7,6,5,4,3,2,1};
		Integer[] empty = {};
		Integer[] single = {1};
		Integer[] random = {1,3,5,2,4,6,9,7,8};
		Integer[] random2 = {1,3,5,2,4,6,9,7,10,8};

		merge.sort(sortedData);
		Assert.assertArrayEquals(sortedData, match);
		merge.sort(inverseSortedData);
		Assert.assertArrayEquals(inverseSortedData, match);
		merge.sort(inverseSortedData);
		Assert.assertArrayEquals(empty, empty);
		merge.sort(single);
		Assert.assertArrayEquals(single, single);
		merge.sort(random);
		Assert.assertArrayEquals(random, match);
		merge.sort(random2);
		Assert.assertArrayEquals(random2, match2);
		
		try {
			merge.sort(null);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof NullPointerException);
		}
	}
	/**
	 * 快速排序测试（两路快排）
	 * 
	 * @Date 2017年8月3日
	 */
	@Test
	public void testQuickSort() {
		Integer[] match = {1,2,3,4,5,6,7,8,9};
		Integer[] match2 = {1,2,3,4,5,6,7,8,9,10};

		Integer[] sortedData = {1,2,3,4,5,6,7,8,9};
		Integer[] inverseSortedData = {9,8,7,6,5,4,3,2,1};
		Integer[] empty = {};
		Integer[] single = {1};
		Integer[] random = {1,3,5,2,4,6,9,7,8};
		Integer[] random2 = {1,3,5,2,4,6,9,7,10,8};

		quick.sort(sortedData);
		Assert.assertArrayEquals(sortedData, match);
		quick.sort(inverseSortedData);
		Assert.assertArrayEquals(inverseSortedData, match);
		quick.sort(inverseSortedData);
		Assert.assertArrayEquals(empty, empty);
		quick.sort(single);
		Assert.assertArrayEquals(single, single);
		quick.sort(random);
		Assert.assertArrayEquals(random, match);
		quick.sort(random2);
		Assert.assertArrayEquals(random2, match2);
		
		try {
			quick.sort(null);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof NullPointerException);
		}
	}

}
