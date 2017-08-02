package cc.cc1234.algorithm.num;


/**
 * 判断一个有序数组中是否存在两个数a和b,使得a+b的和等于输入的值
 * @author vran
 * @date 2017-07-25 09:05:08
 */
public class TwoSum {
	
	public boolean find(int[] data,int sum) {
		int l = 0;
		int r = data.length-1;
		while(l<r) {
			int result = data[l]+data[r];
			if(result == sum) {
				return true;
			}else if(result < sum) {
				l++;
			}else {
				r--;
			}
		}
		return false;
	}
}
