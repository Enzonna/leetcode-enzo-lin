package leetcode.arraycode;

/**
 * Package: leetcode.arraycode
 * Description: Rotate Array - medium
 *
 * @Author ENZO
 * @Create 2024年4月23日 20:00
 */
public class Code189 {
    /**
     * 原始数组                           1 2 3 4 5 6 7
     * 翻转所有元素                        7 6 5 4 3 2 1
     * 翻转 [0,k mod n-1]区间的元素        5 6 7 4 3 2 1
     * 翻转 [k mod n,n-1]区间的元素        5 6 7 1 2 3 4
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        myReverse(nums, 0, nums.length - 1);
        myReverse(nums, 0, k - 1);
        myReverse(nums, k, nums.length - 1);
    }

    public void myReverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
