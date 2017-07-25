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
	
	public static void main(String[] args) {
		int[] in = {1,2,3,4,5,6,7,8,9};
		System.out.println(new TwoSum().find(in, 3));
		System.out.println(new TwoSum().find(in, 17));
		System.out.println(new TwoSum().find(in, 12));
		System.out.println(new TwoSum().find(in, 0));
		System.out.println(new TwoSum().find(in, 99));
	}
}
