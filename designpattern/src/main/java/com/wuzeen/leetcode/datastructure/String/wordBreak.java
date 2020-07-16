package com.wuzeen.leetcode.datastructure.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: design_pattern
 * @description: 单词拆分
 * **题目描述：**
 *
 * 给定一个**非空**字符串 *s* 和一个包含**非空**单词列表的字典 *wordDict*，判定 *s* 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * **说明：**
 *
 * - 拆分时可以重复使用字典中的单词。
 * - 你可以假设字典中没有重复的单词。
 *
 * **示例 1：**
 *
 * ```
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * ```
 *
 * **示例 2：**
 *
 * ```
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * ```
 *
 * **示例 3：**
 *
 * ```html
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * ```
 *
 * @author: 吴泽恩
 * @create: 2020-07-16 21:53
 **/
public class wordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || "".equals(s)) {
            return true;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && wordDict.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
       String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("og");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
        System.out.println(wordBreak(s,wordDict));

        List<String> name = Arrays.asList("xxx","yyy","zzz");
        String sss = "xxxyyyyyyzzzzzz";
        System.out.println(wordBreak(sss,name));
    }
}
