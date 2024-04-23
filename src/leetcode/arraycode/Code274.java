package leetcode.arraycode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Package: leetcode.arraycode
 * Description: H-Index - medium
 *
 * @Author ENZO
 * @Create 2024年4月23日 15:29
 */
public class Code274 {
    /**
     * 题干翻译的很复杂
     * “要确定一个人的h指数非常容易，到SCI网站，查出某个人发表的所有SCI论文，让其按被引次数从高到低排列，往下核对
     * 直到某篇论文的序号大于该论文被引次数，那个序号减去1就是h指数。”
     *
     * 看不懂题，正常应该不会遇到吧....
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int count = 0;
        //因为不会Arrays.sort()的降序,cy，所以全反着做一遍
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > count) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] arr1 = {3, 0, 6, 1, 5};
        System.out.println(hIndex(arr1));
    }
}
