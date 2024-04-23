package leetcode.arraycode;

import org.testng.annotations.Test;

/**
 * Package: leetcode.arraycode
 * Description: Non-decreasing Array - medium
 *
 * @Author ENZO
 * @Create 2024年4月23日 16:27
 */
public class Code665 {
    /**
     * 题干：
     * 给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     * <p>
     * 理解：
     * 要使数组nums变成一个非递减的数组，数组中至多有多少个i满足nums[i] > nums[i+1] ?     （前面的元素>后面的元素，已知已经大于了一对）
     * 假设两个下标i,j满足上述不等式    i < j
     * 1)   i+1 < j 则无论怎样修改，都不会满足非递减
     * 2)   i+1 = j 则有nums[i] > nums[i+1] > nums[i+2]，同样无论怎么修改，都不会满足非递减
     * 因此，上述结论：至多一个i
     * <p>
     * 但是 -> 遇到了无法理解的数组，看了 题解，有这么个数组，[3,4,1,2]，满足了该条件，但无论们如何修改也不会变成非递减
     * 所以，若找到了一个i，在修改了nums[i] 或 nums[i+1]之后，仍需要检查nums是否真的变成了非递减
     * <p>
     * 修改方法：
     * 上面都是理论，主要操作就是这两步
     * nums[i] -> nums[i+1]     ->  操作1  前面的等于后面的
     * nums[i+1] -> nums[1]     ->  操作2  后面的等于前面的
     * <p>
     * 优化：如何只遍历一次数组？
     * 没做 脑细胞不够了 2024.4.23二刷
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                //操作1
                nums[i] = y;
                if (isSorted(nums)) {
                    return true;
                }
            }
            //复原
            //操作2
            nums[i] = x;
            nums[i + 1] = x;
            return isSorted(nums);
        }
        return true;
    }

    //判断是否非递减
    public boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] arr1 = {4, 2, 3};
        int[] arr2 = {4, 2, 1};

        System.out.println(checkPossibility(arr1));
        System.out.println(checkPossibility(arr2));

        int[] nums1 = {1, 1, 2};
        //System.out.println(isSorted(nums1));
    }
}
