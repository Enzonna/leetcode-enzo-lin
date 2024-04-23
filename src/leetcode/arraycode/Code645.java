package leetcode.arraycode;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Package: leetcode.arraycode
 * Description: Set Mismatch - easy
 *
 * @Author ENZO
 * @Create 2024年4月23日 09:40
 */
public class Code645 {
    /**
     * 将数组的元素全都放进hashmap里，找其中value==2的元素
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        //arr[0] 重复的整数
        //arr[1] 丢失的整数
        int[] arr = new int[2];
        //key 索引 value 出现的次数
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            int index = hashMap.getOrDefault(i, 0);
            if (index == 2) {
                arr[0] = i;
            } else if (index == 0){
                arr[1] = i;
            }
        }
        return arr;
    }
    
    @Test
    public void test(){
        int[] arr = {1,2,2,4};
        for (int num : findErrorNums(arr)) {
            System.out.println("num = " + num);
        }

    }
}
