package com.wuzeen.leetcode.algorithm.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design_pattern
 * @description: 电话号码的字母组合
 * **题目描述：**
 *
 * 给定一个仅包含数字 `2-9` 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * ![img](http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)
 *
 * **示例:**
 *
 * ```
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * ```
 *
 * **说明:**
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * @author: 吴泽恩
 * @create: 2020-07-17 22:09
 **/
public class letterCombinations {
    private static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static List<String> res = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        dfs(digits, 0, new StringBuilder());
        return res;
    }

    private static void dfs(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char[] chs = map[digits.charAt(index) - '0'].toCharArray();
        for (char c : chs) {
            sb.append(c);
            dfs(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits ="23";
        System.out.println(letterCombinations(digits));
    }
}
