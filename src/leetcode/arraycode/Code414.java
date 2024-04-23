package leetcode.arraycode;

import org.testng.annotations.Test;

import java.util.TreeSet;

/**
 * Package: leetcode.arraycode
 * Description: Third Maximum Number - easy
 *
 * @Author ENZO
 * @Create 2024年4月22日 21:21
 */
public class Code414 {
    /**
     * 找第三大的数
     * 向TreeSet里依次放三个元素，大的进去小的出来，集合保证了不重复
     * return res.size() == 3 ? res.first() : res.last()    注意这行代码
     * TreeSet.first()/last()
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {

        TreeSet<Integer> res = new TreeSet<>();

        for (int num : nums) {
            res.add(num);
            if (res.size() > 3) {
                //first() 返回集合中最小的元素 如果是整数返回最小的整数；
                //                         如果是字符串，则将按字母顺序检查元素，并以字典顺序返回以初始字母开头的字符串；
                res.remove(res.first());
            }
        }
        //last() 返回集合最高的元素 与first()对应
        //对这行代码的理解，只需要理解，如果集合满了 第三大的元素 -> 最小的元素
        //如果集合没满 —> 最大的元素   很巧妙 学习
        return res.size() == 3 ? res.first() : res.last();
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1};
        System.out.println(thirdMax(nums));
    }
}
