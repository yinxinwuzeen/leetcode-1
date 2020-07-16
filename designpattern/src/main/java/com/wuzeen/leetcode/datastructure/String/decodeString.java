package com.wuzeen.leetcode.datastructure.String;

import java.util.Stack;

/**
 * @program: design_pattern
 * @description: 字符串解码
 * **题目描述：**
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: `k[encoded_string]`，表示其中方括号内部的 *encoded_string* 正好重复 *k* 次。注意 *k* 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 *k* ，例如不会出现像 `3a` 或 `2[4]` 的输入。
 *
 * **示例:**
 *
 * ```
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * ```
 * @author: 吴泽恩
 * @create: 2020-07-16 22:14
 **/
public class decodeString {
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> stackMulti = new Stack<>();
        Stack<String> stackRes = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stackMulti.push(multi);
                stackRes.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curMulti = stackMulti.pop();
                for (int i = 0; i < curMulti; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stackRes.pop()).append(tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + c - '0';
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "2[a[]]6[q][w][]wwerbc3[cd]ef";
        String s2="3[a]2[bc]";
        String s3 = "3[a2[c]]";
        String s4 = "2[abc]3[cd]ef";
        System.out.println(decodeString(s1));
        System.out.println(decodeString(s2));
        System.out.println(decodeString(s3));
        System.out.println(decodeString(s4));
    }
}
