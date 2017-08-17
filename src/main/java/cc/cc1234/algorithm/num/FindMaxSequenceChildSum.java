package cc.cc1234.algorithm.num;

import java.util.List;

/**
 * 查找最大连续子序列和
 * 
 * example: [2,-1,3,-2,5,4]
 * 
 * @author vran
 *
 */
public class FindMaxSequenceChildSum{
	public static void main(String[] args) {
		int[] data = { 1, 3, -2, 3, 7, -2, 6, -6, 7 };
		System.out.println(v1(data));
		System.out.println(v2(data));
		System.out.println(v3(data));
	}

	/**
	 * O(n)
	 * 
	 * @param nums
	 * @return
	 */
	private static int v3(int[] nums) {
		int max = 0;
		int tempSum = 0;
		for (int i = 0; i < nums.length; i++) {
			tempSum += nums[i];
			if (tempSum > max) {
				max = tempSum;
			} else if (tempSum < 0) {
				tempSum = 0;
			}
		}
		return max;
	}

	/**
	 * o(n^2)
	 * 
	 * @param nums
	 * @return
	 */
	private static int v2(int[] nums) {
		assert nums != null : "Illegal argument";
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	/**
	 * O(n^3))
	 * 
	 * @param nums
	 * @return
	 */
	public static int v1(int[] nums) {
		assert nums != null : "Illegal argument";

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += nums[k];
				}
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}
}
