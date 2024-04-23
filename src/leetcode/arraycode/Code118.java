package leetcode.arraycode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: leetcode.arraycode
 * Description: Pascal's Triangle - easy
 *
 * @Author ENZO
 * @Create 2024年4月23日 19:22
 */
public class Code118 {
    /**
     * 杨辉三角 没啥好说的 每次看都记不住 不行就跟斐波那契数列记下来 跟层次遍历还不一样 很冷门 冷不丁的出来一下
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            //注意是j == i
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }


    @Test
    public void test(){
        int a = 5;
        System.out.println(generate(a));
    }
}
