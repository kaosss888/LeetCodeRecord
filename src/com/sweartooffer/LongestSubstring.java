package com.sweartooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 至少有K个重复字符的最长子串
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 */
public class LongestSubstring {

//    public int longestSubstring(String s, int k) {
//
//        int max = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            int[] table = new int[26];
//            table[s.charAt(i) - 'a']++;
//            for (int j = i + 1; j < s.length(); j++) {
//                table[s.charAt(j) - 'a']++;
//                if (computeRepeat(table, k) && j - i + 1 > max) {
//                    max = j - i + 1;
//                }
//            }
//        }
//
//        return max;
//    }
//
//    public boolean computeRepeat(int[] table, int k) {
//        for (int i : table) {
//            if (i < k)
//                return false;
//        }
//        return true;
//    }

    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || k > len) return 0;
        if (k < 2) return len;

        return count(s.toCharArray(), k, 0, len - 1);
    }

    private static int count(char[] chars, int k, int p1, int p2) {
        if (p2 - p1 + 1 < k) return 0;
        int[] times = new int[26];  //  26个字母
        //  统计出现频次
        for (int i = p1; i <= p2; ++i) {
            ++times[chars[i] - 'a'];
        }
        //  如果该字符出现频次小于k，则不可能出现在结果子串中
        //  分别排除，然后挪动两个指针
        while (p2 - p1 + 1 >= k && times[chars[p1] - 'a'] < k) {
            ++p1;
        }
        while (p2 - p1 + 1 >= k && times[chars[p2] - 'a'] < k) {
            --p2;
        }

        if (p2 - p1 + 1 < k) return 0;
        //  得到临时子串，再递归处理
        for (int i = p1; i <= p2; ++i) {
            //  如果第i个不符合要求，切分成左右两段分别递归求得
            if (times[chars[i] - 'a'] < k) {
                return Math.max(count(chars, k, p1, i - 1), count(chars, k, i + 1, p2));
            }
        }
        return p2 - p1 + 1;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.longestSubstring("aabcabb", 2));
    }
}
