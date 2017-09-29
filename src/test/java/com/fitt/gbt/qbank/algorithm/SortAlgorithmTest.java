package com.fitt.gbt.qbank.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>@Description: 排序算法实现测试</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-09-29</p>
 * <p>@version: 1.0</p>
 */
public class SortAlgorithmTest {
	@Test
	public void testDirectInsectOrder() {
		int[] a = new int[]{23, 11, 32, 5, 78, 2, 1, 8, 12, 54, 21};
//		directInsectSort(a);
//		System.out.println(a);

		hashSort(a);
		System.out.println(a);
	}

	/**
	 * 直接插入:经常碰到这样一类排序问题：把新的数据插入到已经排好的数据列中。
	 * 1.将第一个数和第二个数排序，然后构成一个有序序列
	 * 2.将第三个数插入进去，构成一个新的有序序列。
	 * 3.对第四个数、第五个数……直到最后一个数，重复第二步。
	 *
	 * @param a
	 */
	public static void directInsectSort(int[] a) {
		int length = a.length;
		for (int i = 1; i < length; i++) {
			int insectNum = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > insectNum) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = insectNum;
		}
	}

	/**
	 * Hash排序:对于直接插入排序问题，数据量巨大时。
	 * 将数的个数设为n，取奇数k=n/2，将下标差值为k的书分为一组，构成有序序列。
	 * 再取k=k/2 ，将下标差值为k的书分为一组，构成有序序列。
	 * 重复第二步，直到k=1执行简单插入排序。
	 *
	 * @param a
	 */
	public static void hashSort(int[] a) {
		int length = a.length;
		while (length != 0) {
			length = length / 2;
			for (int i = 0; i < length; i++) {
				for (int j = i + length; j < a.length; j += length) {
					int x = j - length;
					int temp = a[j];
					for (; x >= 0 && temp < a[x]; x -= length) {
						a[x + length] = a[x];
					}
					a[x + length] = temp;
				}
			}
		}
	}

	/**
	 * 简单选择排序:常用于取序列中最大最小的几个数时。
	 * (如果每次比较都交换，那么就是交换排序；如果每次比较完一个循环再交换，就是简单选择排序。)
	 * 1.遍历整个序列，将最小的数放在最前面。
	 * 2.遍历剩下的序列，将最小的数放在最前面。
	 * 3.重复第二步，直到只剩下一个数。
	 *
	 * @param a
	 */
	public static void selectSort(int[] a) {
		int length = a.length;
		for (int i = 0; i < length; i++) { // 循环次数
			int key = a[i];
			int position = i;
			for (int j = i + 1; j < length; j++) { // 选出最小值和位置
				if (a[j] < key) {
					key = a[j];
					position = j;
				}
			}
			a[position] = a[i];// 交换位置
			a[i] = key;
		}
	}

	/**
	 * 堆排序：对简单选择排序的优化。
	 * 1.将序列构建成大顶堆。
	 * 2.将根节点与最后一个节点交换，然后断开最后一个节点。
	 * 3.重复第一、二步，直到所有节点断开。
	 *
	 * @param a
	 */
	public static void heapSort(int[] a) {
		System.out.println("开始进行对排序...");
		int arrayLength = a.length;

		// 循环建堆
		for (int i = 0; i < arrayLength - 1; i++) {
			// 建堆
			buildMaxHeap(a, arrayLength - 1);
			// 交换堆顶和最后一个元素
			swap(a, 0, arrayLength - 1);
			System.out.println(Arrays.toString(a));
		}
	}

	private static void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	// 对data数组从0到lastIndex建大顶堆
	private static void buildMaxHeap(int[] data, int lastIndex) {
		//从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			//k保存正在判断的节点
			int k = i;
			//如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex) {
				//k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				//如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if (biggerIndex < lastIndex) {
					//若果右子节点的值较大
					if (data[biggerIndex] < data[biggerIndex + 1]) {
						//biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				//如果k节点的值小于其较大的子节点的值
				if (data[k] < data[biggerIndex]) {
					//交换他们
					swap(data, k, biggerIndex);
					//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	/**
	 * 冒泡排序：一般不用：
	 * 1.将序列中所有元素两两比较，将最大的放在最后面。
	 * 2.将剩余序列中所有元素两两比较，将最大的放在最后面。
	 * 3.重复第二步，直到只剩下一个数。
	 *
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		int length = a.length;
		int temp;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 快速排序:要求时间最快时。
	 * 1.选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
	 * 2.递归的将p左边和右边的数都按照第一步进行，直到不能递归。
	 *
	 * @param numbers
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] numbers, int start, int end) {
		if (start < end) {
			int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
			int temp; // 记录临时中间值
			int i = start, j = end;
			do {
				while ((numbers[i] < base) && (i < end))
					i++;
				while ((numbers[j] > base) && (j > start))
					j--;
				if (i <= j) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
					i++;
					j--;
				}
			} while (i <= j);
			if (start < j)
				quickSort(numbers, start, j);
			if (end > i)
				quickSort(numbers, i, end);
		}
	}

	/**
	 * 归并排序:速度仅次于快排，内存少的时候使用，可以进行并行计算的时候使用。
	 * 选择相邻两个数组成一个有序序列。
	 * 选择相邻的两个有序序列组成一个有序序列。
	 * 重复第二步，直到全部组成一个有序序列。
	 *
	 * @param numbers
	 * @param left
	 * @param right
	 */
	public static void mergeSort(int[] numbers, int left, int right) {
		int t = 1;// 每组元素个数
		int size = right - left + 1;
		while (t < size) {
			int s = t;// 本次循环每组元素个数
			t = 2 * s;
			int i = left;
			while (i + (t - 1) < size) {
				merge(numbers, i, i + (s - 1), i + (t - 1));
				i += t;
			}
			if (i + (s - 1) < right)
				merge(numbers, i, i + (s - 1), right);
		}
	}

	private static void merge(int[] data, int p, int q, int r) {
		int[] B = new int[data.length];
		int s = p;
		int t = q + 1;
		int k = p;
		while (s <= q && t <= r) {
			if (data[s] <= data[t]) {
				B[k] = data[s];
				s++;
			} else {
				B[k] = data[t];
				t++;
			}
			k++;
		}
		if (s == q + 1)
			B[k++] = data[t++];
		else
			B[k++] = data[s++];
		for (int i = p; i <= r; i++)
			data[i] = B[i];
	}

	/**
	 * 基数排序:用于大量数，很长的数进行排序时。
	 * 1.将所有的数的个位数取出，按照个位数进行排序，构成一个序列。
	 * 2.将新构成的所有的数的十位数取出，按照十位数进行排序，构成一个序列。
	 *
	 * @param array
	 */
	public void sort(int[] array) {
		//首先确定排序的趟数;
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		int time = 0;
		//判断位数;
		while (max > 0) {
			max /= 10;
			time++;
		}
		//建立10个队列;
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}
		//进行time次分配和收集;
		for (int i = 0; i < time; i++) {
			//分配数组元素;
			for (int j = 0; j < array.length; j++) {
				//得到数字的第time+1位数;
				int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(array[j]);
				queue.set(x, queue2);
			}
			int count = 0;//元素计数器;
			//收集队列元素;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					ArrayList<Integer> queue3 = queue.get(k);
					array[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
	}

}
