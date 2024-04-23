package leetcode.arraycode;

import java.util.Arrays;

/**
 * Package: leetcode.arraycode
 * Description: Maximum Product of Three Numbers - easy
 *
 * @Author ENZO
 * @Create 2024年4月23日 09:20
 */
public class Code628 {
    /**
     * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积
     * <p>
     * 方法1：只需要找出 最大的三个数 最小的两个数(负数) 即可
     * 方法2：先排序，但是虽然简单，真能这么用？
     *
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        //int max1 = Integer.MAX_VALUE, max2 = Integer.MAX_VALUE, max3 = Integer.MAX_VALUE;
        //int min1 = Integer.MIN_VALUE, min2 = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int min = nums[0] * nums[1] * nums[len - 1];
        return Math.max(max, min);
    }
}
