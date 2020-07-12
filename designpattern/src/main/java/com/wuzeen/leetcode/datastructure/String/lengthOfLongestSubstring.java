package com.wuzeen.leetcode.datastructure.String;

/**
 * @program: design_pattern
 * @description: 无重复字符的最长子串
 * **题目描述：**
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 **最长子串** 的长度。
 *
 * **示例 1:**
 *
 * ```
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * ```
 *
 * **示例 2:**
 *
 * ```
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * ```
 *
 * **示例 3:**
 *
 * ```
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * ```
 *
 * @author: 吴泽恩
 * @create: 2020-07-12 22:26
 **/
public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int l = 0, r = 0;
        int res = 0;
        while (l <= r && l < s.length()) {
            if (r < s.length() && map[s.charAt(r)] == 0) {
                map[s.charAt(r++)]++;
                res = Math.max(res, r - l);
            } else {
                map[s.charAt(l++)]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String test="sbjdhsdhsdiejdbdsadsldsadjkjsksdsadjsdjdjfh";
        System.out.println(lengthOfLongestSubstring(test));
    }
}
