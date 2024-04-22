package leetcode.arraycode;

/**
 * Package: leetcode.arraycode
 * Description: Teemo Attacking - easy
 *
 * @Author ENZO
 * @Create 2024年4月22日 20:57
 */
public class Code495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int expired = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            if (timeSeries[i] >= expired) {
                ans += duration;
            } else {
                ans += timeSeries[i] + duration - expired;
            }
            //中毒后的持续时间
            expired = timeSeries[i] + duration;
        }
        return ans;
    }

}
