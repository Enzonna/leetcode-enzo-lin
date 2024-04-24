package leetcode.arraycode;

import org.junit.Test;

/**
 * Package: leetcode.arraycode
 * Description: Reshape the Matrix - easy
 *
 * @Author ENZO
 * @Create 2024年4月24日 11:43
 */
public class Code566 {
    /**
     * 简单题 有点easy
     * 二维数组 -> 一维数组 -> 二维数组
     * <p>
     * 官方题解：机械学习？flatten操作？
     * 具体操作：
     * 1) 将二维数组 nums 映射成一个一维数组；
     * 2) 将这个一维数组映射回 r 行 c 列的二维数组。
     * 但是官方并没有用一维数组过渡，而是直接得到重塑数组：
     * <p>
     * ==========================================
     * for (int x = 0; x < m * n; ++x) {
     * ans[x / c][x % c] = nums[x / n][x % n];
     * }
     * ==========================================
     * 这个映射函数，确实很厉害，我觉得是这道题最有价值的地方
     * 时间复杂度O(rc),空间复杂度O(1)，比我写的破代码好很多
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int width = mat.length, height = mat[0].length;
        if (width * height != r * c) {
            return mat;
        }

        int[] temp = new int[width * height];
        int[][] res = new int[r][c];
        int count = 0;
        for (int[] ints : mat) {
            for (int j = 0; j < height; j++) {
                temp[count++] = ints[j];
            }
        }

        int count2 = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = temp[count2++];
            }
        }
        return res;
    }


    @Test
    public void test() {
        int[][] arr = {{1, 2}, {3, 4}};
        int[][] ints = matrixReshape(arr, 1, 4);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }

    }
}
