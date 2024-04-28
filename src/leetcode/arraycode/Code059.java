package leetcode.arraycode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Package: leetcode.arraycode
 * Description: Spiral Matrix II - medium
 *
 * @Author ENZO
 * @Create 2024年4月24日 08:34
 */
public class Code059 {
    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
     * <p>
     * 参考第54题，依旧削头旋转
     * 注意误区：削头并不是取左上角的点，而是取第一排所有的点
     * emm 这不能削头旋转，，老老实实的模拟
     * <p>
     * 算法思想：
     * 初始化一个n*n的矩阵，然后模拟向内填充的过程
     * 1) 定义四个边界l,r,t,b,初始mun=1，迭代终止tar=n*n；
     * 2) 当num<=tar，始终按照 从左到右 从上到下 从右到左 从下到上 顺序填入，每次填入后：
     * a. 执行num+=1：得到下一个数字；
     * b. 更新边界：收缩边界；
     * 3) 使用num <= tar而不是l < r || t < b作为迭代条件，是为了解决当n为奇数时，矩阵中心数字无法在迭代过程中被填充的问题；
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        //确定四个边界，给它框起来
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1;
        //迭代条件
        int tar = n * n;

        while (num <= tar) {
            //代码很有美感，看的想前任了
            //是对层进行遍历，不是对单节点进行遍历
            //对最上面的行操作，一次操作一行，然后最上面的行下移
            for (int i = l; i <= r; i++) res[t][i] = num++; // left to right.
            t++;    //收缩边界
            //对最后边的列操作，一次操作一列
            for (int i = t; i <= b; i++) res[i][r] = num++; // top to bottom.
            r--;
            //对最下面的行操作，一次操作一行
            for (int i = r; i >= l; i--) res[b][i] = num++; // right to left.
            b--;
            //对最左边的列操作，一次操作一列
            for (int i = b; i >= t; i--) res[i][l] = num++; // bottom to top.
            l++;
        }
        return res;
    }


    @Test
    public void test() {
        int n = 3;
        int[][] matrix = generateMatrix(n);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
