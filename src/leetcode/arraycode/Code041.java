package leetcode.arraycode;

import org.testng.annotations.Test;

/**
 * Package: leetcode.arraycode
 * Description: First Missing Positive - hard
 *
 * @Author ENZO
 * @Create 2024年4月23日 14:38
 */
public class Code041 {
    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * <p>
     * 代码简单，难在原地操作
     * <p>
     * 方法1：原地哈希
     * 将给定的数组设计成哈希表的‘替代品’ -> 替身文学
     * <p>
     * 对于一个长度为N的数组，其中没有出现的最小正整数只能在[1,N+1]中。
     * 这样一来，我们将所有在[1,N]范围内的数放入哈希表，也可以得到最终答案。
     * 而给定的数组长度恰好为N，便有了将数组设计成哈希表的思路：
     * <p>
     * 在数组中遍历，对于遍历到x，如果它在[1,N]范围内，那么就在第x-1的位置上打上‘标记’，在遍历结束之后，如果所有的位置都被打上了标记，
     * 那么答案就是N+1，否则，答案就是最小的没有打上标记的位置+1；
     * <p>
     * 如何设计标记呢？？？======================================>
     * 因为我们只在意[1,N]中的数，因此我们将数组遍历，把不在[1,N]中的数修改成任意一个大于N的数，这样一来，数组中的所有数就都是正数了
     * ->   因此我们可以将‘标记’表示为‘负号’
     * <p>
     * 算法流程：
     * 1）   将数组中所有小于等于0的数修改为N+1；
     * 2）   遍历数组中的每个数，它可能被打上了标记，因此原本对应的数为|x| ，如果|x| ∈ [1,N] 那么我们给索引为|x|-1的数添加一个负号
     * 但是如果本身已经有了负号，就不再添加；
     * 3）   遍历完成后，如果数组每一个数都是负数，答案是N+1，否则答案是第一个正数的索引+1；
     *
     * 见图解 -> code041.png
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //将负数全都赋N+1
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        //开始标记
        for (int i = 0; i < len; i++) {
            int temp = Math.abs(nums[i]);
            if (temp <= len) {
                //使用绝对值，防止反复变负
                nums[temp - 1] = -Math.abs(nums[temp - 1]);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }

    @Test
    public void test() {
        int[] arr1 = {1, 2, 0};
        int[] arr2 = {3, 4, -1, 1};
        int[] arr3 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(arr1));
        System.out.println(firstMissingPositive(arr2));
        System.out.println(firstMissingPositive(arr3));
    }
}
