package leetcode;

/**
 * Package: leetcode
 * Description: Longest Palindromic Substring - Medium
 * Given a string s, return the longest palindromic substring in s.
 *
 * @Author ENZO
 * @Create 2024年4月20日 16:53
 *
 * 动态规划第一站:
 * 我理解的，从小到大开始，如果从短的时候它就是个回文字，那么向他左右各加相同的字母，同样也是回文字，一层一层筛选，dp[i][j]
 * 更像一个地图，由里至外，卷心菜一样，抽丝剥茧
 *


 */
public class Code005 {
    public class Solution {

        /**
         *  只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
         *  只要 dp[i][L] == false ，两种情况：1- s[i,j] 本身就不是回文串
         *                                  2- i > j 此时s[i,j] 不合法
         *  动态规划的状态转移方程：p(i,j) = p(i+1, j-1) ^ (Si == Sj)
         *       解释：只有s[i+1,j-1]是回文串，且s的第i个和第j个字母相同，s[i,j]才是回文串；
         *
         *  动态规划边界条件：p(i,j) = true
         *                   p(i,i+1) = (Si == Si+1)
         *
         *   最终答案为所有p(i,j) = true 中 j-i+1 的最大值
         *
         *   时间O(n2)：动态规划的状态数为O(n2)，对于每个状态，需转移时间为O(1)，空间复杂度O(n2)
         *
         * @param s
         * @return
         */

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            boolean[][] dp = new boolean[len][len];
            // 初始化：所有长度为 1 的子串都是回文串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            char[] charArray = s.toCharArray();
            // 递推开始
            // 先枚举子串长度
            for (int L = 2; L <= len; L++) {
                // 枚举左边界，左边界的上限设置可以宽松一些
                for (int i = 0; i < len; i++) {
                    // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                    int j = L + i - 1;
                    // 如果右边界越界，就可以退出当前循环
                    if (j >= len) {
                        break;
                    }

                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            //！！！！！！！！最关键的一步
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }
    }

}
