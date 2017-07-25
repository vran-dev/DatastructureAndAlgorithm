package cc.cc1234.algorithm.num;

/**
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 解：
 * 假设求跳法的函数 y=f(x)
 * 台阶数           函数
 * 1	  y=f(1)=1
 * 2      y=f(2)=2
 * 3      y=f(1)+f(2)=3
 * 4      y=f(2)+f(3)=5
 *       .....
 * n      y=f(n)=f(n-1)+f(n-2)
 * 
 * @author vran
 * @date 2017-07-25 15:19:45
 */
public class JumpFloor {
	
	/*
	 * 递归实现
	 */
	public int countV1(int target) {
		if(target < 0) {
			throw new IllegalArgumentException();
		}
		if(target <= 2) {
			return target;
		}
		
		return countV1(target-1)+countV1(target-2);
	}
	
}
