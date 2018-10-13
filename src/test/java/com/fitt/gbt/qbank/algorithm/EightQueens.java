package com.fitt.gbt.qbank.algorithm;

/**
 * <p>@Description: 八皇后</p>
 * <p>@Copyright: Copyright(C) 2017 by FITT</p>
 * <p>@Author: SixAwn</p>
 * <p>@Created: 2017-10-19</p>
 * <p>@version: 1.0</p>
 */
public class EightQueens {
	static int eight = 8;
	static int zero = 0;
	static int queen = 1;

	static int cnt = 1;

	// 八行八列
	static int[][] queens = new int[8][8];

	public static void main(String[] args) {
		putQueen(0);
//		showQueen();
	}

	public static void showQueen() {
		System.out.println("=========第 " + cnt + " 次放八皇后方案=========");
		for (int row = 0; row < eight; row++) {
			for (int col = 0; col < eight; col ++) {
				System.out.print(queens[row][col] + "	");
			}
			System.out.println();
		}
		cnt ++;
	}

	public static void putQueen(int row) {
		for (int col = 0; col < eight; col ++) {
			if (checkQueen(row, col)) {	// 可放皇后
				queens[row][col] = queen;
				if (row == (eight - 1)) {	// 最后一行, 全部设置八皇后
					showQueen();
				} else {
					putQueen(row + 1); // 寻找下一行可设置皇后的位置
				}
				queens[row][col] = zero;
			}
		}
	}

	public static boolean checkQueen(int row, int col) {
		// 上: 列不变,行减1
		for (int i = row - 1; i >= 0; i --) {
			if (queen == queens[i][col]) {
				return false;
			}
		}

		// 左斜上: 列减1, 行减1
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i --, j --) {
			if (queen == queens[i][j]) {
				return false;
			}
		}

		// 右斜上： 列加1, 行减1
		for (int i = row - 1, j = col + 1; i >= 0 && j < eight; i --, j ++) {
			if (queen == queens[i][j]) {
				return false;
			}
		}
		return true;
	}
}
