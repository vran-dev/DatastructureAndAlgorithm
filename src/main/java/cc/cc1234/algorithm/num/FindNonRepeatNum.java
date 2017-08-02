package cc.cc1234.algorithm.num;


/**
 * 一个数组中只有一个数没有 重复，其余数字都重复了2次，请找出这个重复的数字
 * @author vran
 * @date 2017-08-02 18:06:40
 */
public class FindNonRepeatNum {
	
	public static int solution(int[] nums) {
		if(nums == null || nums.length == 0) {
			throw new IllegalArgumentException();
		}
		int v = nums[0];
		for(int i = 1; i < nums.length; i++) {
			v = v ^ nums[i];
		}
		return v;
	}
	
}
