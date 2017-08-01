package cc.cc1234.algorithm.str;


/**
 * BruteForce 字符串匹配算法
 * 
 * 
 * @author vran
 * @date 2017-08-01 09:18:35
 */
public class BruteForce {
	
	public static boolean contains(String parent, String child) {
		char[] p = parent.toCharArray();
		char[] c = child.toCharArray();
		for(int i = 0,j = 0; i < p.length && j < c.length; i++,j++) {
			if(p[i] == c[j]) {
				if(j == c.length-1) {
					return true;
				}
			}else {
				i = i - j + 1;
				j = 0;
			}
		}
		return false;
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
