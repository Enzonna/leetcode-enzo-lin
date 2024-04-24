package leetcode.arraycode;

import org.junit.Test;
import org.w3c.dom.Text;

/**
 * Package: leetcode.arraycode
 * Description: Rotate Image - medium
 *
 * @Author ENZO
 * @Create 2024年4月24日 15:32
 */
public class Code048 {
    /**
     * 题干：
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像 顺时针 旋转 90 度。
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * <p>
     * 先按对角线翻转，在逐列逆序
     * <p>
     * 比官方题解简单多得多哈哈哈哈 天才 虽然是看了评论区得到的思路 官方题解一大堆公式根本看不懂 而且给我的感觉也不是通解
     * 相比之前的削头替换 这个解法也是‘骨骼精奇’
     * 果然找数学规律的题不是一尘不变的 数学领域跟编程领域的思维 还是有所区别的
     * 期待集大成吧
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //镜像翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }

        //逐列逆序
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    @Test
    public void test() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println("=========================");
        rotate(arr);
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
