package com.fitt.gbt.qbank.algorithm;

/**
 * <p>@Description: 快速排序</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-10-19</p>
 * <p>@version: 1.0</p>
 */
public class QuickSort {
	// 5,3,7,8,2,9,4,6
	public static void main(String[] args) {
		int[] arr = new int[]{5,3,7,8,2,9,4,6};
		sort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i ++) {
			System.out.println(arr[i]);
		}
	}

	/**
	 * 分而治之, 从中切分两端, 取一个标杆值, 然后取值与标杆对比
	 * 值大放右边, 值小放左边
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void sort(int[] arr, int start, int end) {
		if (start < end) {
			int index = sortUnit(arr, start, end);
			sort(arr, start, index - 1); 	// 左边
			sort(arr, index + 1, end);		// 右边
		}
	}

	public static int sortUnit(int[] arr, int start, int end) {
		int flag = arr[start]; 	// 定义标杆, 用于对比数据
		int _start = start;		// 开始位置
		int _end = end;			// 结束位置
		while (_start < _end) {
			while (_start < _end) {
				// 负责找最小数
				if (arr[_end] < flag) {
					arr[_start] = arr[_end];
					break;
				}
				_end --;
			}
			while (_start < _end) {
				// 负责找最大数
				if (arr[_start] >= flag) {
					arr[_end] = arr[_start];
					break;
				}
				_start ++;
			}
		}
		arr[_start] = flag;
		return _start;
	}
}
