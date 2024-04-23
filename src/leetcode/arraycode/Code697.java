package leetcode.arraycode;

import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Package: leetcode.arraycode
 * Description: Degree of an Array - easy
 *
 * @Author ENZO
 * @Create 2024年4月23日 09:53
 */
public class Code697 {
    /**
     * 用HashMap<Integer, int[]>的int[]来表示key出现的次数
     * hashMap.put(nums[i], new int[]{1, i, i}) 来表示长度   最后的距离即 int[2]-int[1]
     *
     * @param nums
     * @return minlen   最短的长度
     */
    public int findShortestSubArray(int[] nums) {
        //HashMap<Integer, Integer> hashMap = new HashMap<>()   第一个错误
        //用HashMap<Integer, int[]>的int[]来表示key出现的次数，比放进去在找相同的value好 -> ? 如何查hashmap里相同的key的值呢？
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        //初始化hashmap
        //int[0] 值 int[1]  第一次出现的索引 int[2]  最后一次出现的索引   -> 最后的距离即 int[2]-int[1]
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.get(nums[i])[0]++;
                hashMap.get(nums[i])[2] = i;
            } else {
                //巧妙 让我想到了自动机的思想
                hashMap.put(nums[i], new int[]{1, i, i});
            }
        }

        int maxNum = 0, minlen = 0;
        for (Map.Entry<Integer, int[]> entry : hashMap.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minlen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                minlen = Math.min(minlen, arr[2] - arr[1] + 1);
            }
        }
        return minlen;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 2, 3, 1};
        System.out.println("findShortestSubArray(arr) = " + findShortestSubArray(arr));

    }
}
