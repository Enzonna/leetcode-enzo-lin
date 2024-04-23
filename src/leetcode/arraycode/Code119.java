package leetcode.arraycode;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: leetcode.arraycode
 * Description: Pascal's Triangle II - easy
 *
 * @Author ENZO
 * @Create 2024年4月23日 19:41
 */
public class Code119 {
    public List<Integer> getRow(int rowIndex){
        ArrayList<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
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
        return res.get(rowIndex);
    }
}
