package cc.cc1234.algorithm.num;


/**
 * 求两个整数的和，要求不能使用+,-,*,/四则运算符号
 * 
 * @author vran
 * @date 2017-08-02 18:30:42
 */
public class NumAdd {
	/*
	 * 使用异或，并，位移
	 */
	public static int solution(int a, int b) {
		int sum = 0;
		int carry = 0;
		do {
			sum = a ^ b;
			carry = (a&b) << 1;
			a = sum;
			b = carry;
		}while(carry!=0);
		return sum;
	}
}
