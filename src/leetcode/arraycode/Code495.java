package leetcode.arraycode;

/**
 * Package: leetcode.arraycode
 * Description: Teemo Attacking - easy
 *
 * @Author ENZO
 * @Create 2024年4月22日 20:57
 */
public class Code495 {
    /**
     *
     *
     * @param timeSeries    在第timeSeries发起攻击
     * @param duration  中毒时间
     * @return  ans
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        //expired 上次中毒的结束时间
        int expired = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            //此时的时间 超过 上次中毒的结束时间 -> 未中毒
            if (timeSeries[i] >= expired) {
                //未中毒 总时间 + 中毒时间
                ans += duration;
            } else {
                //中毒后 总时间 + 中毒持续时间 - 中毒结束时间
                ans += timeSeries[i] + duration - expired;
            }
            //中毒后的结束时间
            expired = timeSeries[i] + duration;
        }
        return ans;
    }

}
