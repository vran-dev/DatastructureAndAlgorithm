package cc.cc1234.algorithm.str;

import java.util.Arrays;

/**
 * KMP模式匹配算法
 * @author vran
 * @date 2017-08-01 15:09:59
 */
public class KMPmatch {
	public static boolean contains(String parent, String child) {
		int[] next = next(child);
		char[] c = child.toCharArray();
		char[] p = parent.toCharArray();
		for(int i=0,j=0;i<p.length && j<c.length;i++,j++) {
			if(p[i] == c[j]) {
				if(j == c.length-1) {
					return true;
				}
			}else {
				j = next[j];
			}
		}
		
		return false;
	}
	
	/**
	 * 获取next数组
	 * @param str
	 * @return
	 * @Date 2017年8月1日
	 */
	private static int[] next(String str) {
		char[] p = str.toCharArray();
		int[] next = new int[p.length];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while(j < p.length-1) {
			if(k == -1 || p[j] == p[k]) {
				++k;
				++j;
				next[j] = k;
			}else {
				k = next[k];
			}
		}
		return next;
	}
	
	public static void main(String[] args) {
		System.out.println(contains("abcdefg","bcd"));
		System.out.println(contains("abcdefg","abc"));
		System.out.println(contains("abcdefg","efg"));
		System.out.println(contains("cbcbcad","cbcad"));
		System.out.println(contains("abc","abc"));
		System.out.println(contains("abc","abcd"));
		System.out.println(contains("abc","x"));
	
	}
	
}
