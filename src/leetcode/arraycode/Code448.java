package leetcode.arraycode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Package: leetcode.arraycode
 * Description: Find All Numbers Disappeared in an Array - easy
 *
 * @Author ENZO
 * @Create 2024年4月23日 10:39
 */
public class Code448 {
//    /**
//     * 错误了 超出时间限制 应该是不允许O(n2)
//     *
//     * @param nums
//     * @return
//     */
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i : nums) {
//            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for (int i = 1; i <= nums.length; i++) {
//            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
//                if (!hashMap.containsKey(i)) {
//                    list.add(i);
//                    break;
//                }
//            }
//        }
//        return list;
//    }

    /**
     * 想复杂了，但是空间复杂度高
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length + 1];
        ArrayList<Integer> list = new ArrayList<>();

        //让nums[]全部录入arr[]
        for (int i : nums) {
            if (arr[i - 1] != 1) {
                arr[i - 1] = 1;
            }
        }
        //arr[]中没出现的元素入List
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] != 1) {
                list.add(i + 1);
            }
        }
        return list;
    }


    @Test
    public void test() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums2 = {1, 1};
        System.out.println(findDisappearedNumbers(nums));
        System.out.println(findDisappearedNumbers(nums2));
    }
}
