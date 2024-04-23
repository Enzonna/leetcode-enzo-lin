package leetcode.arraycode;

import java.util.Arrays;

/**
 * Package: leetcode.arraycode
 * Description: Minimum Moves to Equal Array Elements - medium
 *
 * @Author ENZO
 * @Create 2024年4月23日 15:49
 */
public class Code453 {
    /**
     * 题干：
     * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
     *
     *  n-1 个元素 +1  ->  一个元素 -1
     *  纯数学问题
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        //查找数组中最小/大的元素
        //本题最有价值的地方了
        int min = Arrays.stream(nums).min().getAsInt();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - min;
        }
        return count;
    }
}
