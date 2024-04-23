package leetcode.arraycode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: leetcode.arraycode
 * Description: Spiral Matrix - medium
 *
 * @Author ENZO
 * @Create 2024年4月23日 20:57
 */
public class Code054 {
    /**
     * m行n列矩阵，顺时针螺旋遍历
     * <p>
     * 方法一：|-削头旋转-|
     * 1) 削头 -> 拿的是一行(一层)，每次旋转之后的arr[0]这一层
     * 2) 剩下的逆时针旋转90°，等待下次削头
     * <p>
     * 方法2、方法3官方题解
     * 方法2：模拟路径
     * 方法3：按层模拟
     * 都比较复杂，代码看着很多就没仔细看，看个思路，官方题解看来不一定是最优解呀
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        while (matrix.length >= 1) {
            //操作1，削头
            for (int i : matrix[0]) {
                res.add(i);
            }
            //操作2，旋转
            matrix = myReverse(matrix);
        }

        return res;
    }

    //逆时针旋转矩阵
    public int[][] myReverse(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length - 1;
        int[][] temp = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //数学推演
                temp[i][j] = matrix[j + 1][width - i - 1];
            }
        }
        return temp;
    }

    @Test
    public void test() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newArr = myReverse(arr);
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[0].length; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("================================");
        int[][] newArr2 = myReverse(newArr);
        for (int i = 0; i < newArr2.length; i++) {
            for (int j = 0; j < newArr2[0].length; j++) {
                System.out.print(newArr2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("============================");
        System.out.println(spiralOrder(arr));
    }
}
