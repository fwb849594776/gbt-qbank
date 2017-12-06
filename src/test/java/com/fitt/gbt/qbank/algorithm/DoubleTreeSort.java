package com.fitt.gbt.qbank.algorithm;

/**
 * <p>@Description: 二叉树: 最大堆排序</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Miles[ZhengCongChun]</p>
 * <p>@Created: 2017-10-19</p>
 * <p>@version: 1.0</p>
 */
public class DoubleTreeSort {
	public static void main(String[] args) {
//		createMaxTreeHeapSort();

		//
		DoubleTreeSort dts = new DoubleTreeSort();
		DoubleTreeSort.DoubleTree doubleTree = dts.new DoubleTree();
		doubleTree.add(5);
		doubleTree.add(2);
		doubleTree.add(7);
		doubleTree.add(4);
		doubleTree.add(6);
		doubleTree.add(9);
		doubleTree.add(3);

		doubleTree.show();
	}

	// 数组存储二叉树
	public static void createMaxTreeHeapSort() {
		// 从数组索引第一个位置开始
		int[] arr = new int[]{5, 7, 2, 5, 8, 9, 3, 4, 6};
		int arrSize = arr.length;

		while (arrSize > 2) {
			// 循环所有父节点, 从后往前
			int parentSize = (arrSize - 1) / 2;
			for (int i = parentSize; i >= 1; i--) {
				// 先找到最大子节点
				int maxIndex = i * 2; // 假设最大子节点为左节点
				// 右节点存在且比左节点大
				if ((maxIndex + 1) < arrSize && arr[maxIndex + 1] > arr[maxIndex]) {
					maxIndex++;
				}
				// 最大子节点比父节点
				if (arr[maxIndex] > arr[i]) {
					int temp = arr[maxIndex];
					arr[maxIndex] = arr[i];
					arr[i] = temp;
				}
			}

			// 将根节点与最后一个节点交换
			int data = arr[1];
			arr[1] = arr[arrSize - 1];
			arr[arrSize - 1] = data;

			// 数组范围缩小
			arrSize--;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "    ");
		}
	}

	// 二叉树
	class DoubleTree {
		Node root;

		public void add(int value) {
			Node newNode = new Node(value);
			if (null == root) {
				root = newNode;
			} else {
				Node temp = root;
				while (true) {
					if (value < temp.getValue()) { // 小的数放左边
						if (null == temp.getLeft()) {
							temp.setLeft(newNode);
							break;
						} else {
							temp = temp.getLeft();
						}
					} else {
						if (null == temp.getRight()) {
							temp.setRight(newNode);
							break;
						} else {
							temp = temp.getRight();
						}
					}
				}
			}

		}

		void show() {
			showNode(root);
		}

		private void showNode(Node node) {
			// 前序 打左右
//		System.out.println(node.getValue());

			if (null != node.getLeft()) {
				showNode(node.getLeft());
			}

			// 中序 左打右
			System.out.println(node.getValue());

			if (null != node.getRight()) {
				showNode(node.getRight());
			}

			// 后序 左右打
//		System.out.println(node.getValue());
		}
	}

	// 树节点
	class Node {
		// 当前节点值
		int value;
		// 左节点
		Node left;
		// 右节点
		Node right;

		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
}
