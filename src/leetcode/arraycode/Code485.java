package leetcode.arraycode;

import org.testng.annotations.Test;

/**
 * Package: leetcode.arraycode
 * Description: Max Consecutive Ones - easy
 * 给定一个二进制数组 nums，计算其中最大连续 1 的个数
 *
 * @Author ENZO
 * @Create 2024年4月22日 20:48
 */
public class Code485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(count,max);
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
