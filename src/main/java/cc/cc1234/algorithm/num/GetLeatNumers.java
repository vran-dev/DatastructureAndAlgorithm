package cc.cc1234.algorithm.num;

import java.util.Arrays;

/**
 * 从一个输入中找到最小的n个数
 * 
 * 思路一: 先排序，后取前n个数
 * 思路二: 基于快排的partition思想 
 * 思路三: 基于最小堆的性质
 * 
 * 本类采用的是基于快排的partition来实现的
 * @author vran
 * @date 2017-07-27 09:27:41
 */
public class GetLeatNumers {
	
	public int[] leatNumbers(int[] data, int num) {
		if(num>=data.length) {
			return data;
		}
		return solution(data,0,data.length-1,num);
	}
	
	private int[] solution(int[] data,int l,int r, int num) {
		int p = partition(data, l, r);
		System.out.println("data="+Arrays.toString(data)+",p = "+p);
		if(p == num) {
			int[] result = new int[num];
			for(int i=0;i<p;i++) {
				result[i] = data[i];
			}
			return result;
		}else if(p > num) {
			return solution(data,l,p-1, num);
		}else {
			return solution(data,p+1,r, num);
		}

	}
	
	/**
	 * [l,r]
	 */
	private int partition(int[] data,int l, int r) {
		int p = l+(r-l)/2; // 设置主元
		int pv = data[p];
		swap(data, l, p); 
		
		int pos = l+1;
		int lte = l;// [pos,lte] <= pv
		while(pos<=r) {
			if(data[pos]<=pv) {
				swap(data,pos,++lte);
			}
			pos++;
		}
		swap(data,l,lte);
		return lte;
	}
	
	private void swap(int[] data, int l, int  r) {
		int t = data[l];
		data[l] = data[r];
		data[r] = t;
	}
	
	public static void main(String[] args) {
//		int[] nums = {2,5,4,1,8,7,6};
//		int[] nums = {9,8,7,6,5,4,3,2,1,0};
		int[] nums = {0,1,2,3,4,5,6,7,8,9};
		GetLeatNumers get = new GetLeatNumers();
		System.out.println(Arrays.toString(get.leatNumbers(nums, 3)));
	}
}
