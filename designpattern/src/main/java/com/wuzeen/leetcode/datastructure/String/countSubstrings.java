package com.wuzeen.leetcode.datastructure.String;

/**
 * @program: design_pattern
 * @description: 回文子串
 * **题目描述：**
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * **示例 1:**
 *
 * ```
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * ```
 *
 * **示例 2:**
 *
 * ```
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * ```
 *
 * **注意:**
 *
 * 1. 输入的字符串长度不会超过1000。
 *
 * @author: 吴泽恩
 * @create: 2020-07-16 22:39
 **/
public class countSubstrings {
    private static  int res = 0;

    public  static void countSubstrings(String s) {
        if (s.length() == 0) {
            System.out.println(0);
//            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            find(s, i, i);
            find(s, i, i + 1);
        }
        System.out.println(res);
//        return res;
    }

    private  static  void find(String s, int i, int j) {
        while (i >= 0 && i < s.length() && j >= 0 && j < s.length() && s.charAt(i--) == s.charAt(j++)) {
            res++;
            //输出回文子串
            if(i<0) {
                int temp =i+1;
                System.out.println((temp+1) + "," + j+":"+s.substring(temp,j));
            }else{
                int temp =i+1;
                System.out.println((temp+1) + "," + j+":"+s.substring(temp,j));
            }
        }
    }

    public static void main(String[] args) {
        String s="aaaaabbbbbccccccbbbb";
        countSubstrings(s);
    }
}
