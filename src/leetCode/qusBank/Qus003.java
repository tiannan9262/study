package leetCode.qusBank;

import java.util.HashSet;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4223 👎 0
public class Qus003 {
    // 滑动窗口法
    // 滑动窗⼝的右边界不断的右移，只要没有重复的字符，就持续向右扩⼤窗⼝边界。⼀旦出现了重复字
    // 符，就需要缩⼩左边界，直到重复的字符移出了左边界，然后继续移动滑动窗⼝的右边界。以此类推，
    // 每次移动需要计算当前⻓度，并判断是否需要更新最⼤⻓度，最终最⼤的值就是题⽬中的所求。
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")){
            return 0;
        }
        int maxSubLength = 0;
        HashSet<Character> set = new HashSet<Character>();
        char[] value = s.toCharArray();
        int i = 0;
        int j = 0;
        while (j < value.length){
            if (set.contains(value[j])){
                set.remove(value[i]);
                i ++;
            } else {
                set.add(value[j]);
                j ++;
                maxSubLength = Math.max(j - i, maxSubLength);
            }
        }
        return maxSubLength;
    }
}
