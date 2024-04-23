package leetcode.arraycode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Package: leetcode.arraycode
 * Description: Find All Duplicates in an Array - medium
 *
 * @Author ENZO
 * @Create 2024年4月23日 11:24
 */
public class Code442 {
//    /**
//     * 这么简单？？？
//     * 题干要求： 常量额外空间的算法，原地操作
//     * 所以，该方法原则上可以实现，但是不符合题干要求.....
//     * @param nums
//     * @return
//     */
//    public List<Integer> findDuplicates(int[] nums) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//
//        for (int num : nums) {
//            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
//            if (entry.getValue() == 2){
//                list.add(entry.getKey());
//            }
//        }
//        return list;
//    }

    /**
     * 将时间复杂度降到O(n)
     * 思路：
     * 对于给定的n个数都在[1,n]，如果有数字出现了两次，就意味着其中 有个数字没有出现过
     * 因此，先将每一个数放在对应的位置， i -> arr[i-1]
     * 1)   i恰好出现了一次，那么将i放在arr[i-1]即可
     * 2)   i出现了两次，其中一个i放在arr[i-1]，另一个i放在任意‘不冲突’的位置j，即，数j+1没有在数组中出现过
     * <p>
     * 这样，按照上述规则放置每一个数，只需要对数组进行一次遍历。当遍历到i时，如果arr[i]-1 != i ,说明i出现了两次，将i入队
     * <p>
     * 放置的方法：
     * 对数组进行一次遍历，当遍历到i时，我们知道arr[i]本应该在 arr[arr[i] - 1]的位置，
     * 因此交换arr[i]和 arr[arr[i] - 1] 即可，直到待交换的两个元素相等为止。
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            //本题的关键
            while (nums[i] != nums[nums[i] - 1]) {
                //交换要封装到函数里，类似 原子性？ 因为对数组的下标进行了操作，所以交换的过程中要保持下标索引的不变性
                //第一个错误
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    @Test
    public void test() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        //int[] nums2 = {1, 1, 2};
        //int[] nums3 = {1};
        System.out.println(findDuplicates(nums));
        //System.out.println(findDuplicates(nums2));
        //System.out.println(findDuplicates(nums3));
    }
}
