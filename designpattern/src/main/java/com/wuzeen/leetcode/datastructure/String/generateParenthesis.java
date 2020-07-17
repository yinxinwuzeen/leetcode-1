package com.wuzeen.leetcode.datastructure.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design_pattern
 * @description: 生成括号
 * **题目描述：**
 *
 * 给出 *n* 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且**有效的**括号组合。
 *
 * 例如，给出 *n* = 3，生成结果为：
 *
 * ```HTML
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * ```
 * @author: 吴泽恩
 * @create: 2020-07-17 21:45
 **/
public class generateParenthesis {
    private static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        generate(0, 0, n, new StringBuilder());
        return res;
    }

    private static void generate(int l, int r, int n, StringBuilder sb) {
        if (l == r && l == n) {
            res.add(sb.toString());
            return;
        }
        if (l > r) {
            sb.append(')');
            generate(l, r + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (l < n) {
            sb.append('(');
            generate(l + 1, r, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
