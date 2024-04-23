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

    public List<Integer> findDuplicates(int[] nums){



    }

    @Test
    public void test(){
        int[] nums = {4,3,2,7,8,2,3,1};
        int[] nums2 = {1,1,2};
        int[] nums3 = {1};
        //System.out.println(findDuplicates(nums));
        //System.out.println(findDuplicates(nums2));
        //System.out.println(findDuplicates(nums3));
    }
}
