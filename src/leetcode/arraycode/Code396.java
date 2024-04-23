package leetcode.arraycode;

import java.util.Arrays;

/**
 * Package: leetcode.arraycode
 * Description: Rotate Function - medium
 *
 * @Author ENZO
 * @Create 2024年4月23日 20:16
 */
public class Code396 {
    /**
     * 又是一道数学题，逆向思维
     * <p>
     * input: nums = [4,3,2,6]
     * output: 26
     * explain:
     * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
     * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
     * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
     * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
     * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
     * <p>
     * ->   F(k) = F(k-1) + numSum - n x nums[n-k]
     * 题解公式
     *
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        //Arrays.stream().sum()     stream流确实很方便，对于操作静态数组而言
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }

}
