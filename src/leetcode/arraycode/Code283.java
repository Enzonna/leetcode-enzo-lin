package leetcode.arraycode;

import org.testng.annotations.Test;

/**
 * Package: leetcode.arraycode
 * Description: Move Zeroes - easy
 *
 * @Author ENZO
 * @Create 2024年4月23日 18:38
 */
public class Code283 {
    /**
     * 双指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        //指针l : 找0
        //指针r : 找非0
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
            r++;
        }
    }

    @Test
    public void test() {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
