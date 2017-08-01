package cc.cc1234.algorithm.str;

import java.util.Arrays;

/**
 * KMP模式匹配算法
 * @author vran
 * @date 2017-08-01 15:09:59
 */
public class KMPmatch {
	public static boolean contains(String parent, String child) {
		
		
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
		String str = "abcdaf";
		System.out.println(Arrays.toString(next(str)));
	}
}
