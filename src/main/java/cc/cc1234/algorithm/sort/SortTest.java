package cc.cc1234.algorithm.sort;

import java.util.Arrays;

public class SortTest {

//	Integer[] nullData = null;
	static Integer[] reverseData = {9,8,7,6,5,4,3,2,1};
	static Integer[] reverseDataB = {9,8,7,6,5,4,3,2};
	static Integer[] emptyData = {};
	static Integer[] randomData = {5,4,6,7,1,2,8,9,3};
	static Integer[] repeatData = {9,7,7,9,4,5,3,3,6,1};
	
	public static void test(BaseSort sort) {
		sort.sort(reverseData);
		sort.sort(reverseDataB);
		sort.sort(emptyData);
		sort.sort(randomData);
		sort.sort(repeatData);
		
		System.out.println("result equals 1~9? "+ Arrays.toString(reverseData));
		System.out.println("result equals 2~9? "+ Arrays.toString(reverseDataB));
		System.out.println("result equals 1~9? "+ Arrays.toString(randomData));
		System.out.println("result is empty? "+ Arrays.toString(emptyData));
		System.out.println("result is{1,3,3,4,5,6,7,7,9,9}? "+ Arrays.toString(repeatData));
		
	}
	
}
