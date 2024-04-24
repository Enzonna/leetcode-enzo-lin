package leetcode.arraycode;

/**
 * Package: leetcode.arraycode
 * Description: Diagonal Traverse - medium
 *
 * @Author ENZO
 * @Create 2024年4月24日 11:30
 */
public class Code498 {
    /**
     * 题干：
     * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素
     * <p>
     * 找规律？又是道数学问题
     * 把输出的坐标写下来，然后找x,y的坐标规律即可
     * m行n列的矩阵，有m+n-1条对角线，模拟遍历所有对角线即可
     * 好枯燥的题，像高中数学解排列组合一样，这玩意企业真的会出吗？出了我认了....现场推规律啊
     *
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int pos = 0;
        //遍历m+n-1条对角线，一条一条遍历
        for (int i = 0; i < m + n - 1; i++) {
            //如果i是奇数，那么遍历的走向，是从上向下的
            if (i % 2 == 1) {
                //起点，分两种情况，i在主对角线上面，还是i在主对角线下面，来确定起点的坐标
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    res[pos] = mat[x][y];
                    pos++;
                    x++;
                    y--;
                }
                //如果i是偶数，那么遍历的走向，是从下向上的
            } else {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[pos] = mat[x][y];
                    pos++;
                    x--;
                    y++;
                }
            }
        }
        return res;
    }
}
