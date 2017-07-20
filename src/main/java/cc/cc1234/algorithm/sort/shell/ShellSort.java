package cc.cc1234.algorithm.sort.shell;


import cc.cc1234.algorithm.sort.BaseSort;
import cc.cc1234.algorithm.sort.SortTest;

/**
 * 希尔排序
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 * 1 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率。
 * 2 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位。
 * @author vran
 */
public class ShellSort<E extends Comparable<? super E>> extends BaseSort<E>{

	@Override
	public void sort(E[] data) {
		doSort(data);
	}

	private void doSort(E[] data) {
		int n = data.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = 0; i < n-gap; i++){  
				for (int j = i + gap; j < n; j += gap)   
					if (data[j].compareTo(data[j - gap]) == -1){  
						E temp = data[j];  
						int k = j - gap;  
						while (k >= 0 && data[k].compareTo(temp)==1){  
							data[k + gap] = data[k];  
							k -= gap;  
						}  
						data[k + gap] = temp;  
					}  
			}
		}
			  
	}

	public static void main(String[] args) {
		ShellSort<Integer> shell = new ShellSort<Integer>();
		SortTest.test(shell);
	}

}
